package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.FastReservation;

import java.util.List;

public interface FastReservationService {
    FastReservation getOne(Integer id);
    List<FastReservation> findAll();
    FastReservation create(FastReservation fastReservation) throws Exception;
    void delete(Integer id);
    Boolean isEntityBookedNow(Integer id);
}
