package com.example.ISAprojekat.Controller;


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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/korisnik")
public class KorisnikController {
    private AdminService adminService;
    private KorisnikService korisnikService;

    @Autowired
    public KorisnikController(AdminService adminService, KorisnikService korisnikService){
        this.adminService = adminService;
        this.korisnikService = korisnikService;
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

