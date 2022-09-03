package com.example.ISAprojekat.Controller;


import com.example.ISAprojekat.Model.DTO.DeleteRequestDTO;
import com.example.ISAprojekat.Model.DeleteRequest;
import com.example.ISAprojekat.Service.DeleteRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.rmi.NoSuchObjectException;
import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/deleteRequest", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class DeleteRequestController {

    @Autowired
    DeleteRequestService deleteRequestService;

    @PostMapping("")
   //@PreAuthorize("hasAnyRole('ADMIN', 'CLIENT', 'COTTAGE_OWNER', 'SHIP_OWNER', 'INSTRUCTOR')")
    public ResponseEntity<Void> saveDeleteRequest(@RequestBody String content, Principal principal) {
        deleteRequestService.save(principal.getName(), content);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("")
   // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Set<DeleteRequestDTO>> getAllDeleteRequests() {
        List<DeleteRequest> requests = deleteRequestService.getAllRequests();

        Set<DeleteRequestDTO> DTOs = new HashSet<>();
        for (DeleteRequest r : requests) {
            DeleteRequestDTO dto = new DeleteRequestDTO(r.getId(), r.getKorisnik().getEmailAddress(), r.getKorisnik().getName(), r.getKorisnik().getSurname(), r.getKorisnik().getPhoneNumber(), r.getKorisnik().getRole().name(), r.getContent());
            DTOs.add(dto);
        }
        return new ResponseEntity<>(DTOs, HttpStatus.OK);
    }

    @PutMapping("/reject/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> rejectDeleteRequest(@PathVariable("id") Integer id, @RequestBody String response) {
        try {
            deleteRequestService.rejectDeleteRequest(id, response);
        } catch (NoSuchObjectException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No such request.");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Another administrator is dealing with this request! Try again later.");
        }

        return new ResponseEntity<>("Delete request rejected!", HttpStatus.OK);
    }

    @PutMapping("/approve")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> approveDeleteRequest(@RequestBody Integer id) {
        try {
            deleteRequestService.approveDeleteRequest(id);
        } catch (NoSuchObjectException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No such request.");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Another administrator is dealing with this request! Try again later.");
        }

        return new ResponseEntity<>("Delete request approved", HttpStatus.OK);
    }
}
