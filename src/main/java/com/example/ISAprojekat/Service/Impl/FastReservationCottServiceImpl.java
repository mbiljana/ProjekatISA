package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.FastReservation;
import com.example.ISAprojekat.Model.FastReservationCott;
import com.example.ISAprojekat.Repository.FastReservationCottRepository;
import com.example.ISAprojekat.Repository.FastReservationRepository;
import com.example.ISAprojekat.Service.FastReservationCottService;
import com.example.ISAprojekat.Service.FastReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FastReservationCottServiceImpl implements FastReservationCottService {

    private final FastReservationCottRepository fastReservationCottRepository;
    @Autowired
    public FastReservationCottServiceImpl(FastReservationCottRepository fastReservationRepository){
        this.fastReservationCottRepository = fastReservationRepository;
    }

    @Override
    public FastReservationCott getOne(Long id) {
        FastReservationCott fastReservationCott = this.fastReservationCottRepository.findById(id).get();
        return fastReservationCott;
    }

    @Override
    public List<FastReservationCott> findAll() {
        List<FastReservationCott> fastReservationCotts = this.fastReservationCottRepository.findAll();
        return fastReservationCotts;
    }

    @Override
    public FastReservationCott create(FastReservationCott fastReservation) throws Exception {
        if(fastReservation.getId() != null){
            throw new Exception("ID must be unique!");
        }
        FastReservationCott newFR = this.fastReservationCottRepository.save(fastReservation);
        return  newFR;
    }

    @Override
    public void delete(Long id) {
        this.fastReservationCottRepository.deleteById(id);
    }
}
