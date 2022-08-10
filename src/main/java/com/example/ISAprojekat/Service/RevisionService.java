package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.DTO.RevisionDTO;
import com.example.ISAprojekat.Model.Revision;

import java.rmi.NoSuchObjectException;
import java.util.List;

public interface RevisionService {
    void saveClientRevision(RevisionDTO dto);
    List<Revision> getAllPendingRevisions();
    Revision getById(Integer id);
    void deleteById(Integer id) throws NoSuchObjectException;
    void approveRevision(Integer id) throws NoSuchObjectException;
    void sendEmailToAdvertiser(Revision revision, double newAverageGrade);
}
