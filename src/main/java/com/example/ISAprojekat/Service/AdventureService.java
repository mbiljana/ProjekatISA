package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.Adventure;

import java.util.List;

public interface AdventureService {
    List<Adventure> findAll();
    List<Adventure> findAllByAdventureName(String adventureName);
    Adventure findOne(Integer id);
    Adventure save(Adventure adventure) throws Exception;
    void delete(Integer id);
    Adventure update(Adventure adventure) throws Exception;
    List<Adventure> getAllAdventuresFromInstructor(String email);
}
