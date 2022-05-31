package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.BoatOwner;
import com.example.ISAprojekat.Model.CottageOwner;
import com.example.ISAprojekat.Repository.BoatOwnerRepository;
import com.example.ISAprojekat.Repository.CottageOwnerRepository;
import com.example.ISAprojekat.Service.CottageOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CottageOwnerServiceImpl implements CottageOwnerService {

    private CottageOwnerRepository cottageOwnerRepository;

    @Autowired
    public CottageOwnerServiceImpl(CottageOwnerRepository cottageOwnerRepository){
        this.cottageOwnerRepository = cottageOwnerRepository;
    }


    @Override
    public CottageOwner getByEmailAddressAndPassword(String emailAddress, String password) {
        CottageOwner cottageOwner =this.cottageOwnerRepository.findByEmailAddressAndPassword(emailAddress,password);
        return cottageOwner;
    }

    @Override
    public CottageOwner save(CottageOwner cottageOwner) throws Exception {
        if(cottageOwner.getId() != null){
            throw new Exception("ID must be unique!");
        }
        CottageOwner newCO = cottageOwnerRepository.save(cottageOwner);
        return  newCO;
    }

    @Override
    public CottageOwner getOne(Long id) {
        CottageOwner cottageOwner = this.cottageOwnerRepository.findById(id).get();
        return cottageOwner;
    }

    @Override
    public CottageOwner getByUsernameAndPassword(String username, String password) {
        CottageOwner cottageOwner = this.cottageOwnerRepository.findByUsernameAndPassword(username,password);
        return cottageOwner;
    }
}
