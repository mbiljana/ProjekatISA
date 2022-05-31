package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.Adventure;
import com.example.ISAprojekat.Model.FishingInstructor;

import java.util.List;

public interface FishingInstructorService {

    FishingInstructor save(FishingInstructor fishingInstructor) throws Exception;
    void delete(Long id);
    public List<FishingInstructor> findAll();
    FishingInstructor update(FishingInstructor fishingInstructor) throws Exception;
    FishingInstructor findOne(Long id);

}
