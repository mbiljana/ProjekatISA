package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.Ocena;

import java.util.List;

public interface OcenaService {
    Ocena findOne(Integer id);
    List<Ocena> findAll();
    float srednjaBrod(List<Ocena> ocenas, Integer boat_id);
    float srednjaVikendica(List<Ocena> ocenas, Integer cott_id);
}
