package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.DTO.RejectRegistrationDTO;
import com.example.ISAprojekat.Model.RegistrationRequest;

import java.util.List;

public interface RegistrationRequestService {
    List<RegistrationRequest> getAllRequests();
    void approveRegistrationRequest(Integer id);
    void rejectRegistrationRequest(RejectRegistrationDTO rejectRegistrationDTO);
}
