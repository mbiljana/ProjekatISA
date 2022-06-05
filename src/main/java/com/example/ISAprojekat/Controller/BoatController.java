package com.example.ISAprojekat.Controller;

import com.example.ISAprojekat.Model.Boat;
import com.example.ISAprojekat.Model.Cottage;
import com.example.ISAprojekat.Model.DTO.*;
import com.example.ISAprojekat.Model.FastReservation;
import com.example.ISAprojekat.Model.Ocena;
import com.example.ISAprojekat.Service.BoatService;
import com.example.ISAprojekat.Service.FastReservationService;
import com.example.ISAprojekat.Service.OcenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/boats")
public class BoatController {

    private final BoatService boatService;
    private final FastReservationService fastReservationService;
    private final OcenaService ocenaService;
    @Autowired
    public BoatController(BoatService boatService, FastReservationService fastReservationService, OcenaService ocenaService){
        this.boatService = boatService;
        this.fastReservationService = fastReservationService;
        this.ocenaService  =ocenaService;
    }



    //get all boats
    @GetMapping(value = "/all")
    public ResponseEntity<List<BoatDTO>> getAllBoats() {

        List<Boat> boats = this.boatService.findAll();
        List<Ocena> ocenas  =this.ocenaService.findAll();
        float ocena =0;
        // convert boats to DTOs
        List<BoatDTO> boatDTOS = new ArrayList<>();
        for (Boat b : boats) {
            ocena = this.ocenaService.srednjaBrod(ocenas,b.getId());
            boatDTOS.add(new BoatDTO(b,ocena));
        }

        return new ResponseEntity<>(boatDTOS, HttpStatus.OK);
    }

    //get one boat
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BoatDTO> getBoat(@PathVariable("id")Long id){
        Boat boat = this.boatService.getOne(id);
        BoatDTO boatDTO = new BoatDTO();
        boatDTO.setBoatAddress(boat.getBoatAddress());
        boatDTO.setBoatCapacity(boat.getBoatCapacity());
        boatDTO.setBoatName(boat.getBoatName());
        boatDTO.setBoatRules(boat.getBoatRules());
        boatDTO.setBoatType(boat.getBoatType());
        boatDTO.setAdditionalEquipment(boat.getAdditionalEquipment());
        boatDTO.setEngineNumber(boat.getEngineNumber());
        boatDTO.setEnginePower(boat.getEnginePower());
        boatDTO.setMaxSpeed(boat.getMaxSpeed());
        boatDTO.setBoatDescription(boat.getBoatDescription());
        boatDTO.setNavigationEguipment(boat.getNavigationEquimpment());
        return new ResponseEntity<>(boatDTO, HttpStatus.FOUND);
    }


    @PostMapping(value = "/createBoat",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BoatDTO> createBoatWithRes(@RequestBody BoatCDTO boatDTO) throws Exception{
        Boat boat = new Boat();
        boat.setBoatCapacity(boatDTO.getBoatCapacity());
        boat.setBoatAddress(boatDTO.getBoatAddress());
        boat.setBoatName(boatDTO.getBoatName());
        boat.setBoatRules(boatDTO.getBoatRules());
        boat.setBoatType(boatDTO.getBoatType());
        boat.setBoatDescription(boatDTO.getBoatDescription());
        boat.setBoatName(boatDTO.getBoatName());
        boat.setAdditionalEquipment(boatDTO.getAdditionalEquipment());
        boat.setEngineNumber(boatDTO.getEngineNumber());
        boat.setEnginePower(boatDTO.getEnginePower());
        boat.setMaxSpeed(boatDTO.getMaxSpeed());
        boat.setNavigationEquimpment(boatDTO.getNavigationEguipment());
        this.boatService.create(boat);
        BoatDTO boatDTO1 = new BoatDTO(
                boat.getId(),boat.getBoatName(),boat.getBoatType(),boat.getEngineNumber(),
                boat.getEnginePower(),boat.getMaxSpeed(),boat.getBoatAddress(),
                boat.getBoatCapacity(),boat.getBoatRules(),boat.getBoatDescription(),
                boat.getAdditionalEquipment(),boat.getNavigationEquimpment()
        );
        return new ResponseEntity<>(boatDTO1,HttpStatus.CREATED);
    }
    @PostMapping(value = "/createRes",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateBoatResDTO> createReservation(@RequestBody FastReservationDTO boatDTO) throws Exception{
        Boat boat = this.boatService.getOne(boatDTO.getBoatId());
        float price = boat.getPrice() * boatDTO.getDuration();
        FastReservation fastReservation = new FastReservation();
        fastReservation.setCapacity(boatDTO.getCapacity());
        fastReservation.setAdditionalServices(boatDTO.getAdditionalServices());
        fastReservation.setDuration(boatDTO.getDuration());
        fastReservation.setPrice(price);
        fastReservation.setStartDate(boatDTO.getStartDate());
        fastReservation.setBoat(boat);
        this.fastReservationService.create(fastReservation);
        boat.getFastReservation().add(fastReservation);
        CreateBoatResDTO createBoatResDTO = new CreateBoatResDTO();
        createBoatResDTO.setBoatId(fastReservation.getBoat().getId());
        createBoatResDTO.setCapacity(fastReservation.getCapacity());
        createBoatResDTO.setDuration(fastReservation.getDuration());
        createBoatResDTO.setPrice(fastReservation.getPrice());
        createBoatResDTO.setStartDate(fastReservation.getStartDate());
        createBoatResDTO.setAdditionalServices(fastReservation.getAdditionalServices());
        return new ResponseEntity<>(createBoatResDTO,HttpStatus.CREATED);
    }

    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BoatUpdateDTO> updateCottage(@RequestBody BoatUpdateIdDTO boatDTO) {
        Boat boat = this.boatService.getOne(boatDTO.getId());
        boat.setBoatName(boatDTO.getBoatName());
        boat.setBoatType(boatDTO.getBoatType());
        boat.setBoatRules(boatDTO.getBoatRules());
        boat.setBoatDescription(boatDTO.getBoatDescription());
        boat.setNavigationEquimpment(boatDTO.getNavigationEguipment());
        boat.setMaxSpeed(boatDTO.getMaxSpeed());
        boat.setEnginePower(boatDTO.getEnginePower());
        boat.setEngineNumber(boatDTO.getEngineNumber());
        boat.setBoatAddress(boatDTO.getBoatAddress());
        boat.setBoatCapacity(boatDTO.getBoatCapacity());
        boat.setAdditionalEquipment(boatDTO.getAdditionalEquipment());
        this.boatService.update(boat);
        BoatUpdateDTO boatUpdateDTO = new BoatUpdateDTO(
                boat.getBoatName(),boat.getBoatType(), boat.getEngineNumber(),
                boat.getEnginePower(),boat.getMaxSpeed(),boat.getBoatAddress(),
                boat.getBoatCapacity(),boat.getBoatRules(),boat.getBoatDescription(),
                boat.getAdditionalEquipment(),boat.getNavigationEquimpment()
        );
        return new ResponseEntity<>(boatUpdateDTO, HttpStatus.OK);
    }


    @PostMapping(value = "/remove",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> removal(@RequestBody IdDTO id) {
        this.boatService.delete(id.getIdKorisnika());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
