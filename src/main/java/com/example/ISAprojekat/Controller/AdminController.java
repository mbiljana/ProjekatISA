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
@RequestMapping(value = "api/admins")
public class AdminController {
    private final AdminService adminService;
    private final KorisnikService korisnikService;
    private final BoatOwnerService boatOwnerService;
    private final CottageOwnerService cottageOwnerService;
    private final ZahtevZaRegService zahtevZaRegService;

    @Autowired
    public AdminController(AdminService adminService, KorisnikService korisnikService, BoatOwnerService boatOwnerService, CottageOwnerService cottageOwnerService, ZahtevZaRegService zahtevZaRegService){
        this.adminService = adminService;
        this.korisnikService = korisnikService;
        this.boatOwnerService = boatOwnerService;
        this.cottageOwnerService = cottageOwnerService;
        this.zahtevZaRegService = zahtevZaRegService;
    }



    @GetMapping(value = "/allKorisnici")
    public ResponseEntity<List<KorisnikDTO>> getAllKorisnici() {

        List<Korisnik> korisnici = korisnikService.findAll();

            // convert boats to DTOs
            List<KorisnikDTO> korisnikDTOS = new ArrayList<>();
            for (Korisnik a : korisnici) {
                korisnikDTOS.add(new KorisnikDTO(a));
            }

            //return new ResponseEntity<>(korisnikDTOS, HttpStatus.OK);
            return new ResponseEntity<>(korisnikDTOS, HttpStatus.OK);


    }

    @GetMapping(value = "/allAdmins")
    public ResponseEntity<List<KorisnikDTO>> getAllAdmins() {

        List<Korisnik> korisnici = korisnikService.findAll();


        List<KorisnikDTO> korisnikDTOS = new ArrayList<>();

            for (Korisnik a : korisnici) {
                if(a == adminService.findAll())
                korisnikDTOS.add(new KorisnikDTO(a));
            }

        //return new ResponseEntity<>(korisnikDTOS, HttpStatus.OK);
        return new ResponseEntity<>(korisnikDTOS, HttpStatus.OK);


    }

    @PostMapping(value = ("/updateKorisnik"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDTO> izmena(@RequestBody IzmenjenKorisnikDTO kDTO) throws Exception {
        Korisnik korisnik = korisnikService.findOne(kDTO.getId());
        korisnik.setRole(kDTO.getRole()); //menjamo samo ulogu
        //korisnik.setName(kDTO.getName());

        korisnikService.update(korisnik);
        KorisnikDTO tDTO =new KorisnikDTO(korisnik.getId(),korisnik.getName(),korisnik.getSurname(),korisnik.getEmailAddress(),korisnik.getPhoneNumber(),
                korisnik.getCity(),korisnik.getState(),korisnik.getHomeAddress(),korisnik.getBirthDate(),korisnik.getUsername(),korisnik.getPassword(),korisnik.getRole());
        return new ResponseEntity<>(tDTO,HttpStatus.OK);

    }

    /*@PostMapping(value = ("/sviKorisnici"), consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PrijavaKorisnikaDTO>> createUser(@RequestBody IzlistaniKorisniciDTO izlistaniDTO) throws Exception {
        Korisnik korisnik = korisnikService.findOne(izlistaniDTO.getIdKorisnika());
        List<PrijavaKorisnikaDTO> ret = new ArrayList<>();
        for(Korisnik t : korisnik.getPrijavljeniTreninzi()) {
            FiltriraniTreninziDTO filtrirani = new FiltriraniTreninziDTO();
            filtrirani.setIdt(t.getId());
            filtrirani.setNaziv(t.getTrening().getNaziv());
            filtrirani.setCena(t.getCena());
            filtrirani.setTrajanje(t.getTrening().getTrajanje());
            filtrirani.setDatumPocetka(t.getDatumPocetkaTreninga());
            filtrirani.setDatumKraja(t.getDatumKrajaTreninga());
            filtrirani.setImeTrenera(t.getTrening().getTrener().getIme());
            filtrirani.setTipTreninga(t.getTrening().getTipTreninga());
            filtrirani.setNazivFitnesCentra(t.getFitnessCentar().getNazivCentra());
            filtrirani.setNazivSale(t.getSala().getOznaka());

            filtrirani.getProsecnaOcena();
            filtrirani.getPreostalaMesta();
            ret.add(filtrirani);

        return new ResponseEntity<>(ret, HttpStatus.CREATED);
    }*/


    @PostMapping(value = ("/acceptRequest"), consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegOwnerDTO> acceptRequest(@RequestBody ZahtevDTO dto) throws Exception{
        ZahtevZaReg zahtevZaReg = this.zahtevZaRegService.findOne(dto.getId());
        if(dto.getRegType().equals("BoatOwner")) {
            BoatOwner boatOwner = new BoatOwner(
                    dto.getName(), dto.getSurname(), dto.getEmailAddress(),
                    dto.getPhoneNumber(), dto.getCity(), dto.getState(),
                    dto.getHomeAddress(), dto.getBirthDate(), dto.getUsername(),
                    dto.getPassword(), Role.BOATOWNER
            );
            this.boatOwnerService.save(boatOwner);
            Admin admin = this.adminService.getByUsernameAndPassword("123", "111");
            admin.zahtevi.remove(zahtevZaReg);

            RegOwnerDTO regOwnerDTO = new RegOwnerDTO(boatOwner.getName(), boatOwner.getSurname(), boatOwner.getEmailAddress(),
                    boatOwner.getPhoneNumber(), boatOwner.getCity(), boatOwner.getState(), boatOwner.getHomeAddress(),
                    boatOwner.getBirthDate(), boatOwner.getUsername(), boatOwner.getPassword());
            return new ResponseEntity<>(regOwnerDTO, HttpStatus.CREATED);

        }else //if(dto.getRegType() == "CottageOwner"){
        {CottageOwner cottageOwner = new CottageOwner(
                    dto.getName(), dto.getSurname(), dto.getEmailAddress(),
                    dto.getPhoneNumber(), dto.getCity(), dto.getState(),
                    dto.getHomeAddress(), dto.getBirthDate(), dto.getUsername(),
                    dto.getPassword(), Role.COTTAGEOWNER
            );
            this.cottageOwnerService.save(cottageOwner);
            Admin admin = this.adminService.getByUsernameAndPassword("123", "111");
            admin.zahtevi.remove(zahtevZaReg);

            RegOwnerDTO regOwnerDTO = new RegOwnerDTO(cottageOwner.getName(), cottageOwner.getSurname(), cottageOwner.getEmailAddress(),
                    cottageOwner.getPhoneNumber(), cottageOwner.getCity(), cottageOwner.getState(), cottageOwner.getHomeAddress(),
                    cottageOwner.getBirthDate(), cottageOwner.getUsername(), cottageOwner.getPassword());
            return new ResponseEntity<>(regOwnerDTO, HttpStatus.CREATED);
        }
    }

}
