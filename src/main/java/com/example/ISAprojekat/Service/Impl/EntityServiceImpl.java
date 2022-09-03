package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.*;
import com.example.ISAprojekat.Repository.*;
import com.example.ISAprojekat.Service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.Cacheable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntityServiceImpl implements EntityService {
    @Autowired
    private EntityRepository entityRepository;

    @Autowired
    private KorisnikRepository userRepository;

    @Autowired
    private FastReservationRepository reservationRepository;

    @Autowired
    private RevisionRepository revisionRepository;

    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private ReportRepository reportRepository;

    @Override
    public List<? extends RentingEntity> GetAllEntities(int state){
        List<? extends RentingEntity> entities=null;
        if(state==0)entities=entityRepository.getEntityByClass(Adventure.class);
        else if(state==1)entities=entityRepository.getEntityByClass(Boat.class);
        else if(state==2) entities=entityRepository.getEntityByClass(Cottage.class);
        return entities;
    }
    @Override
    //@Cacheable("entity")
    public RentingEntity getEntityById(Integer id) {
        return entityRepository.findById(id).get();
    }

    /*public List<? extends RentingEntity> GetByUsersSubscriptions(String email) {
        return entityRepository.findSubscriptions(email);
    }*/

    @Override
    @Transactional
    public RentingEntity findLockedById(Integer id){
        return entityRepository.findLockedById(id);
    }

    /*@Transactional
    @CacheEvict(cacheNames = "entity", key = "#id")
    public void deleteEntity(Integer id) {
        if(isEntityBooked(id)) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Entity is now booked.");

        List<Client> clients = userRepository.fetchAllClients();

        for (Client c : clients) {
            for(RentingEntity e : c.getSubscriptions()) {
                if(e.getId() == id){
                    c.getSubscriptions().remove(e);
                    userRepository.save(c);
                    break;
                }
            }
        }

        entityRepository.deleteById(id);
    }*/

    private boolean isEntityBooked(Integer id) {
        List<FastReservation> reservations = reservationRepository.getReservationByRentingEntity_Id(id);
        for(FastReservation r : reservations) {
            if (r.getStartDate().before(new Date()) && r.getReservationEndTime().after(new Date()) && !r.getCanceled())
                return true;
        }
        for(FastReservation r : reservations) {
            revisionRepository.deleteAllByReservation_Id(r.getId());
            complaintRepository.deleteAllByRentingEntity_Id(r.getId());
            reportRepository.deleteAllByRentingEntity_Id(r.getId());
            reservationRepository.delete(r);
        }
        return false;
    }
    @Override
    public FastReservation checkIfAlreadyReserved(FastReservation reservation) {
        Date endDate = getEndDate(reservation.getStartDate(),reservation.getDuration());
        if(!checkOverlappingDates(reservation,endDate)){
            return reservation;
        }
        return null;
    }

    private boolean checkOverlappingDates(FastReservation reservation, Date endDate) {
        if (checkEntityPeriods(reservation, endDate)) return true;
        if (checkReservationPeriods(reservation, endDate)) return true;
        if(checkFishingInstructorPeriods(reservation,endDate)) return true;
        return false;
    }
    private boolean checkFishingInstructorPeriods(FastReservation reservation,Date endDate){
        FishingInstructor instructor = userRepository.fetchByAdventureId(reservation.getRentingEntity().getId());
        if(instructor == null) return false;
        for (UnavailablePeriod period : instructor.getUnavailablePeriods())
            if (period.getFromDateTime().compareTo(endDate) <= 0 &&
                    period.getToDateTime().compareTo(reservation.getStartDate()) >= 0)
                return true;
        return false;
    }

    private boolean checkReservationPeriods(FastReservation reservation, Date endDate) {
        for(FastReservation dbReservation: reservationRepository.getReservationByRentingEntity_Id(reservation.getRentingEntity().getId())){
            Date dbEndDate =getEndDate(dbReservation.getStartDate(),dbReservation.getDuration());
            if(dbReservation.getStartDate().compareTo(endDate) <=0 &&
                    dbEndDate.compareTo(reservation.getStartDate())>=0)
                return true;
        }
        return false;
    }

    private boolean checkEntityPeriods(FastReservation reservation, Date endDate) {
        for(UnavailablePeriod period : reservation.getRentingEntity().getUnavailablePeriods())
            if(period.getFromDateTime().compareTo(endDate) <=0 &&
                    period.getToDateTime().compareTo(reservation.getStartDate())>=0)
                return true;
        return false;
    }

    private Date getEndDate(Date fromDate,Integer durationInHours) {
        Calendar c = Calendar.getInstance();
        c.setTime(fromDate);
        c.add(Calendar.HOUR_OF_DAY,durationInHours);
        Date endDate= c.getTime();
        return endDate;
    }
    @Override
    @Transactional(readOnly = true)
    public RentingEntity fetchWithUnavailablePeriods(Integer id){
        return entityRepository.fetchWithPeriods(id);
    }
    @Override
    @Transactional(readOnly = true)
    public RentingEntity fetchWithSales (Integer id) { return entityRepository.fetchWithSales(id); }
    @Override
    public boolean checkIfSubscribed(String email,Integer entityId){
        RentingEntity e = entityRepository.checkIfSubscribed(email,entityId);
        if(e == null) return false;
        return true;
    }
    @Override
    public List<? extends RentingEntity> getEntitiesOnSale(int state){
        List<? extends RentingEntity> entities=null;
        if(state==0)entities=entityRepository.getEntitiesOnSale(Adventure.class);
        else if(state==1)entities=entityRepository.getEntitiesOnSale(Boat.class);
        else if(state==2) entities=entityRepository.getEntitiesOnSale(Cottage.class);
        return entities;
    }
    @Override
    public List<? extends RentingEntity> getAvailableEntities(UnavailablePeriod unavailablePeriod,int state){
        List<? extends RentingEntity> entities=null;
        if(state==0)entities=entityRepository.getEntityByClassWithPeriods(Adventure.class);
        else if(state==1)entities=entityRepository.getEntityByClassWithPeriods(Boat.class);
        else if(state==2) entities=entityRepository.getEntityByClassWithPeriods(Cottage.class);
        entities=entities
                .stream()
                .filter(e-> !checkOverlappingDates(e,unavailablePeriod) && instructorAvailable(e,unavailablePeriod)
                        && !checkReservationPeriods(e,unavailablePeriod))
                .collect(Collectors.toList());
        return entities;
    }

    private boolean instructorAvailable(RentingEntity e, UnavailablePeriod unavailablePeriod) {
        FishingInstructor instructor = userRepository.fetchByAdventureId(e.getId());
        if(instructor == null) return true;
        for (UnavailablePeriod period : instructor.getUnavailablePeriods())
            if (period.getFromDateTime().compareTo(unavailablePeriod.getToDateTime()) <= 0 &&
                    period.getToDateTime().compareTo(unavailablePeriod.getFromDateTime()) >= 0)
                return false;
        return true;
    }
    private boolean checkReservationPeriods(RentingEntity entity,UnavailablePeriod unavailablePeriod) {
        for(FastReservation dbReservation: reservationRepository.getReservationByRentingEntity_Id(entity.getId())){
            Date dbEndDate =getEndDate(dbReservation.getStartDate(),dbReservation.getDuration());
            if(dbReservation.getStartDate().compareTo(unavailablePeriod.getToDateTime()) <=0 &&
                    dbEndDate.compareTo(unavailablePeriod.getFromDateTime())>=0)
                return true;
        }
        return false;
    }

    private boolean checkOverlappingDates(RentingEntity e, UnavailablePeriod unavailablePeriod) {
        for(UnavailablePeriod period : e.getUnavailablePeriods())
            if(period.getFromDateTime().compareTo(unavailablePeriod.getToDateTime()) <=0 &&
                    period.getToDateTime().compareTo(unavailablePeriod.getFromDateTime())>=0)
                return true;
        return false;
    }

}
