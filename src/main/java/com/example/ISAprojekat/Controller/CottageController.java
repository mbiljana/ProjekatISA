package com.example.ISAprojekat.Controller;

import com.example.ISAprojekat.Model.*;
import com.example.ISAprojekat.Model.DTO.*;
import com.example.ISAprojekat.Repository.CottageRepository;
import com.example.ISAprojekat.Service.CottageReservationService;
import com.example.ISAprojekat.Service.CottageService;
import com.example.ISAprojekat.Service.FastReservationCottService;
import com.example.ISAprojekat.Service.Impl.CottageServiceImpl;
import com.example.ISAprojekat.Service.OcenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/cottages")
public class CottageController {

    private final CottageService cottageService;
    private final OcenaService ocenaService;
    private final FastReservationCottService fastReservationCottService;
    private final CottageReservationService cottageReservationService;

    @Autowired
    public CottageController(CottageService cottageService, OcenaService ocenaService, FastReservationCottService fastReservationCottService,CottageReservationService cottageReservationService){
        this.cottageService = cottageService;
        this.ocenaService = ocenaService;
        this.fastReservationCottService = fastReservationCottService;
        this.cottageReservationService = cottageReservationService;
    }

    //get all cottages
    @GetMapping(value = "/all")
    public ResponseEntity<List<CottageDTO>> getAllCottages() {

        List<Cottage> cottages= this.cottageService.findAll();
        List<Ocena> ocenas  =this.ocenaService.findAll();
        float ocena =0;
        // convert cottages to DTOs
        List<CottageDTO> cottageDTOS = new ArrayList<>();
        for (Cottage c : cottages) {
            ocena = this.ocenaService.srednjaVikendica(ocenas,c.getId());
            cottageDTOS.add(new CottageDTO(c,ocena));
        }

        return new ResponseEntity<>(cottageDTOS, HttpStatus.OK);
    }

    //get one cottage
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CottageDTO> getCottage(@PathVariable("id")Long id){
        Cottage cottage = this.cottageService.getOne(id);
        CottageDTO cottageDTO = new CottageDTO();
       cottageDTO.setCottageRules(cottage.getCottageRules());
       cottageDTO.setCottageName(cottage.getCottageName());
       cottageDTO.setCottageAdditionalServices(cottage.getCottageAdditionalServices());
       cottageDTO.setCottageDescription(cottage.getCottageDescription());
       cottageDTO.setCottageAddress(cottage.getCottageAddress());
       cottageDTO.setNumRooms(cottage.getNumRooms());
       cottageDTO.setNumBeds(cottage.getNumBeds());
       cottageDTO.setImageEnt1(cottage.getImageEnt1());
       cottageDTO.setImageEnt2(cottage.getImageEnt2());
       cottageDTO.setImageExt1(cottage.getImageExt1());
       cottageDTO.setImageExt2(cottage.getImageExt2());
        return new ResponseEntity<>(cottageDTO, HttpStatus.FOUND);
    }

    @PostMapping(value = "/createCottage",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CottageDTO> createCottage(@RequestBody CottageCDTO cottageDTO) throws Exception{
        Cottage cottage = new Cottage();
        cottage.setCottageName(cottageDTO.getCottageName());
        cottage.setCottageRules(cottageDTO.getCottageRules());
        cottage.setCottageAddress(cottageDTO.getCottageAddress());
        cottage.setCottageDescription(cottageDTO.getCottageDescription());
        cottage.setCottageAdditionalServices(cottageDTO.getCottageAdditionalServices());
        cottage.setNumBeds(cottageDTO.getNumBeds());
        cottage.setNumRooms(cottageDTO.getNumRooms());
        cottage.setCancelCondition(cottageDTO.getConditions());
        this.cottageService.save(cottage);
        CottageDTO cottageDTO1 = new CottageDTO(
                cottage.getId(), cottage.getCottageName(), cottage.getCottageAddress(),
                cottage.getCottageDescription(),cottage.getNumRooms(),cottage.getNumBeds(),
                cottage.getCottageAdditionalServices(), cottage.getCottageRules(),
                cottage.getCancelCondition()
        );
        return new ResponseEntity<>(cottageDTO1,HttpStatus.CREATED);
    }


    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CottageUpdateDTO> updateCottage(@RequestBody CottageUpdateIdDTO cottageDTO) {
        Cottage cottage = this.cottageService.getOne(cottageDTO.getIdCottage());
        cottage.setCottageName(cottageDTO.getName());
        cottage.setCottageAddress(cottageDTO.getAddress());
        cottage.setCottageDescription(cottageDTO.getDesc());
        cottage.setCottageAdditionalServices(cottageDTO.getServices());
        cottage.setNumBeds(cottageDTO.getBeds());
        cottage.setNumRooms(cottageDTO.getRooms());
        cottage.setCottageRules(cottageDTO.getRules());
        this.cottageService.update(cottage);
        CottageUpdateDTO cottageUpdateDTO = new CottageUpdateDTO(cottage.getCottageName(),cottage.getCottageAddress(),
                cottage.getCottageDescription(),cottage.getNumRooms(),cottage.getNumBeds(),cottage.getCottageAdditionalServices(),
                cottage.getCottageRules());
        return new ResponseEntity<>(cottageUpdateDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/createResCott",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateCottageResDTO> createReservation(@RequestBody FastResCottDTO cottDTO) throws Exception{
        Cottage cottage = this.cottageService.getOne(cottDTO.getCottId());
        float price = cottage.getPrice() * cottDTO.getDuration();
        FastReservationCott fastReservation = new FastReservationCott();
        fastReservation.setCapacity(cottDTO.getCapacity());
        fastReservation.setAdditionalServices(cottDTO.getAdditionalServices());
        fastReservation.setDuration(cottDTO.getDuration());
        fastReservation.setPrice(price);
        fastReservation.setStartDate(cottDTO.getStartDate());
        fastReservation.setCottage(cottage);
        this.fastReservationCottService.create(fastReservation);
        cottage.getFastReservations().add(fastReservation);
        CreateCottageResDTO createCottageResDTO = new CreateCottageResDTO();
        createCottageResDTO.setCottId(fastReservation.getCottage().getId());
        createCottageResDTO.setCapacity(fastReservation.getCapacity());
        createCottageResDTO.setDuration(fastReservation.getDuration());
        createCottageResDTO.setPrice(fastReservation.getPrice());
        createCottageResDTO.setStartDate(fastReservation.getStartDate());
        createCottageResDTO.setAdditionalServices(fastReservation.getAdditionalServices());
        return new ResponseEntity<>(createCottageResDTO,HttpStatus.CREATED);
    }

    @PostMapping(value = "/remove",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> removal(@RequestBody IdDTO id) {
        this.cottageService.delete(id.getIdKorisnika());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping(value = "/allReservations", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ReservationDTO>> viewReservations(){
        List<CottageReservation> cottageReservations = this.cottageReservationService.findAll();
        List<ReservationDTO> reservationDTOS = new ArrayList<>();
        for(CottageReservation b : cottageReservations){
            reservationDTOS.add(new ReservationDTO(b));
        }
        return new ResponseEntity<>(reservationDTOS,HttpStatus.OK);
    }



}
