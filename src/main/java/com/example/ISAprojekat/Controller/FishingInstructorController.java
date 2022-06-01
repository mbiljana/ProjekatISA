package com.example.ISAprojekat.Controller;


import com.example.ISAprojekat.Model.*;
import com.example.ISAprojekat.Model.DTO.*;
import com.example.ISAprojekat.Service.*;
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
    private ZahtevZaRegService zahtevZaRegService;
    private AdminService adminService;


    @Autowired
    public FishingInstructorController(FishingInstructorService fishingInstructorService, AdventureService adventureService, ZahtevZaRegService zahtevZaRegService,
                                       AdminService adminService){
        this.fishingInstructorService = fishingInstructorService;
        this.adventureService = adventureService;
        this.zahtevZaRegService = zahtevZaRegService;
        this.adminService = adminService;
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

    //svi instruktori
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<KorisnikDTO>> getUsers(){
        List<FishingInstructor> ownerList = this.fishingInstructorService.findAll();
        List<KorisnikDTO> trazeniKorisnici = new ArrayList<>();
        for(FishingInstructor b : ownerList){
            KorisnikDTO korisnik = new KorisnikDTO(b.getId(),b.getName(),b.getSurname(),
                    b.getEmailAddress(),b.getPhoneNumber(),b.getCity(),b.getState(),b.getHomeAddress(),b.getBirthDate(),
                    b.getUsername(),b.getPassword(),b.getRole());
            trazeniKorisnici.add(korisnik);
        }
        return new ResponseEntity<>(trazeniKorisnici, HttpStatus.OK);
    }

    //creating a boat owner --> registering
    @PostMapping(value="/registerOwner" ,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ZahtevZaRegDTO> createBoatOwner(@RequestBody RegisterOwnerDTO DTO) throws Exception {
        FishingInstructor existing = this.fishingInstructorService.getByEmailAddressAndPassword(DTO.getEmailAddress(), DTO.getPassword());
        //ako vec postoji clan
        if (existing != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }else {
            if (DTO.getPassword().equals(DTO.getPassword2()) && (DTO.getRegType().equals("FishingInstructor"))) {
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
                ZahtevZaRegDTO zahtevZaRegDTO = new ZahtevZaRegDTO(DTO.getName(),DTO.getSurname(),
                        DTO.getEmailAddress(),DTO.getPhoneNumber(),DTO.getCity(),
                        DTO.getState(),DTO.getHomeAddress(),DTO.getBirthDate(),
                        DTO.getUsername(),DTO.getPassword(),DTO.getRegType(), DTO.getRazlog());
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

    @PostMapping(value = ("/acceptRequest"), consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegOwnerDTO> acceptRequest(@RequestBody ZahtevDTO dto) throws Exception{
        ZahtevZaReg zahtevZaReg = this.zahtevZaRegService.findOne(dto.getIdKorisnika());
        FishingInstructor fishingInstructor = new FishingInstructor(
                dto.getName(),dto.getSurname(),dto.getEmailAddress(),
                dto.getPhoneNumber(),dto.getCity(),dto.getState(),
                dto.getHomeAddress(),dto.getBirthDate(),dto.getUsername(),
                dto.getPassword(), Role.INSTRUCTOR
        );
        this.fishingInstructorService.save(fishingInstructor);
        Admin admin = this.adminService.getByUsernameAndPassword("123","111");
        admin.zahtevi.remove(zahtevZaReg);

        RegOwnerDTO regOwnerDTO = new RegOwnerDTO(fishingInstructor.getName(), fishingInstructor.getSurname(), fishingInstructor.getEmailAddress(),
                fishingInstructor.getPhoneNumber(),fishingInstructor.getCity(),fishingInstructor.getState(),fishingInstructor.getHomeAddress(),
                fishingInstructor.getBirthDate(),fishingInstructor.getUsername(),fishingInstructor.getPassword());
        return new ResponseEntity<>(regOwnerDTO, HttpStatus.CREATED);

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
