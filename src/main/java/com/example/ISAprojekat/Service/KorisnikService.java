package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.Admin;
import com.example.ISAprojekat.Model.Boat;
import com.example.ISAprojekat.Model.BoatOwner;
import com.example.ISAprojekat.Model.DTO.UserAuthentificationRequestDTO;
import com.example.ISAprojekat.Model.Korisnik;

import java.util.List;

public interface KorisnikService {
    Korisnik getByUsernameAndPassword(String username, String password);
    Korisnik getByEmailAddressAndPassword(String emailAddress, String password);
    public List<Korisnik> findAll();
    Korisnik findOne(Long id);
    Korisnik update(Korisnik korisnik) throws Exception;
    Korisnik modify(Korisnik korisnik) throws Exception;
    Korisnik save(UserAuthentificationRequestDTO userRequest);
    //Korisnik save(Korisnik korisnik) throws Exception;
    //Korisnik findByEmailAddress(String email);
}
