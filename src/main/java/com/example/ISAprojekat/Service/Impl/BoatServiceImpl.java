package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.Boat;
import com.example.ISAprojekat.Model.BoatOwner;
import com.example.ISAprojekat.Repository.BoatRepository;
import com.example.ISAprojekat.Service.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  BoatServiceImpl implements BoatService {

    @Autowired
    private BoatRepository boatRepository;


    @Override
    public List<Boat> findAll(){
        return boatRepository.findAll();
    }



}
