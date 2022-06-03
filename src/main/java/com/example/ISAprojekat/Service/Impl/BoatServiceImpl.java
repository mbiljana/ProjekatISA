package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.Boat;
import com.example.ISAprojekat.Model.BoatOwner;
import com.example.ISAprojekat.Model.FastReservation;
import com.example.ISAprojekat.Repository.BoatRepository;
import com.example.ISAprojekat.Service.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  BoatServiceImpl implements BoatService {

    private final BoatRepository boatRepository;
    @Autowired
    public BoatServiceImpl(BoatRepository boatRepository){
        this.boatRepository = boatRepository;
    }


    @Override
    public List<Boat> findAll(){
        return boatRepository.findAll();
    }

    @Override
    public Boat getOne(Long id) {
        Boat boat = this.boatRepository.findById(id).get();
        return boat;
    }

    @Override
    public Boat create(Boat boat) throws Exception {
        if(boat.getId() != null){
            throw new Exception("ID must be unique!");
        }
        Boat newB = this.boatRepository.save(boat);
        return  newB;
    }

    @Override
    public void delete(Long id) {
        this.boatRepository.deleteById(id);
    }

    @Override
    public Boat update(Boat boat) {
        return null;
    }


}
