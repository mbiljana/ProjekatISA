package com.example.ISAprojekat.Controller;

import com.example.ISAprojekat.Model.*;
import com.example.ISAprojekat.Model.DTO.*;
import com.example.ISAprojekat.Repository.CottageRepository;
import com.example.ISAprojekat.Service.*;
import com.example.ISAprojekat.Service.Impl.CottageServiceImpl;
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
    private final CottageIncomeService cottageIncomeService;

    @Autowired
    public CottageController(CottageService cottageService, OcenaService ocenaService, FastReservationCottService fastReservationCottService,CottageReservationService cottageReservationService, CottageIncomeService cottageIncomeService){
        this.cottageService = cottageService;
        this.ocenaService = ocenaService;
        this.fastReservationCottService = fastReservationCottService;
        this.cottageReservationService = cottageReservationService;
        this.cottageIncomeService = cottageIncomeService;
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
        cottage.setLatitude(cottageDTO.getLatitude());
        cottage.setLongitude(cottageDTO.getLongitude());
        String img1 = cottageDTO.getImageEnt1().substring(12);
        String img2 = cottageDTO.getImageEnt2().substring(12);
        String img3 = cottageDTO.getImageExt1().substring(12);
        String img4 = cottageDTO.getImageExt2().substring(12);
        cottage.setImageEnt1(img1);
        cottage.setImageEnt2(img2);
        cottage.setImageExt1(img3);
        cottage.setImageExt2(img4);
        this.cottageService.save(cottage);
        CottageDTO cottageDTO1 = new CottageDTO(
                cottage.getId(), cottage.getCottageName(), cottage.getCottageAddress(),
                cottage.getCottageDescription(),cottage.getNumRooms(),cottage.getNumBeds(),
                cottage.getCottageAdditionalServices(), cottage.getCottageRules(),
                cottage.getCancelCondition(),cottage.getLatitude(), cottage.getLongitude(),
                cottage.getImageEnt1(), cottage.getImageEnt2(), cottage.getImageExt1(),
                cottage.getImageExt2()
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
       // float price = cottage.getPrice() * cottDTO.getDuration();
        FastReservationCott fastReservation = new FastReservationCott();
        fastReservation.setCapacity(cottDTO.getCapacity());
        fastReservation.setAdditionalServices(cottDTO.getAdditionalServices());
        fastReservation.setDuration(cottDTO.getDuration());
        fastReservation.setPrice(cottDTO.getPrice());
        fastReservation.setStartDate(cottDTO.getStartDate());
        fastReservation.setCottage(cottage);
        fastReservation.setResName(cottDTO.getResName());
        this.fastReservationCottService.create(fastReservation);
        cottage.getFastReservations().add(fastReservation);
        CreateCottageResDTO createCottageResDTO = new CreateCottageResDTO();
        createCottageResDTO.setCottId(fastReservation.getCottage().getId());
        createCottageResDTO.setCapacity(fastReservation.getCapacity());
        createCottageResDTO.setDuration(fastReservation.getDuration());
        createCottageResDTO.setPrice(fastReservation.getPrice());
        createCottageResDTO.setStartDate(fastReservation.getStartDate());
        createCottageResDTO.setAdditionalServices(fastReservation.getAdditionalServices());
        createCottageResDTO.setResName(fastReservation.getResName());

        List<CottageIncome> cottInc = cottage.getCottageIncome();
        CottageIncome income = new CottageIncome(createCottageResDTO.getPrice(),cottage);
        cottInc.add(income);
        //this.cottageService.save(cottage);
        this.cottageIncomeService.save(income);

        return new ResponseEntity<>(createCottageResDTO,HttpStatus.CREATED);
    }

    @PostMapping(value = "/remove",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> removal(@RequestBody IdDTO id) {
        this.cottageService.delete(id.getIdKorisnika());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping(value = "/allReservations")
    public ResponseEntity<List<FastReservationDTO>> viewReservations(){
        List<FastReservationCott> cottReservation = this.fastReservationCottService.findAll();
        List<FastReservationDTO> reservationDTOS = new ArrayList<>();
        for(FastReservationCott b : cottReservation){
            b.setId(b.getId());
            reservationDTOS.add(new FastReservationDTO(b));
        }
        return new ResponseEntity<>(reservationDTOS,HttpStatus.OK);
    }

    //all income
    @GetMapping(value = "/income")
    public ResponseEntity<IncomeDTO> getAllBoatIncome(){

        List<CottageIncome> allIncome = this.cottageIncomeService.findAll();
        IncomeDTO retIncome = new IncomeDTO();
        float sum = 0;
        for (CottageIncome i: allIncome) {
            sum = sum + i.getIncome();
        }
        retIncome.setIncome(sum);
        //CottageIncome income = new CottageIncome(sum);
        //cottageIncomeService.save(income);

        return new ResponseEntity<>(retIncome,HttpStatus.OK);

    }



}
