package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.BoatOwner;
import com.example.ISAprojekat.Model.CottageOwner;

public interface CottageOwnerService {

    CottageOwner getByEmailAddressAndPassword(String emailAddress, String password);
    CottageOwner save (CottageOwner cottageOwner) throws Exception;
    CottageOwner getOne(Long id);
}
