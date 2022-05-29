package com.example.ISAprojekat.Controller;


import com.example.ISAprojekat.Model.Admin;
import com.example.ISAprojekat.Model.DTO.AdminDTO;
import com.example.ISAprojekat.Model.DTO.FishingInstructorDTO;
import com.example.ISAprojekat.Model.DTO.IzmenjenKorisnikDTO;
import com.example.ISAprojekat.Model.DTO.KorisnikDTO;
import com.example.ISAprojekat.Model.FishingInstructor;
import com.example.ISAprojekat.Model.Korisnik;
import com.example.ISAprojekat.Service.AdminService;
import com.example.ISAprojekat.Service.FishingInstructorService;
import com.example.ISAprojekat.Service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/instructor")
public class FishingInstructorController {
    private FishingInstructorService fishingInstructorService;


    @Autowired
    public FishingInstructorController(FishingInstructorService fishingInstructorService){
        this.fishingInstructorService = fishingInstructorService;
    }

    @GetMapping(value = "/allInstructors")
    public ResponseEntity<List<FishingInstructorDTO>> getAllInstructors() {

        List<FishingInstructor> korisnici = fishingInstructorService.findAll();


        List<FishingInstructorDTO> korisnikDTOS = new ArrayList<>();

        for (FishingInstructor a : korisnici) {

            korisnikDTOS.add(new FishingInstructorDTO(a));
        }

        //return new ResponseEntity<>(korisnikDTOS, HttpStatus.OK);
        return new ResponseEntity<>(korisnikDTOS, HttpStatus.OK);


    }
    //ovde nastaviti
    @PostMapping(value = ("/updateInstructor"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FishingInstructorDTO> izmena(@RequestBody FishingInstructorDTO kDTO) throws Exception {
        FishingInstructor korisnik = fishingInstructorService.findOne(kDTO.getId());
        korisnik.setRole(kDTO.getRole()); //menjamo samo ulogu
        korisnik.setName(kDTO.getName());
        korisnik.setCity(kDTO.getCity());
        korisnik.setSurname(kDTO.getSurname());
        korisnik.setPassword(kDTO.getPassword());
        korisnik.setPhoneNumber(kDTO.getPhoneNumber());
        korisnik.setBirthDate(kDTO.getBirthDate());
        korisnik.setHomeAddress(kDTO.getHomeAddress());
        korisnik.setEmailAddress(kDTO.getEmailAddress());
        korisnik.setUsername(kDTO.getUsername());
        korisnik.setState(kDTO.getState());

        fishingInstructorService.update(korisnik);
        FishingInstructorDTO tDTO =new FishingInstructorDTO(korisnik.getId(),korisnik.getName(),korisnik.getSurname(),korisnik.getEmailAddress(),korisnik.getPhoneNumber(),
                korisnik.getCity(),korisnik.getState(),korisnik.getHomeAddress(),korisnik.getBirthDate(),korisnik.getUsername(),korisnik.getPassword(),korisnik.getRole());
        return new ResponseEntity<>(tDTO,HttpStatus.OK);

    }


    @PostMapping(value = ("/updateInstructorPassword"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FishingInstructorDTO> izmenaLozinke(@RequestBody FishingInstructorDTO kDTO) throws Exception {
        FishingInstructor korisnik = fishingInstructorService.findOne(kDTO.getId());
        korisnik.setPassword(kDTO.getPassword()); //menjamo samo lozinku


        fishingInstructorService.update(korisnik);
        FishingInstructorDTO tDTO =new FishingInstructorDTO(korisnik.getId(),korisnik.getName(),korisnik.getSurname(),korisnik.getEmailAddress(),korisnik.getPhoneNumber(),
                korisnik.getCity(),korisnik.getState(),korisnik.getHomeAddress(),korisnik.getBirthDate(),korisnik.getUsername(),korisnik.getPassword(),korisnik.getRole());
        return new ResponseEntity<>(tDTO,HttpStatus.OK);

    }
}
