package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.BoatReservation;
import com.example.ISAprojekat.Model.CottageReservation;

import java.util.List;

public interface CottageReservationService {
    List<CottageReservation> findAll();
    CottageReservation create(CottageReservation cottageReservation) throws Exception;
    void delete (Long idRes);
}
