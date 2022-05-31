package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.BoatOwner;

import java.util.List;

public interface BoatOwnerService {

    BoatOwner getByEmailAddressAndPassword(String emailAddress, String password);
    BoatOwner save (BoatOwner boatOwner) throws Exception;
    List<BoatOwner> findAll();
    BoatOwner getOne(Long id);
}
