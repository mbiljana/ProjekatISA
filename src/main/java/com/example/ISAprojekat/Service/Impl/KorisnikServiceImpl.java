package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.*;
import com.example.ISAprojekat.Model.DTO.UserAuthentificationRequestDTO;
import com.example.ISAprojekat.Service.KorisnikService;
import com.example.ISAprojekat.Service.RoleService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.ISAprojekat.Repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class KorisnikServiceImpl implements KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleService roleService;

    @Override
    public Korisnik getByUsernameAndPassword(String username, String password) {
        Korisnik korisnik = this.korisnikRepository.findByUsernameAndPassword(username,password);
        return korisnik;
    }

    @Override
    public Korisnik getByEmailAddressAndPassword(String emailAddress, String password) {
        Korisnik korisnik =this.korisnikRepository.findByEmailAddressAndPassword(emailAddress,password);
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


    /*@Override
    public Korisnik save(Korisnik korisnik) throws Exception {
        if(korisnik.getId() != null){
            throw new Exception("ID must be unique!");
        }
        Korisnik newK = korisnikRepository.save(korisnik);
        return  newK;
    }*/

    @Override
    public Korisnik save(UserAuthentificationRequestDTO userRequest) {
        Korisnik u = new Korisnik();
        u.setUsername(userRequest.getUsername());

        // pre nego sto postavimo lozinku u atribut hesiramo je kako bi se u bazi nalazila hesirana lozinka
        // treba voditi racuna da se koristi isi password encoder bean koji je postavljen u AUthenticationManager-u kako bi koristili isti algoritam
        u.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        u.setName(userRequest.getName());
        u.setSurname(userRequest.getSurname());
        u.setEnabled(true);
        u.setEmailAddress(userRequest.getEmailAddress());

        // u primeru se registruju samo obicni korisnici i u skladu sa tim im se i dodeljuje samo rola USER
        List<Uloga> roles = roleService.findByName("ROLE_USER");
        u.setUloge(roles);

        return this.korisnikRepository.save(u);
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

    @Override
    public Korisnik modify(Korisnik korisnik) throws Exception {
        Korisnik updated = this.korisnikRepository.findById(korisnik.getId()).get();
        updated.setName(korisnik.getName());
        updated.setSurname(korisnik.getSurname());
        updated.setUsername(korisnik.getUsername());
        updated.setEmailAddress(korisnik.getEmailAddress());
        updated.setCity(korisnik.getCity());
        updated.setHomeAddress(korisnik.getHomeAddress());
        updated.setState(korisnik.getState());
        korisnik.setPhoneNumber(korisnik.getPhoneNumber());
        korisnik.setPassword(korisnik.getPassword());
        Korisnik promenjen = korisnikRepository.save(updated);
        return promenjen;
    }


    public Korisnik findByEmail(String username) throws UsernameNotFoundException {
        return korisnikRepository.findByEmailAddress(username);
    }



}
