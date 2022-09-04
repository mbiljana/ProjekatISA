package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.BoatReservation;
import com.example.ISAprojekat.Model.Cottage;
import com.example.ISAprojekat.Model.CottageOwner;
import com.example.ISAprojekat.Model.CottageReservation;

import java.util.List;

public interface CottageService {
    Cottage getOne(Long id);
    List<Cottage> findAll();
    Cottage save (Cottage cottage) throws Exception;
    void delete(Long id);
    Cottage update(Cottage cottage);
    CottageReservation checkIfAlreadyReserved(CottageReservation reservation);
}
