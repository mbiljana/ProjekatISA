package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.DTO.IzmenaProfilaDTO;
import com.example.ISAprojekat.Model.DTO.KorisnikDTO;
import com.example.ISAprojekat.Model.DTO.UserAuthentificationRequestDTO;
import com.example.ISAprojekat.Model.Korisnik;

import java.util.List;

public interface KorisnikService {
    Korisnik getByUsernameAndPassword(String username, String password);
    Korisnik getByUsername(String username);
    Korisnik getByEmailAddressAndPassword(String emailAddress, String password);
    KorisnikDTO getProfileInfo(String username);
    Korisnik getByEmailAddress(String email);
    public List<Korisnik> findAll();
    Korisnik findOne(Integer id);
    Korisnik update(Korisnik korisnik) throws Exception;
    void updateDTO(IzmenaProfilaDTO korisnik) throws Exception;
    //void updatePassword(String username, String Password);
    boolean hasAdminChangedInitialPassword(String email);
    Korisnik modify(Korisnik korisnik) throws Exception;
    //Korisnik save(UserAuthentificationRequestDTO userRequest);
    //Korisnik save(Korisnik korisnik) throws Exception;
    //Korisnik findByEmailAddress(String email);
}
