package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.Ocena;
import com.example.ISAprojekat.Repository.BoatRepository;
import com.example.ISAprojekat.Repository.CottageRepository;
import com.example.ISAprojekat.Repository.OcenaRepository;
import com.example.ISAprojekat.Service.OcenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OcenaServiceImpl implements OcenaService {

    private final OcenaRepository ocenaRepository;
    private final BoatRepository boatRepository;
    private final CottageRepository cottageRepository;
    @Autowired
    public OcenaServiceImpl(OcenaRepository ocenaRepository, BoatRepository boatRepository, CottageRepository cottageRepository){
        this.ocenaRepository = ocenaRepository;
        this.boatRepository = boatRepository;
        this.cottageRepository = cottageRepository;
    }

    @Override
    public Ocena findOne(Integer id) {
        Ocena ocena  = this.ocenaRepository.findById(id).get();
        return ocena;
    }

    @Override
    public List<Ocena> findAll() {
        List<Ocena> ocene = this.ocenaRepository.findAll();
        return ocene;
    }

    @Override
    public float srednjaVikendica(List<Ocena> ocenas, Integer cott_id) {
        float suma =0;
        int velicina = ocenas.size();
        for(Ocena o : ocenas) {
            if (o.getCottage().getId() == cott_id) {
                suma += o.getOcena();
                suma = suma / velicina;
            }
        }
        return suma;
    }

    @Override
    public float srednjaBrod(List<Ocena> ocenas, Integer boat_id) {
        float suma =0;
        int velicina = ocenas.size();
        for(Ocena o : ocenas) {
            if (o.getBoat().getId() == boat_id) {
                suma += o.getOcena();
                suma = suma / velicina;
            }
        }
        return suma;
    }
}
