package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.Boat;
import com.example.ISAprojekat.Model.BoatReservation;
import com.example.ISAprojekat.Repository.BoatReservationRepository;
import com.example.ISAprojekat.Service.BoatReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoatReservationServiceImpl implements BoatReservationService {

    private final BoatReservationRepository boatReservationRepository;

    @Autowired
    public BoatReservationServiceImpl(BoatReservationRepository boatReservationRepository){
        this.boatReservationRepository = boatReservationRepository;
    }

    @Override
    public List<BoatReservation> findAll() {
        List<BoatReservation> boatReservations = this.boatReservationRepository.findAll();
        return boatReservations;
    }

    @Override
    public BoatReservation create(BoatReservation boatReservation) throws Exception{
        if(boatReservation.getId() != null){
            throw new Exception("Reservation must be unique");
        }
        BoatReservation newB = this.boatReservationRepository.save(boatReservation);
        return  newB;
    }

    @Override
    public void delete(Long idRes) {
        this.boatReservationRepository.deleteById(idRes);
    }
}
