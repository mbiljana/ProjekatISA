package com.example.ISAprojekat.Controller;

import com.example.ISAprojekat.Model.*;
import com.example.ISAprojekat.Model.DTO.BoatCDTO;
import com.example.ISAprojekat.Model.DTO.BoatDTO;
import com.example.ISAprojekat.Model.DTO.CreateResDTO;
import com.example.ISAprojekat.Model.DTO.ReservationDTO;
import com.example.ISAprojekat.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/reservations")
public class ReservationController {
    private final BoatService boatService;
    private final BoatReservationService boatReservationService;
    private final RegKorisnikService regKorisnikService;
    private final CottageService cottageService;
    private final CottageReservationService cottageReservationService;

    @Autowired
    public ReservationController(BoatService boatService, BoatReservationService boatReservationService, RegKorisnikService regKorisnikService, CottageService cottageService, CottageReservationService cottageReservationService){
        this.boatReservationService = boatReservationService;
        this.boatService = boatService;
        this.regKorisnikService = regKorisnikService;
        this.cottageService = cottageService;
        this.cottageReservationService = cottageReservationService;
    }

    @GetMapping(value = "/allBoat")
    public ResponseEntity<List<ReservationDTO>> getAllReservations() {

        List<BoatReservation> reservations = this.boatReservationService.findAll();
        // convert boats to DTOs
        List<ReservationDTO> reservationDTOS = new ArrayList<>();
        for (BoatReservation b : reservations) {
            reservationDTOS.add(new ReservationDTO(b));
        }

        return new ResponseEntity<>(reservationDTOS, HttpStatus.OK);
    }
    @GetMapping(value = "/allCottage")
    public ResponseEntity<List<ReservationDTO>> getAllReservationsCottage() {

        List<CottageReservation> reservations = this.cottageReservationService.findAll();
        // convert boats to DTOs
        List<ReservationDTO> reservationDTOS = new ArrayList<>();
        for (CottageReservation b : reservations) {
            reservationDTOS.add(new ReservationDTO(b));
        }

        return new ResponseEntity<>(reservationDTOS, HttpStatus.OK);
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
        this.boatReservationService.create(reservation);
        CreateResDTO resDTO1 = new CreateResDTO(
                reservation.getId(),reservation.getResName(),
                reservation.getStartDate(),reservation.getEndDate(),
                reservation.getBoat().getId(),reservation.getRegKorisnik().getId()
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
        this.cottageReservationService.create(reservation);
        CreateResDTO resDTO1 = new CreateResDTO(
                reservation.getId(),reservation.getResName(),
                reservation.getStartDate(),reservation.getEndDate(),
                reservation.getCottage().getId(),reservation.getRegKorisnik().getId()
        );
        return new ResponseEntity<>(resDTO1,HttpStatus.CREATED);
    }



}
