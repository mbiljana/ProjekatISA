package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.Boat;
import com.example.ISAprojekat.Model.BoatOwner;

import java.util.List;

public interface BoatService {


    List<Boat> findAll();
    Boat getOne(Long id);


}
