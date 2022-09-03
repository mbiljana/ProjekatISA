package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.CottageVisits;

import java.util.List;

public interface CottageVisitsService {

    List<CottageVisits> findAll();
    CottageVisits save(CottageVisits cottageVisits);
}
