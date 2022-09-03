package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.Adventure;

import java.io.IOException;
import java.util.List;

public interface AdventureService {
    List<Adventure> findAll();
    //List<Adventure> findAllByAdventureName(String adventureName);
    Adventure findByName(String name);
    Adventure findOne(Integer id);
    void save(Adventure adventure) throws IOException;
    void delete(Integer id);
    Adventure fetchById(Integer id) throws IOException;
    Adventure update(Adventure adventure) throws IOException;
    //List<Adventure> getAllAdventuresFromInstructor(String email);
}
