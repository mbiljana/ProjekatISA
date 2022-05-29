package com.example.ISAprojekat.Controller;


import com.example.ISAprojekat.Model.Admin;
import com.example.ISAprojekat.Model.DTO.*;
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
@RequestMapping(value = "api/admins")
public class AdminController {
    private AdminService adminService;
    private KorisnikService korisnikService;

    @Autowired
    public AdminController(AdminService adminService, KorisnikService korisnikService){
        this.adminService = adminService;
        this.korisnikService = korisnikService;
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
    public ResponseEntity<List<AdminDTO>> getAllAdmins() {

        List<Admin> korisnici = adminService.findAll();


        List<AdminDTO> korisnikDTOS = new ArrayList<>();

            for (Admin a : korisnici) {

                    korisnikDTOS.add(new AdminDTO(a));
            }

        //return new ResponseEntity<>(korisnikDTOS, HttpStatus.OK);
        return new ResponseEntity<>(korisnikDTOS, HttpStatus.OK);


    }

    @PostMapping(value = ("/updateAdmin"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdminDTO> izmenaAdmina(@RequestBody AdminDTO kDTO) throws Exception {
        Admin admin = adminService.findOne(kDTO.getId());
        admin.setRole(kDTO.getRole()); //menjamo samo ulogu
        admin.setName(kDTO.getName());
        admin.setEmailAddress(kDTO.getEmailAddress());
        admin.setSurname(kDTO.getSurname());
        admin.setUsername(kDTO.getUsername());
        admin.setBirthDate(kDTO.getBirthDate());
        admin.setCity(kDTO.getCity());
        admin.setHomeAddress(kDTO.getHomeAddress());
        admin.setPassword(kDTO.getPassword());
        admin.setState(kDTO.getState());
        admin.setPhoneNumber(kDTO.getPhoneNumber());


        korisnikService.update(admin);
        AdminDTO tDTO =new AdminDTO(admin.getId(),admin.getName(),admin.getSurname(),admin.getEmailAddress(),admin.getPhoneNumber(),
                admin.getCity(),admin.getState(),admin.getHomeAddress(),admin.getBirthDate(),admin.getUsername(),admin.getPassword(),admin.getRole());
        return new ResponseEntity<>(tDTO,HttpStatus.OK);

    }

    //ne znam cemu sluzi
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

}
