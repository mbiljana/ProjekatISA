package com.example.ISAprojekat.Controller;


import com.example.ISAprojekat.Model.DTO.RejectRegistrationDTO;
import com.example.ISAprojekat.Model.RegistrationRequest;
import com.example.ISAprojekat.Service.RegistrationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/regiRequest", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class RegistrationRequestController {

    @Autowired
    RegistrationRequestService registrationRequestService;

    @GetMapping
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<RegistrationRequest>> getAllRequests() {
        List<RegistrationRequest> registrationRequests = registrationRequestService.getAllRequests();
        return new ResponseEntity<>(registrationRequests, HttpStatus.OK);
    }

    @GetMapping("/approve/{id}")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> approveRegistrationRequest(@PathVariable("id") Integer id) {
        registrationRequestService.approveRegistrationRequest(id);
        return new ResponseEntity<>("Registration request approved!", HttpStatus.CREATED);
    }

    @PutMapping("/reject")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> rejectRegistrationRequest(@RequestBody RejectRegistrationDTO rejectRegistrationDTO) {
        registrationRequestService.rejectRegistrationRequest(rejectRegistrationDTO);
        return new ResponseEntity<>("Registration request rejected!", HttpStatus.OK);
    }

}
