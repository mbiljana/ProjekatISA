package com.example.ISAprojekat.Controller;


import com.example.ISAprojekat.Model.Adventure;
import com.example.ISAprojekat.Model.Boat;
import com.example.ISAprojekat.Model.DTO.*;
import com.example.ISAprojekat.Model.FastReservation;
import com.example.ISAprojekat.Service.AdventureService;
import com.example.ISAprojekat.Service.FastReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/adventures")
public class AdventureController {
    private  AdventureService adventureService;
    private FastReservationService fastReservationService;

    @Autowired
    public AdventureController(AdventureService adventureService, FastReservationService fastReservationService) {
        this.adventureService = adventureService;
        this.fastReservationService = fastReservationService;
    }

    @GetMapping(value = "/allAdventures")
    public ResponseEntity<List<AdventureDTO>> getAllAdventures() {

        List<Adventure> boats = adventureService.findAll();

        // convert boats to DTOs
        List<AdventureDTO> boatDTOS = new ArrayList<>();
        for (Adventure b : boats) {
            boatDTOS.add(new AdventureDTO(b));
        }

        return new ResponseEntity<>(boatDTOS, HttpStatus.OK);
    }

    //ne radi
    @PostMapping(value = ("/create"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdventureDTO> createAdventure(@RequestBody AdventureDTO aDTO) throws Exception {
        Adventure adventure = new Adventure();
        adventure.setAdventureName(aDTO.getAdventureName());
        //LocalDateTime now = LocalDateTime.now();
        adventure.setAdventureRules(aDTO.getAdventureRules());
        adventure.setAdventureAddress(aDTO.getAdventureAddress());
        adventure.setAdventureCapacity(aDTO.getAdventureCapacity());
        adventure.setInstructorBiography(aDTO.getInstructorBiography());
        adventure.setAventureEquipment(aDTO.getAventureEquipment());
        adventure.setAdventureAdditionalServices(aDTO.getAdventureAdditionalServices());
        adventure.setPromoDescription(aDTO.getPromoDescription());
        this.adventureService.save(adventure);
        AdventureDTO adventureDTO = new AdventureDTO(adventure.getId(),adventure.getAdventureName(), adventure.getAdventureAddress()
                ,adventure.getPromoDescription(), adventure.getInstructorBiography(), adventure.getAdventureCapacity(),
                adventure.getAdventureRules(),adventure.getAventureEquipment(), adventure.getAdventureAdditionalServices());
        return new ResponseEntity<>(adventureDTO, HttpStatus.CREATED);

    }



    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTermin(@PathVariable Long id) {
        this.adventureService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/search/{adventureName}")
    public ResponseEntity<List<AdventureDTO>> search(@PathVariable(name = "adventureName") String adventureName) {
        List<Adventure> boats = adventureService.findAllByAdventureName(adventureName);

        // convert boats to DTOs
        List<AdventureDTO> boatDTOS = new ArrayList<>();
        for (Adventure b : boats) {
            AdventureDTO tDTO = new AdventureDTO(b.getAdventureName(),b.getAdventureRules(),
                    b.getPromoDescription(), b.getAdventureCapacity(),
                    b.getAdventureAddress(), b.getAdventureAdditionalServices(),
                    b.getAventureEquipment(), b.getInstructorBiography());
            boatDTOS.add(new AdventureDTO(b));
        }

        return new ResponseEntity<>(boatDTOS, HttpStatus.OK);
    }

    @PostMapping(value = ("/update"),
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdventureDTO> izmena(@RequestBody AdventureDTO kDTO) throws Exception {
        Adventure listaTreninga = adventureService.findOne(kDTO.getId());
        listaTreninga.setAdventureName(kDTO.getAdventureName());
        //LocalDateTime now = LocalDateTime.now();
        listaTreninga.setAdventureRules(kDTO.getAdventureRules());
        listaTreninga.setAdventureAddress(kDTO.getAdventureAddress());
        listaTreninga.setAdventureCapacity(kDTO.getAdventureCapacity());
        listaTreninga.setInstructorBiography(kDTO.getInstructorBiography());
        listaTreninga.setAventureEquipment(kDTO.getAventureEquipment());
        listaTreninga.setAdventureAdditionalServices(kDTO.getAdventureAdditionalServices());
        listaTreninga.setPromoDescription(kDTO.getPromoDescription());
        adventureService.update(listaTreninga);
        AdventureDTO tDTO = new AdventureDTO(listaTreninga.getAdventureName(),listaTreninga.getAdventureRules(), listaTreninga.getPromoDescription(), listaTreninga.getAdventureCapacity(), listaTreninga.getAdventureAddress(), listaTreninga.getAdventureAdditionalServices(), listaTreninga.getAventureEquipment(), listaTreninga.getInstructorBiography());

        return new ResponseEntity<>(tDTO,HttpStatus.OK);

    }

    @PostMapping(value = ("/createAdventureRes"),
        consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdventureDTO> createAdventureR(@RequestBody CreateAdventureDTO rDTO) throws Exception{
        FastReservation fastReservation = new FastReservation();
        fastReservation.setCapacity(rDTO.getCapacity());
        fastReservation.setAdditionalServices(rDTO.getAdditionalServices());
        fastReservation.setDuration(rDTO.getDuration());
        fastReservation.setPrice(rDTO.getPrice());
        fastReservation.setStartDate(rDTO.getStartDate());
        fastReservation.setPlace(rDTO.getPlace());

        Adventure adventure = new Adventure();
        adventure.setAdventureRules(rDTO.getAdventureRules());
        adventure.setAdventureName(rDTO.getAdventureName());
        adventure.setAdventureAddress(rDTO.getAdventureAddress());
        adventure.setAdventureCapacity(rDTO.getAdventureCapacity());
        adventure.setInstructorBiography(rDTO.getInstructorBiography());
        adventure.setAventureEquipment(rDTO.getAventureEquipment());
        adventure.setAdventureAdditionalServices(rDTO.getAdventureAdditionalServices());
        adventure.setPromoDescription(rDTO.getPromoDescription());
        adventure.getFastReservation().add(fastReservation);
        this.fastReservationService.create(fastReservation);
        this.adventureService.save(adventure);
        AdventureDTO adventureDTO = new AdventureDTO(adventure.getId(),adventure.getAdventureName(),adventure.getAdventureRules(),
                adventure.getPromoDescription(),adventure.getInstructorBiography(),adventure.getAdventureCapacity(),adventure.getAdventureAddress(),
                adventure.getAventureEquipment(),adventure.getAdventureAdditionalServices());
        return new ResponseEntity<>(adventureDTO,HttpStatus.CREATED);
    }

    @PostMapping(value = "/createReservation",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateAdventureResDTO> createReservation(@RequestBody CreateAdventureResDTO aDTO) throws Exception{
        Adventure adventure = this.adventureService.findOne(aDTO.getAdventureId());
        FastReservation fastReservation = new FastReservation();
        fastReservation.setCapacity(aDTO.getCapacity());
        fastReservation.setAdditionalServices(aDTO.getAdditionalServices());
        fastReservation.setDuration(aDTO.getDuration());
        fastReservation.setPrice(aDTO.getPrice());
        fastReservation.setStartDate(aDTO.getStartDate());
        fastReservation.setPlace(aDTO.getPlace());
        fastReservation.setAdventure(adventure);

        this.fastReservationService.create(fastReservation);
        CreateAdventureResDTO createAdventureResDTO = new CreateAdventureResDTO();
        createAdventureResDTO.setAdventureId(fastReservation.getAdventure().getId());
        createAdventureResDTO.setCapacity(fastReservation.getCapacity());
        createAdventureResDTO.setDuration(fastReservation.getDuration());
        createAdventureResDTO.setPrice(fastReservation.getPrice());
        createAdventureResDTO.setStartDate(fastReservation.getStartDate());
        createAdventureResDTO.setPlace(fastReservation.getPlace());
        createAdventureResDTO.setAdditionalServices(fastReservation.getAdditionalServices());
        return new ResponseEntity<>(createAdventureResDTO,HttpStatus.CREATED);
    }


}
