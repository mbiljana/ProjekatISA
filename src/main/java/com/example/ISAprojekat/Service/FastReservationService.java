package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.FastReservation;

import java.util.List;

public interface FastReservationService {
    FastReservation getOne(Long id);
    List<FastReservation> findAll();
    FastReservation create(FastReservation fastReservation) throws Exception;
    void delete(Long id);
}
