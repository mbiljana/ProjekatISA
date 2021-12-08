package com.example.ISAprojekat.Controller;


import com.example.ISAprojekat.Model.BoatOwner;
import com.example.ISAprojekat.Model.CottageOwner;
import com.example.ISAprojekat.Model.DTO.RegisterOwnerDTO;
import com.example.ISAprojekat.Model.Role;
import com.example.ISAprojekat.Service.BoatOwnerService;
import com.example.ISAprojekat.Service.CottageOwnerService;
import com.example.ISAprojekat.Model.Admin;
import com.example.ISAprojekat.Model.DTO.AdminDTO;
import com.example.ISAprojekat.Model.DTO.KorisnikDTO;
import com.example.ISAprojekat.Model.DTO.PrijavaKorisnikaDTO;
import com.example.ISAprojekat.Model.DTO.PrijavljenKorisnikDTO;
import com.example.ISAprojekat.Model.Korisnik;
import com.example.ISAprojekat.Service.AdminService;
import com.example.ISAprojekat.Service.KorisnikService;
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
   private AdminService adminService;
    private KorisnikService korisnikService;
  
    

    @Autowired
    public KorisnikController(AdminService adminService, KorisnikService korisnikService,BoatOwnerService boatOwnerService, CottageOwnerService cottageOwnerService){
        this.adminService = adminService;
        this.korisnikService = korisnikService;
        this.boatOwnerService = boatOwnerService;
        this.cottageOwnerService = cottageOwnerService;
    }

    @PostMapping(value="/registerOwner" ,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegisterOwnerDTO> createBoatOwner(@RequestBody RegisterOwnerDTO DTO) throws Exception {
            BoatOwner existing = this.boatOwnerService.getByEmailAddressAndPassword(DTO.getEmailAddress(), DTO.getPassword());
            //ako vec postoji clan
            if (existing != null) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }else {
                if (DTO.getPassword().equals(DTO.getPassword2()) && (DTO.getRegType().equals("BoatOwner"))) {
                    BoatOwner boatOwner = new BoatOwner(DTO.getName(), DTO.getSurname(), DTO.getEmailAddress(),
                            DTO.getPhoneNumber(), DTO.getCity(), DTO.getState(), DTO.getHomeAddress(),
                            DTO.getBirthDate(), DTO.getUsername(), DTO.getPassword(), DTO.getRole());
                    boatOwner.setEmailAddress(DTO.getEmailAddress());


                    BoatOwner newBO = this.boatOwnerService.save(boatOwner);

                    RegisterOwnerDTO boDTO = new RegisterOwnerDTO(newBO.getName(), newBO.getSurname(), newBO.getEmailAddress(),
                            newBO.getPhoneNumber(), newBO.getCity(), newBO.getState(),
                            newBO.getHomeAddress(), newBO.getBirthDate(),
                            newBO.getUsername(), newBO.getPassword(), newBO.getRole());

                    return new ResponseEntity<>(boDTO, HttpStatus.OK);
                }else{
                    System.out.println("Lozinke se ne poklapaju!");
                    return new ResponseEntity<>(HttpStatus.CONFLICT);
            }

        }


    }




  
    //logovanje admina kao provera
    @PostMapping(
            value =("/login"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PrijavaKorisnikaDTO> KorisnikLogin(@RequestBody PrijavljenKorisnikDTO korisnikLoginDTO) throws Exception {
        //Admin admin = this.adminService.getByUsernameAndPassword(korisnikLoginDTO.getUsername(), korisnikLoginDTO.getPassword());
        Korisnik korisnik = this.korisnikService.getByUsernameAndPassword(korisnikLoginDTO.getUsername(), korisnikLoginDTO.getPassword());
        PrijavaKorisnikaDTO korisnikDTO = new PrijavaKorisnikaDTO();
        if(korisnik == null){
            System.out.print("Admin je null");
        }

        korisnikDTO = new PrijavaKorisnikaDTO(korisnik.getId(), korisnik.getName(), korisnik.getSurname(), korisnik.getEmailAddress(),
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


}
