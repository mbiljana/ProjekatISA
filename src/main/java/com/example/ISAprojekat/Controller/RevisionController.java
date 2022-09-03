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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.rmi.NoSuchObjectException;
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
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Set<RevisionDTO>> getAllPendingRevisions() {
        List<Revision> revisions = revisionService.getAllPendingRevisions();

        Set<RevisionDTO> DTOs = new HashSet<>();
        for(Revision r : revisions) {
            Korisnik advertiser = advertiserService.findAdvertiserByEntityId(r.getReservation().getRentingEntity().getId());
            RevisionDTO dto = new RevisionDTO(r.getId(), r.getContent(), r.getApproved(), r.getMark(), r.getId(), advertiser.getFullName(), r.getReservation().getRentingEntity().getName(), advertiser.getRole().name());
            DTOs.add(dto);
        }
        return new ResponseEntity<>(DTOs, HttpStatus.OK);
    }

    @PutMapping("/approve")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> approveRevision(@RequestBody Integer id) {
        try {
            revisionService.approveRevision(id);
        } catch (NoSuchObjectException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No such revision.");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Looks like some other admin is reviewing this revision right now.");
        }
        return new ResponseEntity<>("Revision approved!", HttpStatus.OK);
    }

    @DeleteMapping("/disapprove/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> disapproveRevision(@PathVariable("id") Integer id) {
        try{
            revisionService.deleteById(id);
        } catch (NoSuchObjectException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No such revision.");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Looks like some other admin is reviewing this revision right now.");
        }
        return new ResponseEntity<>("Revision disapproved and deleted!", HttpStatus.OK);
    }
}
