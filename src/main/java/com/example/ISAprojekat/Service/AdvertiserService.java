package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.Adventure;
import com.example.ISAprojekat.Model.Korisnik;

import java.util.List;

public interface AdvertiserService {
    Korisnik findAdvertiserByEntityId(Integer id);
    List<Adventure> findEntitiesByAdvertiserId(Integer id);
}
