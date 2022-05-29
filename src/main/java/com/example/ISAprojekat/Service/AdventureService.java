package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.Adventure;

import java.util.List;

public interface AdventureService {
    public List<Adventure> findAll();
    List<Adventure> findAllByAdventureName(String adventureName);
    Adventure findOne(Long id);
    Adventure save(Adventure adventure) throws Exception;
    void delete(Long id);
    Adventure update(Adventure adventure) throws Exception;
}
