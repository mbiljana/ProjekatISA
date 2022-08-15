package com.example.ISAprojekat.Controller;


import com.example.ISAprojekat.Model.Client;
import com.example.ISAprojekat.Model.DTO.ReportDTO;
import com.example.ISAprojekat.Model.Korisnik;
import com.example.ISAprojekat.Model.Report;
import com.example.ISAprojekat.Service.AdvertiserService;
import com.example.ISAprojekat.Service.EntityService;
import com.example.ISAprojekat.Service.KorisnikService;
import com.example.ISAprojekat.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/report", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class ReportController {
    /*@Autowired
    private ReportService reportService;

    @Autowired
    private EntityService entityService;
    @Autowired
    private KorisnikService userService;

    @Autowired
    private AdvertiserService advertiserService;

    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('COTTAGE_OWNER', 'SHIP_OWNER', 'INSTRUCTOR','ADMIN')")
    public ResponseEntity<String> addNewReport(Principal user, @RequestBody ReportDTO reportDTO)  {
        //Report report = new Report(reportDTO.getContent(), reportDTO.isBadReview(), reportDTO.isNotAppeared(),
                //new Client(this.userService.getByUsername(reportDTO.getEntityName())),
                //this.entityService.getEntityById(reportDTO.getRentingEntityId()));
        //this.reportService.save(report);
        return new ResponseEntity<>("Report sent to administrator!", HttpStatus.CREATED);
    }

    @GetMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Set<ReportDTO>> getAllReports() {
        List<Report> reports = reportService.getAllReports();

        Set<ReportDTO> DTOs = new HashSet<>();
        for(Report r : reports) {
            Korisnik advertiser = advertiserService.findAdvertiserByEntityId(r.getRentingEntity().getId());
            ReportDTO dto = new ReportDTO(r.getContent(), r.isBadReview(), r.isNotAppeared(), r.getClient().getEmailAddress(), r.getRentingEntity().getId(),r.getClient().getFullName(), r.getRentingEntity().getName());
            DTOs.add(dto);
        }
        return new ResponseEntity<>(DTOs, HttpStatus.OK);
    }*/
}
