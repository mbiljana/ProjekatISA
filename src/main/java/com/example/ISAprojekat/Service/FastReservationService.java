package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.DTO.ReservationDTO;
import com.example.ISAprojekat.Model.FastReservation;
import org.springframework.dao.PessimisticLockingFailureException;

import java.util.List;

public interface FastReservationService {
    FastReservation getOne(Integer id);
    List<FastReservation> findAll();
    FastReservation create(FastReservation fastReservation) throws Exception;
    void delete(Integer id);
    Boolean isEntityBookedNow(Integer id);
    public Boolean Save(FastReservation reservation);
    public boolean saveTransactional(FastReservation reservation);
    public List<FastReservation> getReservationsByEntityId(Integer id);
    public List<FastReservation> getAllFinishedReservations();
    //public List<ReservationDTO> cancelReservation(Integer id,String email);
    //public List<ReservationDTO> getClientFutureReservations(String email);
    public void saveTransactionalForTest(FastReservation reservation);
   // public List<ReservationDTO> getHistoryOfReservations(String email,String classType);
    public ReservationDTO saveReservationCreatedByAdvertiser(FastReservation newReservation, Integer entityId) throws PessimisticLockingFailureException;
    public FastReservation saveReservationIfThereIsNoOverlapping(FastReservation newReservation);
    public FastReservation saveReservationAdv(FastReservation newReservation);
}
