package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Service.KorisnikService;
import org.springframework.stereotype.Service;
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
    @Override
    public Korisnik findOne(Long id) {

        Korisnik korisnik = this.korisnikRepository.findById(id).get();
        return korisnik;
    }

    @Override
    public Korisnik update (Korisnik korisnik) throws Exception{
        Korisnik updated = this.korisnikRepository.findById(korisnik.getId()).get();
        if(korisnik.getId() == null){
            throw  new Exception("Greska! Nepostojeci korisnik!");
        }
        updated.setName(korisnik.getName());
        updated.setSurname(korisnik.getSurname());
        updated.setUsername(korisnik.getUsername());
        updated.setEmailAddress(korisnik.getEmailAddress());
        updated.setRole(korisnik.getRole());
        Korisnik promenjen = korisnikRepository.save(updated);
        return promenjen;
    }

}
