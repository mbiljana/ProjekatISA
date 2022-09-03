package com.example.ISAprojekat.Controller;

import com.example.ISAprojekat.Model.*;
import com.example.ISAprojekat.Model.DTO.*;
import com.example.ISAprojekat.Service.*;
import com.example.ISAprojekat.Service.Impl.DateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "api/reservations")
public class ReservationController {
    private final BoatService boatService;
    private final BoatReservationService boatReservationService;
    private final RegKorisnikService regKorisnikService;
    private final CottageService cottageService;
    private final CottageReservationService cottageReservationService;
    private final IncomeService incomeService;
    private final CottageIncomeService cottageIncomeService;
    private final DateConverter dateConverter;
    private final BoatVisitsService boatVisitsService;
    private final CottageVisitsService cottageVisitsService;

    @Autowired
    public ReservationController(BoatService boatService, BoatReservationService boatReservationService,
                                 RegKorisnikService regKorisnikService, CottageService cottageService,
                                 CottageReservationService cottageReservationService,
                                 IncomeService incomeService,CottageIncomeService cottageIncomeService,
                                 DateConverter dateConverter, BoatVisitsService boatVisitsService,
                                 CottageVisitsService cottageVisitsService){
        this.boatReservationService = boatReservationService;
        this.boatService = boatService;
        this.regKorisnikService = regKorisnikService;
        this.cottageService = cottageService;
        this.cottageReservationService = cottageReservationService;
        this.incomeService = incomeService;
        this.cottageIncomeService = cottageIncomeService;
        this.dateConverter = dateConverter;
        this.boatVisitsService = boatVisitsService;
        this.cottageVisitsService = cottageVisitsService;
    }

    @GetMapping(value = "/allBoat")
    public ResponseEntity<List<ResIncomeDTO>> getAllReservations() {

        List<BoatReservation> reservations = this.boatReservationService.findAll();
        // convert boats to DTOs
        List<ResIncomeDTO> incomeDTO = new ArrayList<>();
        for (BoatReservation b : reservations) {
                ResIncomeDTO resIncomeDTO = new ResIncomeDTO(
                        b.getResName(), b.getStartDate(),b.getEndDate(),b.getDuration(),
                        b.getBoat().getPrice() * b.getDuration(), b.getNumPeople()
                );
                incomeDTO.add(resIncomeDTO);
        }
        return new ResponseEntity<>(incomeDTO, HttpStatus.OK);
    }
    @GetMapping(value = "/allCottage")
    public ResponseEntity<List<ResIncomeDTO>> getAllReservationsCottage() {

        List<CottageReservation> reservations = this.cottageReservationService.findAll();
        // convert boats to DTOs
        List<ResIncomeDTO> incomeDTOS = new ArrayList<>();
        for (CottageReservation b : reservations) {
            ResIncomeDTO resIncomeDTO = new ResIncomeDTO(
                    b.getResName(), b.getStartDate(),b.getEndDate(),b.getDuration(),
                    b.getCottage().getPrice()*b.getDuration(),b.getNumPeople()
            );
            incomeDTOS.add(resIncomeDTO);
        }

        return new ResponseEntity<>(incomeDTOS, HttpStatus.OK);
    }

    @PostMapping(value = "/createBoatRes",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateResDTO> createBoatRes(@RequestBody ReservationDTO resDTO) throws Exception{
        BoatReservation reservation = new BoatReservation();
        Boat boat = this.boatService.getOne(resDTO.getOfferId());
        RegKorisnik regKorisnik = this.regKorisnikService.getOne(resDTO.getKorisnikId());
        reservation.setBoat(boat);
        reservation.setResName(resDTO.getResName());
        reservation.setStartDate(resDTO.getStartDate());
        reservation.setEndDate(resDTO.getEndDate());
        reservation.setRegKorisnik(regKorisnik);
        reservation.setPrice(resDTO.getPrice());
        reservation.setNumPeople(resDTO.getNumPeople());
        //this.boatReservationService.create(reservation);
        boolean saved = this.boatReservationService.Save(reservation);
        if(!saved) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The given period is occupied!");

        Income income = new Income(reservation.getPrice(), boat);
        this.incomeService.save(income);
        LocalDate ld = this.dateConverter.convertToLocalDateViaInstant(reservation.getStartDate());
        LocalDate ld2 = this.dateConverter.convertToLocalDateViaInstant(reservation.getEndDate());


        BoatVisits boatVisits = new BoatVisits(reservation.getNumPeople(), ld, ld2, boat);
        this.boatVisitsService.save(boatVisits);

        CreateResDTO resDTO1 = new CreateResDTO(
                reservation.getId(),reservation.getResName(),
                reservation.getStartDate(),reservation.getEndDate(),
                reservation.getBoat().getId(),reservation.getRegKorisnik().getId(),
                reservation.getDuration(),reservation.getPrice(), reservation.getNumPeople()
        );
        return new ResponseEntity<>(resDTO1,HttpStatus.CREATED);
    }

    @PostMapping(value = "/createCottageRes",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateResDTO> createCottRes(@RequestBody ReservationDTO resDTO) throws Exception{
        CottageReservation reservation = new CottageReservation();
        Cottage cottage = this.cottageService.getOne(resDTO.getOfferId());
        RegKorisnik regKorisnik = this.regKorisnikService.getOne(resDTO.getKorisnikId());
        reservation.setCottage(cottage);
        reservation.setResName(resDTO.getResName());
        reservation.setStartDate(resDTO.getStartDate());
        reservation.setEndDate(resDTO.getEndDate());
        reservation.setRegKorisnik(regKorisnik);
        reservation.setPrice(resDTO.getPrice());
        reservation.setNumPeople(resDTO.getNumPeople());
        this.cottageReservationService.create(reservation);

        CottageIncome cottageIncome = new CottageIncome(reservation.getPrice(),cottage);
        this.cottageIncomeService.save(cottageIncome);
        LocalDate ld = this.dateConverter.convertToLocalDateViaInstant(reservation.getStartDate());
        LocalDate ld2 = this.dateConverter.convertToLocalDateViaInstant(reservation.getEndDate());


        CottageVisits cottageVisits = new CottageVisits(reservation.getNumPeople(), ld, ld2, cottage);
        this.cottageVisitsService.save(cottageVisits);
        CreateResDTO resDTO1 = new CreateResDTO(
                reservation.getId(),reservation.getResName(),
                reservation.getStartDate(),reservation.getEndDate(),
                reservation.getCottage().getId(),reservation.getRegKorisnik().getId(),
                reservation.getDuration(), reservation.getPrice(), reservation.getNumPeople()
        );


        return new ResponseEntity<>(resDTO1,HttpStatus.CREATED);
    }




}
