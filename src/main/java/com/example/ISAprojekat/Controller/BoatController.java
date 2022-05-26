package com.example.ISAprojekat.Controller;

import com.example.ISAprojekat.Model.Boat;
import com.example.ISAprojekat.Model.Cottage;
import com.example.ISAprojekat.Model.DTO.BoatDTO;
import com.example.ISAprojekat.Model.DTO.CottageDTO;
import com.example.ISAprojekat.Service.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/boats")
public class BoatController {


    @Autowired
    private BoatService boatService;


    //get all boats
    @GetMapping(value = "/all")
    public ResponseEntity<List<BoatDTO>> getAllBoats() {

        List<Boat> boats = boatService.findAll();

        // convert boats to DTOs
        List<BoatDTO> boatDTOS = new ArrayList<>();
        for (Boat b : boats) {
            boatDTOS.add(new BoatDTO(b));
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
        return new ResponseEntity<>(boatDTO, HttpStatus.FOUND);
    }

}
