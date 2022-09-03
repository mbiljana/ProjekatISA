package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.BoatVisits;
import com.example.ISAprojekat.Repository.BoatVisitsRepository;
import com.example.ISAprojekat.Service.BoatVisitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoatVisitsServiceImpl implements BoatVisitsService {

    private final BoatVisitsRepository boatVisitsRepository;

    @Autowired
    public BoatVisitsServiceImpl(BoatVisitsRepository boatVisitsRepository){
        this.boatVisitsRepository = boatVisitsRepository;
    }

    @Override
    public List<BoatVisits> findAll() {
        return this.boatVisitsRepository.findAll();
    }

    @Override
    public BoatVisits save(BoatVisits boatVisits) {
        return this.boatVisitsRepository.save(boatVisits);
    }
}
