package com.example.ISAprojekat.Controller;

import com.example.ISAprojekat.DTO.BoatDTO;
import com.example.ISAprojekat.Model.Boat;
import com.example.ISAprojekat.Service.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/boats")
public class BoatController {


    @Autowired
    private BoatService boatService;


    @GetMapping(value = "/all")
    public ResponseEntity<List<BoatDTO>> getAllBoats() {

        List<Boat> boats = boatService.findAll();

        // convert boats to DTOs
        List<BoatDTO> boatDTOS = new ArrayList<>();
        for (Boat b : boats) {
            boatDTOS.add(new BoatDTO(b));
           // System.out.println(b.getBoatName());
        }

        return new ResponseEntity<>(boatDTOS, HttpStatus.OK);
    }

}
