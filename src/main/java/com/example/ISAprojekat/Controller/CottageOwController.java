package com.example.ISAprojekat.Controller;

import com.example.ISAprojekat.Model.BoatOwner;
import com.example.ISAprojekat.Model.CottageOwner;
import com.example.ISAprojekat.Model.DTO.OwnerDTO;
import com.example.ISAprojekat.Service.CottageOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/cottageowners")
public class CottageOwController {
    private final CottageOwnerService cottageOwnerService;
    @Autowired
    public CottageOwController(CottageOwnerService cottageOwnerService){
        this.cottageOwnerService = cottageOwnerService;
    }

    //get one cottage owner
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OwnerDTO> getCottageOwner(@PathVariable("id")Long id){
        CottageOwner boatOwner = this.cottageOwnerService.getOne(id);
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
}
