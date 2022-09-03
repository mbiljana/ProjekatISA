package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.FishingInstructor;
import com.example.ISAprojekat.Model.UnavailablePeriod;

import java.util.List;
import java.util.Set;

public interface FishingInstructorService {

    FishingInstructor save(FishingInstructor fishingInstructor) throws Exception;
    void delete(Integer id);
    Set<UnavailablePeriod> getAllUnavailablePeriodsForInstructor(String instructorEmail);
    public List<FishingInstructor> findAll();
    FishingInstructor update(FishingInstructor fishingInstructor) throws Exception;
    FishingInstructor findOne(Integer id);
    FishingInstructor getByEmailAddressAndPassword(String emailAddress, String password);

}
