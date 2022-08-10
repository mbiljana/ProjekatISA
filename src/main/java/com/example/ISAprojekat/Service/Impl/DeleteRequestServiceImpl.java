package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.DeleteRequest;
import com.example.ISAprojekat.Model.Korisnik;
import com.example.ISAprojekat.Repository.DeleteRequestRepository;
import com.example.ISAprojekat.Repository.KorisnikRepository;
import com.example.ISAprojekat.Service.DeleteRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.rmi.NoSuchObjectException;
import java.util.List;

@Service
public class DeleteRequestServiceImpl implements DeleteRequestService {

    @Autowired
    private DeleteRequestRepository deleteRequestRepository;

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Override
    @Transactional(readOnly = false)
    public void save(String username,String content){
        Korisnik user=korisnikRepository.findByUsername(username);
        DeleteRequest deleteRequest = new DeleteRequest(content,user);
        deleteRequestRepository.save(deleteRequest);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DeleteRequest> getAllRequests() {
        return deleteRequestRepository.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public void rejectDeleteRequest(Integer requestId, String response) throws NoSuchObjectException {
        DeleteRequest deleteRequest = deleteRequestRepository.findOneById(requestId);
        if (deleteRequest == null) throw new NoSuchObjectException("No such revision");

        deleteRequestRepository.delete(deleteRequest);
        //sendRejectionEmail(deleteRequest.getRegisteredUser().getEmail(), response);
    }

    /*private void sendRejectionEmail(String email, String response) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Your request for deleting account has been rejected by administrator.")
                .append("\nReason for rejection: ").append(response);

        emailService.sendSimpleMessage(email, "Delete Request Rejected", stringBuilder.toString());
    }*/

    @Override
    @Transactional(readOnly = false)
    public void approveDeleteRequest(Integer id) throws NoSuchObjectException {
        DeleteRequest deleteRequest = deleteRequestRepository.findOneById(id);
        if (deleteRequest == null) throw new NoSuchObjectException("No such revision");

        Korisnik registeredUser = deleteRequest.getKorisnik();
        //deleteUserService.deleteUser(registeredUser.getId());
        //sendApprovalEmail(registeredUser.getEmail());
    }

    /*private void sendApprovalEmail(String email) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Your request for deleting account has been approved by administrator.")
                .append("\nYour account is now deleted.");

        emailService.sendSimpleMessage(email, "Delete Request Approved", stringBuilder.toString());
    }*/
}
