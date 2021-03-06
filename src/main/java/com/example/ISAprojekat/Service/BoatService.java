package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.Boat;
import com.example.ISAprojekat.Model.BoatOwner;

import java.util.List;

public interface BoatService {


    List<Boat> findAll();
    Boat getOne(Long id);
    Boat create(Boat boat) throws Exception;
    void delete(Long id);
    Boat update(Boat boat);


}
