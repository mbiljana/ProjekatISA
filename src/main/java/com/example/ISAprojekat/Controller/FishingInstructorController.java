package com.example.ISAprojekat.Controller;


import com.example.ISAprojekat.Model.*;
import com.example.ISAprojekat.Model.DTO.*;
import com.example.ISAprojekat.Service.AdminService;
import com.example.ISAprojekat.Service.AdventureService;
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
    private AdventureService adventureService;


    @Autowired
    public FishingInstructorController(FishingInstructorService fishingInstructorService, AdventureService adventureService){
        this.fishingInstructorService = fishingInstructorService;
        this.adventureService = adventureService;
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

    //prikaz termina
    @GetMapping(value = "/allReservedAdventures")
    public ResponseEntity<List<AdventureDTO>> getAllFreeAppointments() {

        //nema mi smisla
        List<Adventure> korisnici = adventureService.findAll();


        List<AdventureDTO> korisnikDTOS = new ArrayList<>();

        //if(korisnikDTOS.getRegType().equals("fi"))
        for (Adventure a : korisnici) {

            korisnikDTOS.add(new AdventureDTO(a));
        }

        //return new ResponseEntity<>(korisnikDTOS, HttpStatus.OK);
        return new ResponseEntity<>(korisnikDTOS, HttpStatus.OK);


    }

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
