package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.BoatOwner;

public interface BoatOwnerService {

    BoatOwner getByEmailAddressAndPassword(String emailAddress, String password);
    BoatOwner save (BoatOwner boatOwner) throws Exception;
}
