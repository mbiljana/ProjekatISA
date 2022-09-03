package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.BoatVisits;

import java.util.List;

public interface BoatVisitsService {

    List<BoatVisits> findAll();
    BoatVisits save (BoatVisits boatVisits);
}
