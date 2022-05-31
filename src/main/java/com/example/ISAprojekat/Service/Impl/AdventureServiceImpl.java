package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.Adventure;
import com.example.ISAprojekat.Repository.AdventureRepository;
import com.example.ISAprojekat.Service.AdventureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdventureServiceImpl implements AdventureService {
    private final AdventureRepository adventureRepository;

    @Autowired
    public AdventureServiceImpl(AdventureRepository adventureRepository){
        this.adventureRepository = adventureRepository;
    }

    @Override
    public List<Adventure> findAll(){
        return adventureRepository.findAll();
    }
    //kreiranje novog treninga

    @Override
    public Adventure save(Adventure adventure) throws Exception{
        if(adventure.getId() != null){
            throw new Exception("ID mora biti jedinstven");
        }
        Adventure noviTrening = adventureRepository.save(adventure);
        return  noviTrening;
    }

    //brisanje postojeceg treninga preko id-a
    @Override
    public void delete(Long id){
        adventureRepository.deleteById(id);
    }

    @Override
    public Adventure findOne(Long id){
        Adventure appointment = this.adventureRepository.findById(id).get();
        return appointment;
        //return treningRepository.getOne(id);
    }
    @Override
    public Adventure update(Adventure adventure) throws Exception {
        Adventure uslugaZaIzmenu = this.adventureRepository.findById(adventure.getId()).get();
        if(adventure.getId() == null) {
            throw new Exception("Trening ne postoji");
        }
        uslugaZaIzmenu.setAdventureName(adventure.getAdventureName());
        uslugaZaIzmenu.setAdventureAdditionalServices(adventure.getAdventureAdditionalServices());
        uslugaZaIzmenu.setAdventureAddress(adventure.getAdventureAddress());
        uslugaZaIzmenu.setAdventureCapacity(adventure.getAdventureCapacity());
        uslugaZaIzmenu.setAdventureRules(adventure.getAdventureRules());
        uslugaZaIzmenu.setPromoDescription(adventure.getPromoDescription());
        uslugaZaIzmenu.setAventureEquipment(adventure.getAventureEquipment());
        uslugaZaIzmenu.setInstructorBiography(adventure.getInstructorBiography());



        Adventure izmenjenaUsluga = this.adventureRepository.save(uslugaZaIzmenu);
        return izmenjenaUsluga;
    }

    @Override
    public List<Adventure> findAllByAdventureName(String adventureName){
        return adventureRepository.findAllByAdventureName(adventureName);
    }

}
