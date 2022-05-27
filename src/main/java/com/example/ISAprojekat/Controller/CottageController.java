package com.example.ISAprojekat.Controller;

import com.example.ISAprojekat.Model.Cottage;
import com.example.ISAprojekat.Model.CottageOwner;
import com.example.ISAprojekat.Model.DTO.CottageDTO;
import com.example.ISAprojekat.Repository.CottageRepository;
import com.example.ISAprojekat.Service.CottageService;
import com.example.ISAprojekat.Service.Impl.CottageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/cottages")
public class CottageController {

    private final CottageService cottageService;

    @Autowired
    public CottageController(CottageService cottageService){
        this.cottageService = cottageService;
    }

    //get all cottages
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CottageDTO>> getCottages(){
        List<Cottage>cottages = this.cottageService.findAll();
        List<CottageDTO> cottageDTOS = new ArrayList<>();
        for(Cottage f : cottages){
            CottageDTO cottageDTO = new CottageDTO(f.getCottageName(),f.getCottageAddress(),
                    f.getCottageDescription(),f.getNumRooms(),f.getNumBeds(),f.getCottageAdditionalServices(),f.getCottageRules());
            cottageDTOS.add(cottageDTO);
        }

        return new ResponseEntity<>(cottageDTOS, HttpStatus.FOUND);
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
        return new ResponseEntity<>(cottageDTO, HttpStatus.FOUND);
    }

}
