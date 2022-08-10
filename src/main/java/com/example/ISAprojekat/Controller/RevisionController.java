package com.example.ISAprojekat.Controller;

import com.example.ISAprojekat.Model.DTO.RevisionDTO;
import com.example.ISAprojekat.Model.Korisnik;
import com.example.ISAprojekat.Model.Revision;
import com.example.ISAprojekat.Service.AdvertiserService;
import com.example.ISAprojekat.Service.RevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "/revision", produces = MediaType.APPLICATION_JSON_VALUE)
public class RevisionController {
    @Autowired
    private RevisionService revisionService;

    @Autowired
    private AdvertiserService advertiserService;

    @GetMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Set<RevisionDTO>> getAllPendingRevisions() {
        List<Revision> revisions = revisionService.getAllPendingRevisions();

        Set<RevisionDTO> DTOs = new HashSet<>();
        for(Revision r : revisions) {
            Korisnik advertiser = advertiserService.findAdvertiserByEntityId(r.getReservation().getRentingEntity().getId());
            RevisionDTO dto = new RevisionDTO(r.getId(), r.getContent(), r.getApproved(), r.getMark(), r.getId(), r.getReservation().getClient().getEmailAddress(), r.getReservation().getClient().getFullName(), advertiser.getFullName(), r.getReservation().getRentingEntity().getName(), advertiser.getUloge().get(1).getName());
            DTOs.add(dto);
        }
        return new ResponseEntity<>(DTOs, HttpStatus.OK);
    }
}
