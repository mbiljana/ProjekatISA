package com.example.ISAprojekat.Controller;


import com.example.ISAprojekat.Model.*;
import com.example.ISAprojekat.Model.DTO.*;
import com.example.ISAprojekat.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/instructor")
public class FishingInstructorController {
    private FishingInstructorService fishingInstructorService;
    private AdventureService adventureService;
    private ZahtevZaRegService zahtevZaRegService;
    private AdminService adminService;

//ceo se menja
    @Autowired
    public FishingInstructorController(FishingInstructorService fishingInstructorService, AdventureService adventureService, ZahtevZaRegService zahtevZaRegService,
                                       AdminService adminService) {
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
    public ResponseEntity<List<KorisnikDTO>> getUsers() {
        List<FishingInstructor> ownerList = this.fishingInstructorService.findAll();
        List<KorisnikDTO> trazeniKorisnici = new ArrayList<>();
        for (FishingInstructor b : ownerList) {
            KorisnikDTO korisnik = new KorisnikDTO(b.getId(), b.getName(), b.getSurname(),
                    b.getEmailAddress(), b.getPhoneNumber(), b.getCity(), b.getState(), b.getHomeAddress(), b.getBirthDate(),
                    b.getUsername(), b.getPassword(), b.getRole());
            trazeniKorisnici.add(korisnik);
        }
        return new ResponseEntity<>(trazeniKorisnici, HttpStatus.OK);
    }

    //creating a boat owner --> registering
    @PostMapping(value = "/registerOwner",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ZahtevZaRegDTO> createBoatOwner(@RequestBody RegisterOwnerDTO DTO) throws Exception {
        FishingInstructor existing = this.fishingInstructorService.getByEmailAddressAndPassword(DTO.getEmailAddress(), DTO.getPassword());
        //ako vec postoji clan
        if (existing != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
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
                ZahtevZaRegDTO zahtevZaRegDTO = new ZahtevZaRegDTO(DTO.getName(), DTO.getSurname(),
                        DTO.getEmailAddress(), DTO.getPhoneNumber(), DTO.getCity(),
                        DTO.getState(), DTO.getHomeAddress(), DTO.getBirthDate(),
                        DTO.getUsername(), DTO.getPassword(), DTO.getRegType(), DTO.getRazlog());
                this.zahtevZaRegService.save(zahtevZaReg);
                Admin admin = this.adminService.getByUsernameAndPassword("123", "111");
                admin.zahtevi.add(zahtevZaReg);
                return new ResponseEntity<>(zahtevZaRegDTO, HttpStatus.OK);
            } else {
                System.out.println("Lozinke se ne poklapaju!");
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }

        }
    }

    @PostMapping(value = ("/acceptRequest"), consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegOwnerDTO> acceptRequest(@RequestBody ZahtevDTO dto) throws Exception {
        ZahtevZaReg zahtevZaReg = this.zahtevZaRegService.findOne(dto.getIdKorisnika());
        FishingInstructor fishingInstructor = new FishingInstructor(
                dto.getName(), dto.getSurname(), dto.getEmailAddress(),
                dto.getPhoneNumber(), dto.getCity(), dto.getState(),
                dto.getHomeAddress(), dto.getBirthDate(), dto.getUsername(),
                dto.getPassword(), Role.INSTRUCTOR
        );
        this.fishingInstructorService.save(fishingInstructor);
        Admin admin = this.adminService.getByUsernameAndPassword("123", "111");
        admin.zahtevi.remove(zahtevZaReg);

        RegOwnerDTO regOwnerDTO = new RegOwnerDTO(fishingInstructor.getName(), fishingInstructor.getSurname(), fishingInstructor.getEmailAddress(),
                fishingInstructor.getPhoneNumber(), fishingInstructor.getCity(), fishingInstructor.getState(), fishingInstructor.getHomeAddress(),
                fishingInstructor.getBirthDate(), fishingInstructor.getUsername(), fishingInstructor.getPassword());
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
        FishingInstructorDTO tDTO = new FishingInstructorDTO(korisnik.getId(), korisnik.getName(), korisnik.getSurname(), korisnik.getEmailAddress(), korisnik.getPhoneNumber(),
                korisnik.getCity(), korisnik.getState(), korisnik.getHomeAddress(), korisnik.getBirthDate(), korisnik.getUsername(), korisnik.getPassword(), korisnik.getRole());
        return new ResponseEntity<>(tDTO, HttpStatus.OK);

    }


    @PostMapping(value = ("/updateInstructorPassword"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FishingInstructorDTO> izmenaLozinke(@RequestBody FishingInstructorDTO kDTO) throws Exception {
        FishingInstructor korisnik = fishingInstructorService.findOne(kDTO.getId());
        korisnik.setPassword(kDTO.getPassword()); //menjamo samo lozinku


        fishingInstructorService.update(korisnik);
        FishingInstructorDTO tDTO = new FishingInstructorDTO(korisnik.getId(), korisnik.getName(), korisnik.getSurname(), korisnik.getEmailAddress(), korisnik.getPhoneNumber(),
                korisnik.getCity(), korisnik.getState(), korisnik.getHomeAddress(), korisnik.getBirthDate(), korisnik.getUsername(), korisnik.getPassword(), korisnik.getRole());
        return new ResponseEntity<>(tDTO, HttpStatus.OK);

    }

    //sve iznad izmeniti
    //zakometarisano zbog slika - koje treba da skontam
    /*@GetMapping("/adventures")
    @PreAuthorize("hasRole('INSTRUCTOR')")
    public ResponseEntity<List<EntityDTO>> getAllAdventuresFromInstructor(Principal instructor) throws IOException {
        List<Adventure> adventures = adventureService.getAllAdventuresFromInstructor(instructor.getName());

        /*List<EntityDTO> dto = new ArrayList<>();
        for(Adventure a : adventures) {
            String[] images = a.getImages().toArray(new String[a.getImages().size()]);

            EntityDTO entityDTO;
            if(images.length > 0) {
                entityDTO = new EntityDTO(a.getId(), a.getName(), a.getDescription(), a.getAverageGrade(), images[0], a.getAddress());
            } else {
                entityDTO = new EntityDTO(a.getId(), a.getName(), a.getDescription(), a.getAverageGrade(), "data:image/jpeg;base64,/9j/4QAYRXhpZgAASUkqAAgAAAAAAAAAAAAAAP/sABFEdWNreQABAAQAAABQAAD/4QNdaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLwA8P3hwYWNrZXQgYmVnaW49Iu+7vyIgaWQ9Ilc1TTBNcENlaGlIenJlU3pOVGN6a2M5ZCI/PiA8eDp4bXBtZXRhIHhtbG5zOng9ImFkb2JlOm5zOm1ldGEvIiB4OnhtcHRrPSJBZG9iZSBYTVAgQ29yZSA1LjMtYzAxMSA2Ni4xNDU2NjEsIDIwMTIvMDIvMDYtMTQ6NTY6MjcgICAgICAgICI+IDxyZGY6UkRGIHhtbG5zOnJkZj0iaHR0cDovL3d3dy53My5vcmcvMTk5OS8wMi8yMi1yZGYtc3ludGF4LW5zIyI+IDxyZGY6RGVzY3JpcHRpb24gcmRmOmFib3V0PSIiIHhtbG5zOnhtcE1NPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvbW0vIiB4bWxuczpzdFJlZj0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL3NUeXBlL1Jlc291cmNlUmVmIyIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bXBNTTpPcmlnaW5hbERvY3VtZW50SUQ9IjdCRTdFQkNCQTBEQjVFQkZFNjdGNTM5REE0REMyQTA5IiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOjQ0OUJCNzRFQjE5QzExRTZBOUQyRURGMDVEODJDMzJFIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOjQ0OUJCNzREQjE5QzExRTZBOUQyRURGMDVEODJDMzJFIiB4bXA6Q3JlYXRvclRvb2w9IkFkb2JlIFBob3Rvc2hvcCBDUzYgV2luZG93cyI+IDx4bXBNTTpEZXJpdmVkRnJvbSBzdFJlZjppbnN0YW5jZUlEPSJ4bXAuaWlkOjNERDA2NEQ5OTlCMUU2MTFCRTE1RjgxNTYyQkUwNzFBIiBzdFJlZjpkb2N1bWVudElEPSI3QkU3RUJDQkEwREI1RUJGRTY3RjUzOURBNERDMkEwOSIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0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", a.getAddress());
            }

            dto.add(entityDTO);
        }

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }*/



}
