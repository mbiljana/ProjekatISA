package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.FishingInstructor;

import java.util.List;

public interface FishingInstructorService {

    FishingInstructor save(FishingInstructor fishingInstructor) throws Exception;
    void delete(Long id);
    public List<FishingInstructor> findAll();
    //public List<AdventureAppointment> findAllAdventures();
    FishingInstructor update(FishingInstructor fishingInstructor) throws Exception;
    FishingInstructor findOne(Long id);

}
