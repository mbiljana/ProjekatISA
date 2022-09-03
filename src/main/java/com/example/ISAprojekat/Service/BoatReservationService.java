package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.BoatReservation;
import com.example.ISAprojekat.Model.FastReservation;

import java.util.List;

public interface BoatReservationService {
    List<BoatReservation> findAll();
    BoatReservation create(BoatReservation boatReservation) throws Exception;
    void delete (Long idRes);
    List<FastReservation> getFastReservations();
    Boolean Save(BoatReservation reservation);
}
