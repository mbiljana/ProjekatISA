package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.BoatOwner;
import com.example.ISAprojekat.Repository.BoatOwnerRepository;
import com.example.ISAprojekat.Service.BoatOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoatOwnerServiceImpl implements BoatOwnerService {

    private BoatOwnerRepository boatOwnerRepository;

    @Autowired
    public BoatOwnerServiceImpl(BoatOwnerRepository boatOwnerRepository){
        this.boatOwnerRepository = boatOwnerRepository;
    }


    @Override
    public BoatOwner getByEmailAddressAndPassword(String emailAddress, String password) {
            BoatOwner boatOwner =this.boatOwnerRepository.findByEmailAddressAndPassword(emailAddress,password);
            return boatOwner;
    }

    @Override
    public BoatOwner save(BoatOwner boatOwner) throws Exception {
        if(boatOwner.getId() != null){
            throw new Exception("ID must be unique!");
        }
        BoatOwner newBO = boatOwnerRepository.save(boatOwner);
        return  newBO;
    }

    @Override
    public List<BoatOwner> findAll() {
        List<BoatOwner> boatOwners = this.boatOwnerRepository.findAll();
        return boatOwners;
    }

    @Override
    public BoatOwner getOne(Long id) {
        BoatOwner boatOwner = this.boatOwnerRepository.findById(id).get();
        return boatOwner;
    }

    @Override
    public BoatOwner getByUsernameAndPassword(String username, String password) {
        BoatOwner boatOwner = this.boatOwnerRepository.findByUsernameAndPassword(username,password);
        return boatOwner;
    }
}
