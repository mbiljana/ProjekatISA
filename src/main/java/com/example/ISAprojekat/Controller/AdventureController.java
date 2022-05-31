package com.example.ISAprojekat.Controller;


import com.example.ISAprojekat.Model.Adventure;
import com.example.ISAprojekat.Model.DTO.AdventureDTO;
import com.example.ISAprojekat.Service.AdventureService;
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

    @Autowired
    public AdventureController(AdventureService adventureService) {
        this.adventureService = adventureService;
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


}
