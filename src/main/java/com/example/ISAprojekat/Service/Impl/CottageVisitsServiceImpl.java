package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.CottageVisits;
import com.example.ISAprojekat.Repository.CottageVisitsRepository;
import com.example.ISAprojekat.Service.CottageVisitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CottageVisitsServiceImpl implements CottageVisitsService {

    private final CottageVisitsRepository cottageVisitsRepository;
    @Autowired
    public CottageVisitsServiceImpl(CottageVisitsRepository cottageVisitsRepository){
        this.cottageVisitsRepository = cottageVisitsRepository;
    }

    @Override
    public List<CottageVisits> findAll() {
        return this.cottageVisitsRepository.findAll();
    }

    @Override
    public CottageVisits save(CottageVisits cottageVisits) {
        return this.cottageVisitsRepository.save(cottageVisits);
    }
}
