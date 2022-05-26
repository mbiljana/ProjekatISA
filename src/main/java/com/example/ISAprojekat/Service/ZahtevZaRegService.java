package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.BoatOwner;
import com.example.ISAprojekat.Model.DTO.ZahtevZaRegDTO;
import com.example.ISAprojekat.Model.ZahtevZaReg;

public interface ZahtevZaRegService {
    ZahtevZaReg save (ZahtevZaReg zahtevZaReg) throws Exception;
    ZahtevZaReg findOne(Long id);
}
