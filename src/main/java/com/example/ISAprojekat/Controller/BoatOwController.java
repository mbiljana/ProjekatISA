package com.example.ISAprojekat.Controller;

import com.example.ISAprojekat.Model.*;
import com.example.ISAprojekat.Model.DTO.*;
import com.example.ISAprojekat.Service.AdminService;
import com.example.ISAprojekat.Service.BoatOwnerService;
import com.example.ISAprojekat.Service.ZahtevZaRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/boatOwners")
public class BoatOwController {

    private final BoatOwnerService boatOwnerService;
    private final ZahtevZaRegService zahtevZaRegService;
    private final AdminService adminService;

    @Autowired
    public BoatOwController(BoatOwnerService boatOwnerService, ZahtevZaRegService zahtevZaRegService, AdminService adminService){
        this.boatOwnerService = boatOwnerService;
        this.zahtevZaRegService = zahtevZaRegService;
        this.adminService = adminService;
    }

    //all boat owners
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<KorisnikDTO>> getUsers(){
        List<BoatOwner> ownerList = this.boatOwnerService.findAll();
        List<KorisnikDTO> trazeniKorisnici = new ArrayList<>();
        for(BoatOwner b : ownerList){
            KorisnikDTO korisnik = new KorisnikDTO(b.getId(),b.getName(),b.getSurname(),
                    b.getEmailAddress(),b.getPhoneNumber(),b.getCity(),b.getState(),b.getHomeAddress(),b.getBirthDate(),
                    b.getUsername(),b.getPassword(),b.getRole());
            trazeniKorisnici.add(korisnik);
        }
        return new ResponseEntity<>(trazeniKorisnici, HttpStatus.OK);
    }

    //get one boat owner
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OwnerDTO> getBoatOwner(@PathVariable("id")Long id){
        BoatOwner boatOwner = this.boatOwnerService.getOne(id);
        OwnerDTO ownerDTO = new OwnerDTO();
        ownerDTO.setCity(boatOwner.getCity());
        ownerDTO.setBirthDate(boatOwner.getBirthDate());
        ownerDTO.setEmailAddress(boatOwner.getEmailAddress());
        ownerDTO.setPassword(boatOwner.getPassword());
        ownerDTO.setName(boatOwner.getName());
        ownerDTO.setHomeAddress(boatOwner.getHomeAddress());
        ownerDTO.setState(boatOwner.getState());
        ownerDTO.setSurname(boatOwner.getSurname());
        ownerDTO.setPhoneNumber(boatOwner.getPhoneNumber());
        ownerDTO.setUsername(boatOwner.getUsername());
        return new ResponseEntity<>(ownerDTO, HttpStatus.FOUND);
    }


    //creating a boat owner --> registering
    @PostMapping(value="/registerOwner" ,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ZahtevZaRegDTO> createBoatOwner(@RequestBody RegisterOwnerDTO DTO) throws Exception {
        BoatOwner existing = this.boatOwnerService.getByEmailAddressAndPassword(DTO.getEmailAddress(), DTO.getPassword());
        //ako vec postoji clan
        if (existing != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }else {
            if (DTO.getPassword().equals(DTO.getPassword2()) && (DTO.getRegType().equals("BoatOwner"))) {
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
        ZahtevZaReg zahtevZaReg = this.zahtevZaRegService.findOne(dto.getId());
        BoatOwner boatOwner = new BoatOwner(
                dto.getName(),dto.getSurname(),dto.getEmailAddress(),
                dto.getPhoneNumber(),dto.getCity(),dto.getState(),
                dto.getHomeAddress(),dto.getBirthDate(),dto.getUsername(),
                dto.getPassword(), Role.BOATOWNER
        );
        this.boatOwnerService.save(boatOwner);
        Admin admin = this.adminService.getByUsernameAndPassword("123","111");
        admin.zahtevi.remove(zahtevZaReg);

        RegOwnerDTO regOwnerDTO = new RegOwnerDTO(boatOwner.getName(), boatOwner.getSurname(), boatOwner.getEmailAddress(),
                boatOwner.getPhoneNumber(),boatOwner.getCity(),boatOwner.getState(),boatOwner.getHomeAddress(),
                boatOwner.getBirthDate(),boatOwner.getUsername(),boatOwner.getPassword());
        return new ResponseEntity<>(regOwnerDTO, HttpStatus.CREATED);

    }

}
