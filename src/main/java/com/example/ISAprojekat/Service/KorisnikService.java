package com.example.ISAprojekat.Service;

public interface KorisnikService {

import com.example.ISAprojekat.Model.Admin;
import com.example.ISAprojekat.Model.Boat;
import com.example.ISAprojekat.Model.Korisnik;

import java.util.List;

public interface KorisnikService {
    Korisnik getByUsernameAndPassword(String username, String password);
    public List<Korisnik> findAll();

    Korisnik findOne(Long id);

    Korisnik update(Korisnik korisnik) throws Exception;

}
