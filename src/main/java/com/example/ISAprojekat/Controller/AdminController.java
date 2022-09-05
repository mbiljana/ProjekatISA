package com.example.ISAprojekat.Controller;

import com.example.ISAprojekat.Model.*;
import com.example.ISAprojekat.Model.Admin;
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
    private final ZahtevZaBrisanjeService brisanjeService;


    @Autowired
    public AdminController(AdminService adminService, KorisnikService korisnikService,
                           BoatOwnerService boatOwnerService, CottageOwnerService cottageOwnerService,
                           ZahtevZaRegService zahtevZaRegService,ZahtevZaBrisanjeService brisanjeService){
        this.adminService = adminService;
        this.korisnikService = korisnikService;
        this.boatOwnerService = boatOwnerService;
        this.cottageOwnerService = cottageOwnerService;
        this.zahtevZaRegService = zahtevZaRegService;
        this.brisanjeService = brisanjeService;
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
        admin.setRole(kDTO.getRole());
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


    @PostMapping(value = ("/acceptRequest"), consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegOwnerDTO> acceptRequest(@RequestBody ZahtevDTO dto) throws Exception{
        ZahtevZaReg zahtevZaReg = this.zahtevZaRegService.findOne(dto.getIdKorisnika());
        List<ZahtevZaReg> zahtevZaRegs = this.zahtevZaRegService.findAll();
        if(zahtevZaReg.getRegType().equals("BoatOwner")) {
            BoatOwner boatOwner = new BoatOwner(
                    zahtevZaReg.getName(), zahtevZaReg.getSurname(), zahtevZaReg.getEmailAddress(),
                    zahtevZaReg.getPhoneNumber(), zahtevZaReg.getCity(), zahtevZaReg.getState(),
                    zahtevZaReg.getHomeAddress(), zahtevZaReg.getBirthDate(), zahtevZaReg.getUsername(),
                    zahtevZaReg.getPassword(), Role.BOATOWNER
            );
            this.boatOwnerService.save(boatOwner);
            Admin admin = this.adminService.getByUsernameAndPassword("123", "111");
            this.zahtevZaRegService.delete(zahtevZaReg.getId());
            //admin.zahtevi.remove(zahtevZaReg.getId());

            RegOwnerDTO regOwnerDTO = new RegOwnerDTO(boatOwner.getName(), boatOwner.getSurname(), boatOwner.getEmailAddress(),
                    boatOwner.getPhoneNumber(), boatOwner.getCity(), boatOwner.getState(), boatOwner.getHomeAddress(),
                    boatOwner.getBirthDate(), boatOwner.getUsername(), boatOwner.getPassword());
            return new ResponseEntity<>(regOwnerDTO, HttpStatus.CREATED);

        }else //if(dto.getRegType() == "CottageOwner"){
        {CottageOwner cottageOwner = new CottageOwner(
                zahtevZaReg.getName(), zahtevZaReg.getSurname(), zahtevZaReg.getEmailAddress(),
                zahtevZaReg.getPhoneNumber(), zahtevZaReg.getCity(), zahtevZaReg.getState(),
                zahtevZaReg.getHomeAddress(), zahtevZaReg.getBirthDate(), zahtevZaReg.getUsername(),
                zahtevZaReg.getPassword(), Role.COTTAGEOWNER
            );
            this.cottageOwnerService.save(cottageOwner);
            Admin admin = this.adminService.getByUsernameAndPassword("123", "111");
            admin.zahtevi.remove(zahtevZaReg);
            this.zahtevZaRegService.delete(zahtevZaReg.getId());
            RegOwnerDTO regOwnerDTO = new RegOwnerDTO(cottageOwner.getName(), cottageOwner.getSurname(), cottageOwner.getEmailAddress(),
                    cottageOwner.getPhoneNumber(), cottageOwner.getCity(), cottageOwner.getState(), cottageOwner.getHomeAddress(),
                    cottageOwner.getBirthDate(), cottageOwner.getUsername(), cottageOwner.getPassword());
            return new ResponseEntity<>(regOwnerDTO, HttpStatus.CREATED);
        }
    }

    //getting all requests for registration
    @GetMapping(value="/regReq", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ZahtevDTO>> getRequests() {
        List<ZahtevDTO> zahtevZaRegDTOS = new ArrayList<>();

        List<ZahtevZaReg> zahtevZaRegs = this.zahtevZaRegService.findAll();

        for(ZahtevZaReg t : zahtevZaRegs) {

                ZahtevDTO zahtevZaRegDTO = new ZahtevDTO(t.getId(),
                        t.getName(),t.getSurname(),t.getEmailAddress(),t.getPhoneNumber(),
                        t.getCity(),t.getState(),t.getHomeAddress(),t.getBirthDate(),
                        t.getUsername(),t.getPassword(),t.getRegType(),t.getRazlog()
                        );
                zahtevZaRegDTOS.add(zahtevZaRegDTO);
        }
        return new ResponseEntity<>(zahtevZaRegDTOS, HttpStatus.OK);
    }

    //get all delete account requests
    @GetMapping(value="/deleteReq", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ZahtevZaBrisanjeDTO>> getDelRequests() {
        List<ZahtevZaBrisanjeDTO> zahtevZaRegDTOS = new ArrayList<>();

        List<ZahtevZaBrisanje> zahtevZaRegs = this.brisanjeService.findAll();

        for(ZahtevZaBrisanje t : zahtevZaRegs) {

            ZahtevZaBrisanjeDTO zahtevZaRegDTO = new ZahtevZaBrisanjeDTO(
                    t.getId(),t.getName(),t.getSurname(),t.getEmailAddress(),t.getPhoneNumber(),
                    t.getUsername(),t.isBlocked()
            );
            zahtevZaRegDTOS.add(zahtevZaRegDTO);
        }
        return new ResponseEntity<>(zahtevZaRegDTOS, HttpStatus.OK);
    }

    @PostMapping(value = ("/removeAccountBoat"), consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ZahtevZaBrisanje> removeAccount(@RequestBody KorisnikZahtevDTO dto) throws Exception{
        ZahtevZaBrisanje zahtevZaBrisanje = this.brisanjeService.findOne(dto.getId());
        Korisnik korisnik = this.korisnikService.findByUsername(zahtevZaBrisanje.getUsername());

        //BoatOwner boatOwner = this.boatOwnerService.findByUsername(zahtevZaBrisanje.getUsername());
        korisnik.setBlocked(true);

        this.korisnikService.save(korisnik);
        return new ResponseEntity<>(zahtevZaBrisanje, HttpStatus.OK);
    }


}
