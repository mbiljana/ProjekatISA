package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.Cottage;
import com.example.ISAprojekat.Model.CottageOwner;
import com.example.ISAprojekat.Repository.CottageRepository;
import com.example.ISAprojekat.Service.CottageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CottageServiceImpl implements CottageService {

    private final CottageRepository cottageRepository;

    @Autowired
    public CottageServiceImpl(CottageRepository cottageRepository){
        this.cottageRepository = cottageRepository;
    }
    @Override
    public Cottage getOne(Long id) {
        Cottage cottage =  this.cottageRepository.findById(id).get();
        return cottage;
    }

    @Override
    public List<Cottage> findAll() {
        List<Cottage> cottages = this.cottageRepository.findAll();
        return cottages;
    }

    @Override
    public Cottage save(Cottage cottage) throws Exception {
        if(cottage.getId() != null){
            throw new Exception("ID must be unique!");
        }
        Cottage newCO = cottageRepository.save(cottage);
        return  newCO;
    }
}
