package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.*;
import com.example.ISAprojekat.Repository.BoatRepository;
import com.example.ISAprojekat.Repository.BoatReservationRepository;
import com.example.ISAprojekat.Service.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
import java.util.Date;
import java.util.List;

@Service
public class  BoatServiceImpl implements BoatService {

    private final BoatRepository boatRepository;
    private final BoatReservationRepository boatReservationRepository;
    @Autowired
    public BoatServiceImpl(BoatRepository boatRepository,BoatReservationRepository boatReservationRepository){
        this.boatRepository = boatRepository;
        this.boatReservationRepository = boatReservationRepository;
    }


    @Override
    public List<Boat> findAll(){
        return boatRepository.findAll();
    }

    @Override
    public Boat getOne(Long id) {
        Boat boat = this.boatRepository.findById(id).get();
        return boat;
    }

    @Override
    public Boat create(Boat boat) throws Exception {
        if(boat.getId() != null){
            throw new Exception("ID must be unique!");
        }
        //String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        //boat.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        Boat newB = this.boatRepository.save(boat);
        return  newB;
    }

    @Override
    public void delete(Long id) {
        this.boatRepository.deleteById(id);
    }

    @Override
    public Boat update(Boat boat) {
        Boat newBoat = this.boatRepository.save(boat);
        return newBoat;
    }

    @Override
    public Boat save(Boat boat) {
        return this.boatRepository.save(boat);
    }


    @Override
    public BoatReservation checkIfAlreadyReserved(BoatReservation reservation) {
        Date endDate = reservation.getEndDate();

       // if(!checkOverlappingDates(reservation,endDate)){
            return reservation;
       // }
       // return null;
    }

    /*
    private boolean checkReservationPeriods(BoatReservation reservation, Date endDate) {
        for(BoatReservation dbReservation: boatReservationRepository.findBoatReservationByBoat(reservation.getBoat().getId())){
            Date dbEndDate =getEndDate(dbReservation.getDateTime(),dbReservation.getDurationInHours());
            if(dbReservation.getDateTime().compareTo(endDate) <=0 &&
                    dbEndDate.compareTo(reservation.getDateTime())>=0)
                return true;
        }
        return false;
    }

     */



}
