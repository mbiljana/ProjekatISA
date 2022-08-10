package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.RegKorisnik;
import com.example.ISAprojekat.Repository.RegKorisnikRepository;
import com.example.ISAprojekat.Service.RegKorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegKorisnikServiceImpl implements RegKorisnikService {

    private final RegKorisnikRepository regKorisnikRepository;
    @Autowired
    public RegKorisnikServiceImpl(RegKorisnikRepository regKorisnikRepository){
        this.regKorisnikRepository = regKorisnikRepository;
    }

    @Override
    public RegKorisnik getOne(Integer id) {
        RegKorisnik regKorisnik = this.regKorisnikRepository.findById(id).get();
        return regKorisnik;
    }
}
