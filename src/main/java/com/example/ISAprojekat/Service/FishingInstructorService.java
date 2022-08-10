package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.FishingInstructor;

import java.util.List;

public interface FishingInstructorService {

    FishingInstructor save(FishingInstructor fishingInstructor) throws Exception;
    void delete(Integer id);
    public List<FishingInstructor> findAll();
    FishingInstructor update(FishingInstructor fishingInstructor) throws Exception;
    FishingInstructor findOne(Integer id);
    FishingInstructor getByEmailAddressAndPassword(String emailAddress, String password);

}
