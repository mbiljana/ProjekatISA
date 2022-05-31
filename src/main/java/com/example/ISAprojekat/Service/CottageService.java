package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.Cottage;
import com.example.ISAprojekat.Model.CottageOwner;

import java.util.List;

public interface CottageService {
    Cottage getOne(Long id);
    List<Cottage> findAll();
    Cottage save (Cottage cottage) throws Exception;
}
