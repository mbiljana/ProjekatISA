package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.BoatOwner;
import com.example.ISAprojekat.Model.CottageOwner;

public interface CottageOwnerService {

    CottageOwner getByEmailAddressAndPassword(String emailAddress, String password);
    CottageOwner save (CottageOwner cottageOwner);
    CottageOwner getOne(Long id);
    CottageOwner getByUsernameAndPassword(String username, String password);
    CottageOwner findByUsername(String username);
}
