package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.*;
import com.example.ISAprojekat.Repository.BoatRepository;
import com.example.ISAprojekat.Repository.BoatReservationRepository;
import com.example.ISAprojekat.Service.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
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
        Boat newB = this.boatRepository.save(boat);
        return  newB;
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Boat boat = new Boat();
        try {
            boat =  this.boatRepository.findLockedById(id);
        } catch(PessimisticLockingFailureException ex) { throw  new PessimisticLockingFailureException("This boat is already reserved!!"); }

        this.boatRepository.deleteById(boat.getId());
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
            return reservation;
    }




}
