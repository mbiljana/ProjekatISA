package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.ZahtevZaBrisanje;

import java.util.List;

public interface ZahtevZaBrisanjeService {
    ZahtevZaBrisanje save(ZahtevZaBrisanje zahtevZaBrisanje);
    List<ZahtevZaBrisanje> findAll();
    ZahtevZaBrisanje findOne(Long id);
}
