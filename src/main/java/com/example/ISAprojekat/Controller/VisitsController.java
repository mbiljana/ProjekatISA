package com.example.ISAprojekat.Controller;

import com.example.ISAprojekat.Model.Boat;
import com.example.ISAprojekat.Model.BoatVisits;
import com.example.ISAprojekat.Model.CottageVisits;
import com.example.ISAprojekat.Model.DTO.BoatDTO;
import com.example.ISAprojekat.Model.DTO.SeasonalVisitsDTO;
import com.example.ISAprojekat.Model.DTO.VisitNumberDTO;
import com.example.ISAprojekat.Model.Ocena;
import com.example.ISAprojekat.Repository.BoatRepository;
import com.example.ISAprojekat.Service.BoatReservationService;
import com.example.ISAprojekat.Service.BoatService;
import com.example.ISAprojekat.Service.BoatVisitsService;
import com.example.ISAprojekat.Service.CottageVisitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/visits")
public class VisitsController {

    private final BoatVisitsService boatVisitsService;
    private final BoatService boatService;
    private final BoatReservationService boatReservationService;
    private final CottageVisitsService cottageVisitsService;

    @Autowired
    public VisitsController(BoatVisitsService boatVisitsService, BoatService boatService,BoatReservationService boatReservationService,CottageVisitsService cottageVisitsService){
        this.boatService = boatService;
        this.boatReservationService = boatReservationService;
        this.boatVisitsService = boatVisitsService;
        this.cottageVisitsService = cottageVisitsService;
    }


    //get number of visits from forever until now
    @GetMapping(value = "/all")
    public ResponseEntity<VisitNumberDTO> getAllVisits() {
        VisitNumberDTO vDTO = new VisitNumberDTO();

        List<BoatVisits> boatVisits  =this.boatVisitsService.findAll();
        int num =0;

        for (BoatVisits b : boatVisits) {
            num = num + b.getNumberOfVisits();
        }
        vDTO.setNumberOfVisits(num);

        return new ResponseEntity<VisitNumberDTO>(vDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/yearly")
    public ResponseEntity<VisitNumberDTO> getYearlyVisits() {
        VisitNumberDTO vDTO = new VisitNumberDTO();

        List<BoatVisits> boatVisits  =this.boatVisitsService.findAll();
        int num =0;
        LocalDate ld = LocalDate.now();

        for (BoatVisits b : boatVisits) {
            if((b.getStartDate().getYear() == ld.getYear()) && (b.getEndDate().getYear() == ld.getYear())){
                num = num + b.getNumberOfVisits();
            }else{
                num = 1;
            }

        }
        vDTO.setNumberOfVisits(num);

        return new ResponseEntity<VisitNumberDTO>(vDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/monthly")
    public ResponseEntity<VisitNumberDTO> getMonthlyVisits() {
        VisitNumberDTO vDTO = new VisitNumberDTO();

        List<BoatVisits> boatVisits  =this.boatVisitsService.findAll();
        int num =0;
        LocalDate ld = LocalDate.now();

        for (BoatVisits b : boatVisits) {
            if((b.getStartDate().getMonth() == ld.getMonth()) && (b.getEndDate().getMonth() == ld.getMonth())){
                num = num + b.getNumberOfVisits();
            }

        }
        vDTO.setNumberOfVisits(num);

        return new ResponseEntity<VisitNumberDTO>(vDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/weekly")
    public ResponseEntity<VisitNumberDTO> getWeeklyVisits() {
        VisitNumberDTO vDTO = new VisitNumberDTO();

        LocalDate today = LocalDate.now();
        //go back to monday
        LocalDate monday = today;
        while(monday.getDayOfWeek() != DayOfWeek.MONDAY){
            monday = monday.minusDays(1);
        }
        //go forward to sunday
        LocalDate sunday = today;
        while(sunday.getDayOfWeek() != DayOfWeek.SUNDAY){
            sunday = sunday.plusDays(1);
        }

        List<BoatVisits> boatVisits  =this.boatVisitsService.findAll();
        int num =0;
        System.out.println(monday);
        System.out.println(sunday);
        for (BoatVisits b : boatVisits) {
            if((b.getStartDate().getMonth() == today.getMonth()) && (b.getEndDate().getMonth() == today.getMonth())){
                if((b.getStartDate().isAfter(monday)) && (b.getEndDate().isBefore(sunday))){
                    num = num + b.getNumberOfVisits();
                }

            }

        }
        vDTO.setNumberOfVisits(num);

        return new ResponseEntity<VisitNumberDTO>(vDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/seasonal")
    public ResponseEntity<SeasonalVisitsDTO> getSeasonalVisits() {
        SeasonalVisitsDTO vDTO = new SeasonalVisitsDTO();

        List<BoatVisits> boatVisits  =this.boatVisitsService.findAll();
        int num =0;
        int ynum = 0;
        LocalDate ld = LocalDate.now();

        //get this months visits
        for (BoatVisits b : boatVisits) {
            if((b.getStartDate().getMonth() == ld.getMonth()) && (b.getEndDate().getMonth() == ld.getMonth())){
                num = num + b.getNumberOfVisits();
            }

        }
        //get this years visits
        for (BoatVisits b : boatVisits) {
            if((b.getStartDate().getYear() == ld.getYear()) && (b.getEndDate().getYear() == ld.getYear())){
                ynum = ynum + b.getNumberOfVisits();
            }

        }

        //get this weeks visits
        LocalDate today = LocalDate.now();
        //go back to monday
        LocalDate monday = today;
        while(monday.getDayOfWeek() != DayOfWeek.MONDAY){
            monday = monday.minusDays(1);
        }
        //go forward to sunday
        LocalDate sunday = today;
        while(sunday.getDayOfWeek() != DayOfWeek.SUNDAY){
            sunday = sunday.plusDays(1);
        }
        int wnum =0;
        System.out.println(monday);
        System.out.println(sunday);
        for (BoatVisits b : boatVisits) {
            if((b.getStartDate().getMonth() == today.getMonth()) && (b.getEndDate().getMonth() == today.getMonth())){
                if((b.getStartDate().isAfter(monday)) && (b.getEndDate().isBefore(sunday))){
                    wnum = wnum + b.getNumberOfVisits();
                }

            }

        }
        vDTO.setMonthlyVisits(num);
        vDTO.setYearlyVisits(ynum);
        vDTO.setWeeklyVisits(wnum);

        return new ResponseEntity<SeasonalVisitsDTO>(vDTO, HttpStatus.OK);
    }


    @GetMapping(value = "/seasonalCott")
    public ResponseEntity<SeasonalVisitsDTO> getSeasonalCottageVisits() {
        SeasonalVisitsDTO vDTO = new SeasonalVisitsDTO();


        List<CottageVisits> cottageVisits  =this.cottageVisitsService.findAll();
        int num =0;
        int ynum = 0;
        LocalDate ld = LocalDate.now();
        //get this months visits
        for (CottageVisits b : cottageVisits) {
            if((b.getStartDate().getMonth() == ld.getMonth()) && (b.getEndDate().getMonth() == ld.getMonth())){
                num = num + b.getNumberOfVisits();
            }

        }

        //get this years visits
        for (CottageVisits b : cottageVisits) {
            if((b.getStartDate().getYear() == ld.getYear()) && (b.getEndDate().getYear() == ld.getYear())){
                ynum = ynum + b.getNumberOfVisits();
            }

        }

        //get this weeks visits
        LocalDate today = LocalDate.now();
        //go back to monday
        LocalDate monday = today;
        while(monday.getDayOfWeek() != DayOfWeek.MONDAY){
            monday = monday.minusDays(1);
        }
        //go forward to sunday
        LocalDate sunday = today;
        while(sunday.getDayOfWeek() != DayOfWeek.SUNDAY){
            sunday = sunday.plusDays(1);
        }

        int wnum =0;
        System.out.println(monday);
        System.out.println(sunday);
        for (CottageVisits b : cottageVisits) {
            if((b.getStartDate().getMonth() == today.getMonth()) && (b.getEndDate().getMonth() == today.getMonth())){
                if((b.getStartDate().isAfter(monday)) && (b.getEndDate().isBefore(sunday))){
                    wnum = wnum + b.getNumberOfVisits();
                }

            }

        }
        vDTO.setMonthlyVisits(num);
        vDTO.setYearlyVisits(ynum);
        vDTO.setWeeklyVisits(wnum);

        return new ResponseEntity<SeasonalVisitsDTO>(vDTO, HttpStatus.OK);
    }

}
