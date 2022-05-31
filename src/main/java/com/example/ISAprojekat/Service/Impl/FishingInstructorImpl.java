package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.FishingInstructor;
import com.example.ISAprojekat.Repository.FishingInstructorRepository;
import com.example.ISAprojekat.Service.FishingInstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FishingInstructorImpl implements FishingInstructorService {
    private final FishingInstructorRepository fishingInstructorRepository;

    @Autowired
    public FishingInstructorImpl(FishingInstructorRepository fishingInstructorRepository){
        this.fishingInstructorRepository = fishingInstructorRepository;
    }

    @Override
    public FishingInstructor save(FishingInstructor fishingInstructor) throws Exception {
        if(fishingInstructor.getId() != null){
            throw new Exception("ID mora biti jedinstven");
        }
        FishingInstructor noviTrening = fishingInstructorRepository.save(fishingInstructor);
        return  noviTrening;
    }


    @Override
    public void delete(Long id) {

    }

    @Override
    public List<FishingInstructor> findAll(){
        return fishingInstructorRepository.findAll();
    }

    /*@Override
    public List<AdventureAppointment> findAllAdventures(){
        return fishingInstructorRepository.findAllAdventures();
    }*/


    @Override
    public FishingInstructor findOne(Long id){
        FishingInstructor fishingInstructor = this.fishingInstructorRepository.findById(id).get();
        return fishingInstructor;
        //return treningRepository.getOne(id);
    }

    @Override
    public FishingInstructor update(FishingInstructor fishingInstructor) throws Exception {
        FishingInstructor uslugaZaIzmenu = this.fishingInstructorRepository.findById(fishingInstructor.getId()).get();
        if(fishingInstructor.getId() == null) {
            throw new Exception("Trening ne postoji");
        }
        uslugaZaIzmenu.setName(fishingInstructor.getName());
        uslugaZaIzmenu.setEmailAddress(fishingInstructor.getEmailAddress());
        uslugaZaIzmenu.setRole(fishingInstructor.getRole());
        uslugaZaIzmenu.setUsername(fishingInstructor.getUsername());
        uslugaZaIzmenu.setSurname(fishingInstructor.getSurname());
        uslugaZaIzmenu.setCity(fishingInstructor.getCity());
        uslugaZaIzmenu.setBirthDate(fishingInstructor.getBirthDate());
        uslugaZaIzmenu.setHomeAddress(fishingInstructor.getHomeAddress());
        uslugaZaIzmenu.setPassword(fishingInstructor.getPassword());
        uslugaZaIzmenu.setPhoneNumber(fishingInstructor.getPhoneNumber());
        uslugaZaIzmenu.setState(fishingInstructor.getState());


        FishingInstructor izmenjenaUsluga = this.fishingInstructorRepository.save(uslugaZaIzmenu);
        return izmenjenaUsluga;
    }



}
