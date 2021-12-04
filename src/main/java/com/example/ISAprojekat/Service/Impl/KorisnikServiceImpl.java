package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.Admin;
import com.example.ISAprojekat.Model.Boat;
import com.example.ISAprojekat.Model.Korisnik;
import com.example.ISAprojekat.Repository.AdminRepository;
import com.example.ISAprojekat.Repository.KorisnikRepository;
import com.example.ISAprojekat.Service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KorisnikServiceImpl implements KorisnikService {
    private final KorisnikRepository korisnikRepository;

    @Autowired
    public KorisnikServiceImpl(KorisnikRepository korisnikRepository){
        this.korisnikRepository = korisnikRepository;
    }

    @Override
    public Korisnik getByUsernameAndPassword(String username, String password) {
        Korisnik korisnik = this.korisnikRepository.findByUsernameAndPassword(username,password);
        return korisnik;
    }
    @Override
    public List<Korisnik> findAll(){
        return korisnikRepository.findAll();
    }


}
