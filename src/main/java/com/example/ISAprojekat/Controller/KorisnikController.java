package com.example.ISAprojekat.Controller;


import com.example.ISAprojekat.Model.*;
import com.example.ISAprojekat.Model.DTO.*;
import com.example.ISAprojekat.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "api/korisnik")
public class KorisnikController {

    private final BoatOwnerService boatOwnerService;
    private final CottageOwnerService cottageOwnerService;
    private final ZahtevZaRegService zahtevZaRegService;
   private AdminService adminService;
    private KorisnikService korisnikService;

    @Autowired
    public KorisnikController(AdminService adminService, KorisnikService korisnikService,BoatOwnerService boatOwnerService, CottageOwnerService cottageOwnerService,ZahtevZaRegService zahtevZaRegService){
        this.adminService = adminService;
        this.korisnikService = korisnikService;
        this.boatOwnerService = boatOwnerService;
        this.cottageOwnerService = cottageOwnerService;
        this.zahtevZaRegService = zahtevZaRegService;
    }

    //ne znam sta ovo radi
    //logovanje admina kao provera
    @PostMapping(
            value =("/login"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PrijavaKorisnikaDTO> KorisnikLogin(@RequestBody PrijavljenKorisnikDTO korisnikLoginDTO) throws Exception {
        //Admin admin = this.adminService.getByUsernameAndPassword(korisnikLoginDTO.getUsername(), korisnikLoginDTO.getPassword());
        Korisnik korisnik = this.korisnikService.getByUsernameAndPassword(korisnikLoginDTO.getUsername(), korisnikLoginDTO.getPassword());
        PrijavaKorisnikaDTO korisnikDTO;
        if(korisnik == null){
            System.out.print("Admin je null");
        }

        korisnikDTO = new PrijavaKorisnikaDTO(korisnik.getName(), korisnik.getSurname(), korisnik.getEmailAddress(),
                korisnik.getPhoneNumber(), korisnik.getCity(), korisnik.getState(), korisnik.getHomeAddress(),
                korisnik.getBirthDate(), korisnik.getUsername(), korisnik.getPassword(), korisnik.getRole());
        return new ResponseEntity<>(korisnikDTO, HttpStatus.OK);
    }

    //izlistavanje svih korisnika
    @GetMapping(value = "/all")
    public ResponseEntity<List<KorisnikDTO>> getAllUsers() {

        List<Korisnik> korisnici = korisnikService.findAll();

        // convert boats to DTOs
        List<KorisnikDTO> korisniciDTO = new ArrayList<>();
        for (Korisnik a : korisnici) {
            korisniciDTO.add(new KorisnikDTO(a));
        }

        return new ResponseEntity<>(korisniciDTO, HttpStatus.OK);
    }





    @PostMapping(value="/registerOwner" ,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ZahtevZaRegDTO> createOwner(@RequestBody RegisterOwnerDTO DTO) throws Exception {
        Korisnik existing = this.korisnikService.getByEmailAddressAndPassword(DTO.getEmailAddress(), DTO.getPassword());
        //ako vec postoji clan
        if (existing != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }else {
            if (DTO.getPassword().equals(DTO.getPassword2())) {
                ZahtevZaReg zahtevZaReg = new ZahtevZaReg();
                zahtevZaReg.setCity(DTO.getCity());
                zahtevZaReg.setBirthDate(DTO.getBirthDate());
                zahtevZaReg.setEmailAddress(DTO.getEmailAddress());
                zahtevZaReg.setName(DTO.getName());
                zahtevZaReg.setRegType(DTO.getRegType());
                zahtevZaReg.setPassword(DTO.getPassword());
                zahtevZaReg.setState(DTO.getState());
                zahtevZaReg.setHomeAddress(DTO.getHomeAddress());
                zahtevZaReg.setPhoneNumber(DTO.getPhoneNumber());
                zahtevZaReg.setUsername(DTO.getUsername());
                zahtevZaReg.setSurname(DTO.getSurname());
                zahtevZaReg.setRazlog(DTO.getRazlog());
                ZahtevZaRegDTO zahtevZaRegDTO = new ZahtevZaRegDTO(DTO.getName(),DTO.getSurname(),
                        DTO.getEmailAddress(),DTO.getPhoneNumber(),DTO.getCity(),
                        DTO.getState(),DTO.getHomeAddress(),DTO.getBirthDate(),
                        DTO.getUsername(),DTO.getPassword(),DTO.getRegType(),DTO.getRazlog());
                this.zahtevZaRegService.save(zahtevZaReg);
                Admin admin = this.adminService.getByUsernameAndPassword("123","111");
                admin.zahtevi.add(zahtevZaReg);
                return new ResponseEntity<>(zahtevZaRegDTO, HttpStatus.OK);
            }else{
                System.out.println("Lozinke se ne poklapaju!");
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }

        }
    }

//login
    @PostMapping(value = "/userLogin", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PrijavaKorisnikaDTO>userLogin(@RequestBody PrijavljenKorisnikDTO kDTO) throws Exception{
        Admin admin = this.adminService.getByUsernameAndPassword(kDTO.getUsername(),kDTO.getPassword());
        BoatOwner boatOwner = this.boatOwnerService.getByUsernameAndPassword(kDTO.getUsername(),kDTO.getPassword());
        CottageOwner cottageOwner = this.cottageOwnerService.getByUsernameAndPassword(kDTO.getUsername(),kDTO.getPassword());

        PrijavaKorisnikaDTO prijavaDTO = new PrijavaKorisnikaDTO();

        if(admin != null){
            prijavaDTO = new PrijavaKorisnikaDTO(admin.getId(),admin.getName(),admin.getSurname(),
                    admin.getEmailAddress(),admin.getPhoneNumber(),admin.getCity(),admin.getState(),
                    admin.getHomeAddress(),admin.getBirthDate(),admin.getUsername(),
                    admin.getPassword(),admin.getRole());
            return new ResponseEntity<>(prijavaDTO,HttpStatus.OK);
        }else if(boatOwner != null){
            prijavaDTO = new PrijavaKorisnikaDTO(boatOwner.getId(),boatOwner.getName(),boatOwner.getSurname(),
                    boatOwner.getEmailAddress(),boatOwner.getPhoneNumber(),boatOwner.getCity(),boatOwner.getState(),
                    boatOwner.getHomeAddress(),boatOwner.getBirthDate(),boatOwner.getUsername(),
                    boatOwner.getPassword(),boatOwner.getRole());
            return new ResponseEntity<>(prijavaDTO,HttpStatus.OK);
        }else if(cottageOwner != null){
            prijavaDTO = new PrijavaKorisnikaDTO(cottageOwner.getId(),cottageOwner.getName(),cottageOwner.getSurname(),
                    cottageOwner.getEmailAddress(),cottageOwner.getPhoneNumber(),cottageOwner.getCity(),cottageOwner.getState(),
                    cottageOwner.getHomeAddress(),cottageOwner.getBirthDate(),cottageOwner.getUsername(),
                    cottageOwner.getPassword(),cottageOwner.getRole());
            return new ResponseEntity<>(prijavaDTO,HttpStatus.OK);
        }else{
            throw new Exception("Kredencijali nisu tacni ili korisnik nema nalog!");
        }
    }











}
