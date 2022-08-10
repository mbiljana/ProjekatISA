package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.Boat;
import com.example.ISAprojekat.Model.BoatOwner;

import java.util.List;

public interface BoatService {


    List<Boat> findAll();
    Boat getOne(Integer id);
    Boat create(Boat boat) throws Exception;
    void delete(Integer id);
    Boat update(Boat boat);


}
