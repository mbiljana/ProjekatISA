package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.*;
import com.example.ISAprojekat.Model.DTO.RejectRegistrationDTO;
import com.example.ISAprojekat.Repository.KorisnikRepository;
import com.example.ISAprojekat.Repository.RegistrationRequestRepository;
import com.example.ISAprojekat.Service.RegistrationRequestService;
import com.example.ISAprojekat.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.util.List;

@Service
public class RegistrationRequestServiceImpl implements RegistrationRequestService {

    @Autowired
    private RegistrationRequestRepository registrationRequestRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Override
    public List<RegistrationRequest> getAllRequests() {
        return registrationRequestRepository.findAll();
    }

    private Korisnik createUserFromRegistrationRequest(RegistrationRequest request) {
        Address address = request.getAddress();
        address.setId(null);

        return new Korisnik(request.getName(),
                request.getSurname(),
                request.getEmailAddress(),
                request.getPassword(),
                UserStatus.active,
                true,
                roleService.findOneByName(request.getUloga().getName()),
                new Timestamp(System.currentTimeMillis()),
                address);
    }



    private void saveFishingInstructor(RegistrationRequest request, Korisnik user) {
        FishingInstructor fishingInstructor = new FishingInstructor(user, request.getBiography());
        korisnikRepository.save(fishingInstructor);
    }

    private void saveUser(RegistrationRequest request) {
        Korisnik user = createUserFromRegistrationRequest(request);

        if(request.getUloga().getName().equals("ROLE_INSTRUCTOR")) {
            saveFishingInstructor(request, user);
        }
    }



    @Override
    public void approveRegistrationRequest(Integer id) {
        RegistrationRequest request = registrationRequestRepository.findById(id).get();
        if(request == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no such request!");

        registrationRequestRepository.delete(request);
        saveUser(request);
        //dodaj posle
        //sendApprovalEmail(request);
    }

    @Override
    public void rejectRegistrationRequest(RejectRegistrationDTO rejectRegistrationDTO) {
        RegistrationRequest request = registrationRequestRepository.findById(rejectRegistrationDTO.getId()).get();
        if(request == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no such request!");

        registrationRequestRepository.delete(request);
        //dodaj posle
        //sendRejectionEmail(request, rejectRegistrationDTO.getRejectionReason());
    }
}
