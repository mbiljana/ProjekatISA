package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.FastReservation;
import com.example.ISAprojekat.Model.FastReservationCott;

import java.util.List;

public interface FastReservationCottService {
    FastReservationCott getOne(Long id);
    List<FastReservationCott> findAll();
    FastReservationCott create(FastReservationCott fastReservation) throws Exception;
    void delete(Long id);
}
