package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.*;
import com.example.ISAprojekat.Repository.AdventureRepository;
import com.example.ISAprojekat.Repository.BoatRepository;
import com.example.ISAprojekat.Repository.CottageRepository;
import com.example.ISAprojekat.Service.AdvertiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AdvertiserServiceImpl implements AdvertiserService {
    @Autowired
    private CottageRepository cottageRepository;

    @Autowired
    private BoatRepository shipRepository;

    @Autowired
    private AdventureRepository adventureRepository;

    @Override
    public Korisnik findAdvertiserByEntityId(Integer id) {
        /*Cottage cottage = cottageRepository.fetchOwnerByCottageId(id);
        if (cottage != null) return cottage.getCottageOwner();

        Boat ship = shipRepository.fetchOwnerByShipId(id);
        if (ship != null) return ship.getShipOwner();*/

        Adventure adventure = adventureRepository.fetchInstructorByAdventureId(id);
        if (adventure != null) return adventure.getFishingInstructor();

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No such entity!");
    }

    @Override
    public List<Adventure> findEntitiesByAdvertiserId(Integer id) {
        /*List<Cottage> cottages = cottageRepository.getCottagesByCottageOwner_Id(id);
        if (cottages.size() > 0) return cottages;

        List<Ship> ships = shipRepository.getShipsByShipOwner_Id(id);
        if (ships.size() > 0) return ships;*/

        List<Adventure> adventures = adventureRepository.getAdventuresByFishingInstructor_Id(id);
        if (adventures.size() > 0)
            return adventures;


        return adventures;
    }
}
