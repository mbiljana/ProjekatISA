package com.example.ISAprojekat.Controller;

import com.example.ISAprojekat.Model.*;
import com.example.ISAprojekat.Model.DTO.CreateResDTO;
import com.example.ISAprojekat.Model.DTO.ResIncomeDTO;
import com.example.ISAprojekat.Model.DTO.ReservationDTO;
import com.example.ISAprojekat.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "api/reservations")
public class ReservationController {


    @Autowired
    private FastReservationService reservationService;

    @Autowired
    private EntityService entityService;

    @Autowired
    SaleService saleService;

    //private ModelMapper modelMapper = new ModelMapper();
    /*private final BoatService boatService;
    private final BoatReservationService boatReservationService;
    private final RegKorisnikService regKorisnikService;
    private final CottageService cottageService;
    private final CottageReservationService cottageReservationService;
    private final FastReservationService fastReservationService;

    @Autowired
    public ReservationController(BoatService boatService, BoatReservationService boatReservationService, RegKorisnikService regKorisnikService, CottageService cottageService, CottageReservationService cottageReservationService,
                                 FastReservationService fastReservationService){
        this.boatReservationService = boatReservationService;
        this.boatService = boatService;
        this.regKorisnikService = regKorisnikService;
        this.cottageService = cottageService;
        this.cottageReservationService = cottageReservationService;
        this.fastReservationService = fastReservationService;
    }



    @GetMapping(value = "/allBoat")
    public ResponseEntity<List<ResIncomeDTO>> getAllReservations() {

        List<BoatReservation> reservations = this.boatReservationService.findAll();
        // convert boats to DTOs
        List<ResIncomeDTO> incomeDTO = new ArrayList<>();
        for (BoatReservation b : reservations) {
                ResIncomeDTO resIncomeDTO = new ResIncomeDTO(
                        b.getResName(), b.getStartDate(),
                        b.getBoat().getPrice() * b.getDuration()
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
                    b.getResName(), b.getStartDate(),
                    b.getCottage().getPrice()*b.getDuration()
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
        this.boatReservationService.create(reservation);
        CreateResDTO resDTO1 = new CreateResDTO(
                reservation.getId(),reservation.getResName(),
                reservation.getStartDate(),reservation.getEndDate(),
                reservation.getBoat().getId(),reservation.getRegKorisnik().getId(),
                reservation.getDuration()
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
                reservation.getCottage().getId(),reservation.getRegKorisnik().getId(),
                reservation.getDuration()
        );
        return new ResponseEntity<>(resDTO1,HttpStatus.CREATED);
    }*/

    /*@PostMapping(value = "/createByAdvertiser")
    @PreAuthorize("hasAnyRole('COTTAGE_OWNER, SHIP_OWNER, INSTRUCTOR')")
    public ResponseEntity<ReservationDTO> saveReservationByAdvertiser(@RequestBody ReservationDTO reservationDTO) {
        FastReservation reservation = modelMapper.map(reservationDTO, FastReservation.class);
        //reservation.setRentingEntity(this.entityService.getEntityById(reservationDTO.getEntityId()));
        //reservation.getRentingEntity().setVersion(reservationDTO.getEntityVersion());
        ReservationDTO createdReservation = fastReservationService.saveReservationCreatedByAdvertiser(reservation, reservationDTO.getEntityId());
        return new ResponseEntity<>(createdReservation, HttpStatus.CREATED);
    }*/

    /*@GetMapping(value = "/booked/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAnyRole('COTTAGE_OWNER', 'SHIP_OWNER', 'INSTRUCTOR', 'ADMIN')")
    public ResponseEntity<Boolean> isEntityBooked(@PathVariable("id") Integer id) {
        Boolean isBooked = fastReservationService.isEntityBookedNow(id);
        return new ResponseEntity<>(isBooked, HttpStatus.OK);
    }*/

    @GetMapping(value = "/entity/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<ReservationDTO>> getReservationsByEntityId(@PathVariable("id") Integer id) {
        List<FastReservation> reservations = reservationService.getReservationsByEntityId(id);

        Set<ReservationDTO> reservationDTOS = new HashSet<>();
        for(FastReservation r : reservations) {
            ReservationDTO dto = new ReservationDTO(r.getId(), r.getStartDate(), r.getDuration(), r.getCapacity(), r.getPrice(), r.getCanceled(), r.getRentingEntity().getId(), r.getRentingEntity().getName());
            reservationDTOS.add(dto);
        }
        return new ResponseEntity<>(reservationDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/booked/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    //@PreAuthorize("hasAnyRole('COTTAGE_OWNER', 'SHIP_OWNER', 'INSTRUCTOR')")
    public ResponseEntity<Boolean> isEntityBooked(@PathVariable("id") Integer id) {
        Boolean isBooked = reservationService.isEntityBookedNow(id);
        return new ResponseEntity<>(isBooked, HttpStatus.OK);
    }

    //ne radi
   /* @PostMapping(value = "/createByAdvertiser")
   // @PreAuthorize("hasAnyRole('COTTAGE_OWNER, SHIP_OWNER, INSTRUCTOR')")
    public ResponseEntity<ReservationDTO> saveReservationByAdvertiser(@RequestBody ReservationDTO reservationDTO) {
        FastReservation reservation = modelMapper.map(reservationDTO, Reservation.class);
        //reservation.setRentingEntity(this.entityService.getEntityById(reservationDTO.getEntityId()));
        //reservation.getRentingEntity().setVersion(reservationDTO.getEntityVersion());
        ReservationDTO createdReservation = reservationService.saveReservationCreatedByAdvertiser(reservation, reservationDTO.getEntityId());
        return new ResponseEntity<>(createdReservation, HttpStatus.CREATED);
    }*/
}
