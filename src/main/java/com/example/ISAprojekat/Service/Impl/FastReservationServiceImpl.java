package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.*;
import com.example.ISAprojekat.Model.DTO.ReservationDTO;
import com.example.ISAprojekat.Repository.EntityRepository;
import com.example.ISAprojekat.Repository.FastReservationRepository;
import com.example.ISAprojekat.Service.EntityService;
import com.example.ISAprojekat.Service.FastReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FastReservationServiceImpl implements FastReservationService {

    @Autowired
    private EntityRepository entityRepository;

    @Autowired
    private FastReservationRepository reservationRepository;

    @Autowired
    private EntityService entityService;

    @Override
    public FastReservation getOne(Integer id) {
        FastReservation fastReservation = this.reservationRepository.findById(id).get();
        return fastReservation;
    }

    @Override
    public List<FastReservation> findAll() {
        List<FastReservation> fastReservations = this.reservationRepository.findAll();
        return fastReservations;
    }

    @Override
    public FastReservation create(FastReservation fastReservation) throws Exception {
        if(fastReservation.getId() != null){
            throw new Exception("ID must be unique!");
        }
        FastReservation newFR = this.reservationRepository.save(fastReservation);
        return  newFR;
    }

    /*@Override
    public Boolean isEntityBookedNow(Integer id) {
        List<FastReservation> reservations = fastReservationRepository.getReservationByRentingEntity_Id(id);
        for(FastReservation r : reservations) {
            if(r.getStartDate().before(new Date()) && r.getReservationEndTime().after(new Date()) && !r.getCanceled()) return true;
        }
        return false;
    }*/



    @Override
    public void delete(Integer id) {
        this.reservationRepository.deleteById(id);
    }

    @Transactional
    public Boolean Save(FastReservation reservation){
        try {
            reservation.setRentingEntity(this.entityRepository.findLockedById(reservation.getRentingEntity().getId()));
        } catch(PessimisticLockingFailureException ex) { throw  new PessimisticLockingFailureException("Owner already reserved this entity!"); }
        FastReservation updatedReservation=entityService.checkIfAlreadyReserved(reservation);
        if(updatedReservation==null)
            return false;
        if(!saveTransactional(updatedReservation)) return false;
        //mailService.sendReservationMail(updatedReservation);
        return true;
    }


    @Transactional(readOnly = false)
    public boolean saveTransactional(FastReservation reservation){
        try{
            FastReservation savedReservation = reservationRepository.save(reservation);
            RentingEntity entity = reservation.getRentingEntity();
            entity.getReservations().add(savedReservation);
            entityRepository.save(entity);
        }catch (ObjectOptimisticLockingFailureException e){
            return false;
        }catch(PessimisticLockingFailureException ex){
            return false;
        }
        return true;
    }
    /*
    @Transactional
    public List<ReservationDTO> getClientFutureReservations(String email){
        return reservationRepository.fetchByClientEmail(email,new Date());
    }

    public List<ReservationDTO> cancelReservation(Integer id,String email) {
        FastReservation reservation = reservationRepository.fetchWithUnavailablePeriods(id);
        reservation.setCanceled(true);
        reservationRepository.save(reservation);
        return getClientFutureReservations(email);
    }

    @Override
    public List<ReservationDTO> getHistoryOfReservations(String email,String classType){
        if(classType.equals("Adventure")) {
            List<ReservationDTO> r =reservationRepository.fetchHistoryByClientEmail(email,new Date(), Adventure.class);
            return reservationRepository.fetchHistoryByClientEmail(email,new Date(), Adventure.class);}
        else if(classType.equals("Cottage")) return reservationRepository.fetchHistoryByClientEmail(email,new Date(), Cottage.class);
        return reservationRepository.fetchHistoryByClientEmail(email,new Date(), Boat.class);
    }*/

    @Override
    public List<FastReservation> getReservationsByEntityId(Integer id) {
        return reservationRepository.getReservationByRentingEntity_Id(id).stream().filter(r -> r.getCanceled() == Boolean.FALSE).collect(Collectors.toList());
    }
    @Override
    public Boolean isEntityBookedNow(Integer id) {
        List<FastReservation> reservations = reservationRepository.getReservationByRentingEntity_Id(id);
        for(FastReservation r : reservations) {
            if(r.getStartDate().before(new Date()) && r.getReservationEndTime().after(new Date()) && !r.getCanceled()) return true;
        }
        return false;
    }
    @Override
    public List<FastReservation> getAllFinishedReservations() {
        List<FastReservation> reservations = reservationRepository.findAll();
        List<FastReservation> finishedReservations = new ArrayList<>();

        for(FastReservation r : reservations) {
            if(r.getReservationEndTime().before(new Date())) {
                finishedReservations.add(r);
            }
        }

        return finishedReservations;
    }
    @Override
    @Transactional
    public void saveTransactionalForTest(FastReservation reservation){
        try{
            entityRepository.save(reservation.getRentingEntity());
            reservationRepository.save(reservation);
        }catch (ObjectOptimisticLockingFailureException e){
            throw new ObjectOptimisticLockingFailureException("Entity is already reserved!",e);
        }
    }

    @Override
    @Transactional
    public ReservationDTO saveReservationCreatedByAdvertiser(FastReservation newReservation, Integer entityId) throws PessimisticLockingFailureException{
        try {
            RentingEntity entity = this.entityService.findLockedById(entityId);
        } catch(PessimisticLockingFailureException ex) { throw  new PessimisticLockingFailureException("Client already reserved this entity!"); }
        newReservation.setRentingEntity(this.entityService.findLockedById(entityId));
        List<FastReservation> entityReservations = this.reservationRepository.fetchByEntityId(newReservation.getRentingEntity().getId());
        FastReservation currentReservation = null;
        for(FastReservation r : entityReservations) {
            if (isEntityBooked(r)) {
                currentReservation = r;
                break;
            }
        }

        try{
            if (currentReservation.equals(null))
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You can only create reservation if there is a current reservation!");
        } catch (NullPointerException e) { throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You can only create reservation if there is a current reservation!"); }

        newReservation.setClient(currentReservation.getClient());
        FastReservation savedReservation = saveReservationIfThereIsNoOverlapping(newReservation);
        return new ReservationDTO(savedReservation.getStartDate(), savedReservation.getDuration(), savedReservation.getCapacity(), savedReservation.getPrice(), currentReservation.getCanceled(), entityId, savedReservation.getRentingEntity().getName());
    }

    @Override
    @Transactional
    public FastReservation saveReservationIfThereIsNoOverlapping(FastReservation newReservation) {
        if(newReservation.overlapsWithExistingUnavailablePeriods(this.entityRepository.fetchWithPeriods(newReservation.getRentingEntity().getId()).getUnavailablePeriods()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is already defined unavailable period in this time range!");

        if (newReservation.overlapsWithExistingReservations(this.reservationRepository.fetchByEntityName(newReservation.getRentingEntity().getName())))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is already defined reservation in this time range!");

        if(newReservation.overlapsWithExistingSales(this.entityRepository.fetchWithSales(newReservation.getRentingEntity().getId()).getSales()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is already defined sale in this time range!");

        return saveReservationAdv(newReservation);
    }
    @Override
    @Transactional
    public FastReservation saveReservationAdv(FastReservation newReservation) {
        try {
            FastReservation savedReservation = this.reservationRepository.save(newReservation);
            RentingEntity entity = newReservation.getRentingEntity();
            entity.getReservations().add(savedReservation);
            entityRepository.save(entity);
            return savedReservation;
        } catch (PessimisticLockingFailureException e) {
            throw new PessimisticLockingFailureException("Two or more access to database at the same time!", e);
        }
    }

    public boolean isEntityBooked(FastReservation r) {
        return r.getStartDate().before(new Date()) && r.getReservationEndTime().after(new Date()) && !r.getCanceled();
    }
}
