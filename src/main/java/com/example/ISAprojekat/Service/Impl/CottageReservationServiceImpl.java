package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.BoatReservation;
import com.example.ISAprojekat.Model.CottageReservation;
import com.example.ISAprojekat.Repository.CottageReservationRepository;
import com.example.ISAprojekat.Service.CottageReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CottageReservationServiceImpl implements CottageReservationService {

    private final CottageReservationRepository cottageReservationRepository;

    @Autowired
    public CottageReservationServiceImpl(CottageReservationRepository cottageReservationRepository){
        this.cottageReservationRepository = cottageReservationRepository;
    }

    @Override
    public List<CottageReservation> findAll() {
        List<CottageReservation> cottageReservations = this.cottageReservationRepository.findAll();
        return cottageReservations;
    }

    @Override
    public CottageReservation create(CottageReservation cottageReservation) throws Exception {
        if(cottageReservation.getId() != null){
            throw new Exception("Reservation must be unique");
        }
        CottageReservation newB = this.cottageReservationRepository.save(cottageReservation);
        return  newB;
    }

    @Override
    public void delete(Long idRes) {
        this.cottageReservationRepository.deleteById(idRes);
    }
}
