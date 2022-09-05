package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.ZahtevZaBrisanje;
import com.example.ISAprojekat.Repository.ZahtevZaBrisanjeRepository;
import com.example.ISAprojekat.Service.ZahtevZaBrisanjeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZahtevZaBrisanjeServiceImpl implements ZahtevZaBrisanjeService {

    private final ZahtevZaBrisanjeRepository zahtevZaBrisanjeRepository;

    @Autowired
    public ZahtevZaBrisanjeServiceImpl(ZahtevZaBrisanjeRepository zahtevZaBrisanjeRepository){
        this.zahtevZaBrisanjeRepository = zahtevZaBrisanjeRepository;
    }

    @Override
    public ZahtevZaBrisanje save(ZahtevZaBrisanje zahtevZaBrisanje) {
        return this.zahtevZaBrisanjeRepository.save(zahtevZaBrisanje);
    }

    @Override
    public List<ZahtevZaBrisanje> findAll() {
        return  this.zahtevZaBrisanjeRepository.findAll();
    }

    @Override
    public ZahtevZaBrisanje findOne(Long id) {
        return this.zahtevZaBrisanjeRepository.findById(id).get();
    }
}
