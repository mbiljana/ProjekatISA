package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.Ocena;

import java.util.List;

public interface OcenaService {
    Ocena findOne(Long id);
    List<Ocena> findAll();
    float srednjaBrod(List<Ocena> ocenas, Long boat_id);
    float srednjaVikendica(List<Ocena> ocenas, Long cott_id);
}
