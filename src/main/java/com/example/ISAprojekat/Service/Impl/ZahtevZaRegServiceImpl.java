package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.BoatOwner;
import com.example.ISAprojekat.Model.ZahtevZaReg;
import com.example.ISAprojekat.Repository.ZahtevZaRegRepository;
import com.example.ISAprojekat.Service.ZahtevZaRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZahtevZaRegServiceImpl implements ZahtevZaRegService {

    private final ZahtevZaRegRepository zahtevZaRegRepository;

    @Autowired
    public ZahtevZaRegServiceImpl(ZahtevZaRegRepository zahtevZaRegRepository){
        this.zahtevZaRegRepository = zahtevZaRegRepository;
    }
    @Override
    public ZahtevZaReg save(ZahtevZaReg zahtevZaReg) throws Exception {
        if(zahtevZaReg.getId() != null){
            throw new Exception("ID must be unique!");
        }
        ZahtevZaReg novi = zahtevZaRegRepository.save(zahtevZaReg);
        return  novi;
    }

    @Override
    public ZahtevZaReg findOne(Long id) {
        ZahtevZaReg zahtevZaReg = this.zahtevZaRegRepository.findById(id).get();
        return zahtevZaReg;
    }

    @Override
    public List<ZahtevZaReg> findAll() {
        List<ZahtevZaReg> zahtevZaRegs = this.zahtevZaRegRepository.findAll();
        return zahtevZaRegs;
    }

    @Override
    public void delete(Long id) {
        this.zahtevZaRegRepository.deleteById(id);
    }
}
