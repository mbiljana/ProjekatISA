package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.DeleteRequest;
import org.springframework.stereotype.Service;

import java.rmi.NoSuchObjectException;
import java.util.List;


public interface DeleteRequestService {
    void save(String username, String content);
    List<DeleteRequest> getAllRequests();
    void rejectDeleteRequest(Integer requestId, String response) throws NoSuchObjectException;
    void approveDeleteRequest(Integer id) throws NoSuchObjectException;
}
