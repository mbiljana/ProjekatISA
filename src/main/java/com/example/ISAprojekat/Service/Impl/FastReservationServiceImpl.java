package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.CottageOwner;
import com.example.ISAprojekat.Model.FastReservation;
import com.example.ISAprojekat.Repository.FastReservationRepository;
import com.example.ISAprojekat.Service.FastReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FastReservationServiceImpl implements FastReservationService {

    private final FastReservationRepository fastReservationRepository;
    @Autowired
    public FastReservationServiceImpl(FastReservationRepository fastReservationRepository){
        this.fastReservationRepository = fastReservationRepository;
    }

    @Override
    public FastReservation getOne(Integer id) {
        FastReservation fastReservation = this.fastReservationRepository.findById(id).get();
        return fastReservation;
    }

    @Override
    public List<FastReservation> findAll() {
        List<FastReservation> fastReservations = this.fastReservationRepository.findAll();
        return fastReservations;
    }

    @Override
    public FastReservation create(FastReservation fastReservation) throws Exception {
        if(fastReservation.getId() != null){
            throw new Exception("ID must be unique!");
        }
        FastReservation newFR = this.fastReservationRepository.save(fastReservation);
        return  newFR;
    }

    @Override
    public Boolean isEntityBookedNow(Integer id) {
        List<FastReservation> reservations = fastReservationRepository.getReservationByRentingEntity_Id(id);
        for(FastReservation r : reservations) {
            if(r.getStartDate().before(new Date()) && r.getReservationEndTime().after(new Date()) && !r.getCanceled()) return true;
        }
        return false;
    }



    @Override
    public void delete(Integer id) {
        this.fastReservationRepository.deleteById(id);
    }
}
