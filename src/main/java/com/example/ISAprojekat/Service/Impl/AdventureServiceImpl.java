package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.*;
import com.example.ISAprojekat.Repository.AdventureRepository;
import com.example.ISAprojekat.Repository.KorisnikRepository;
import com.example.ISAprojekat.Repository.PriceListItemRepository;
import com.example.ISAprojekat.Service.AdventureService;
import com.example.ISAprojekat.Service.FishingInstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AdventureServiceImpl implements AdventureService {
    private final AdventureRepository adventureRepository;
    private final KorisnikRepository userRepository;
    private final FishingInstructorService fishingInstructorService;


    private final PriceListItemRepository priceListItemRepository;

    @Autowired
    public AdventureServiceImpl(AdventureRepository adventureRepository, KorisnikRepository userRepository, FishingInstructorService fishingInstructorService,
    PriceListItemRepository priceListItemRepository){
        this.adventureRepository = adventureRepository;
        this.userRepository = userRepository;
        this.fishingInstructorService = fishingInstructorService;
        this.priceListItemRepository = priceListItemRepository;
    }

    @Override
    public List<Adventure> findAll(){
        return adventureRepository.findAll();
    }
    //kreiranje novog treninga

    @Override
    @Transactional
    public void save(Adventure adventure) throws IOException {
        //Set<String> images = saveImages(adventure);
        //adventure.setImages(images);

        Korisnik user = userRepository.findByUsername(adventure.getFishingInstructor().getUsername());
        FishingInstructor instructor = (FishingInstructor) user;
        adventure.setFishingInstructor(instructor);

        for(UnavailablePeriod up : fishingInstructorService.getAllUnavailablePeriodsForInstructor(instructor.getUsername())) {
            UnavailablePeriod unavailablePeriod = new UnavailablePeriod(up.getFromDateTime(), up.getToDateTime());
            adventure.getUnavailablePeriods().add(unavailablePeriod);
        }

        adventureRepository.save(adventure);

        Set<PriceListItem> items = adventure.getPricelistItems();
        for(PriceListItem item: items){
            item.setRentingEntity(adventure);
            this.priceListItemRepository.save(item);
        }
    }

    @Override
    @CachePut(cacheNames = "adventure", key = "#adventure.id")
    public Adventure update(Adventure adventure) throws IOException {
        Adventure adventureToUpdate = this.findById(adventure.getId());
        adventureToUpdate.setName(adventure.getName());
        adventureToUpdate.setDescription(adventure.getDescription());
        adventureToUpdate.setMaxPersons(adventure.getMaxPersons());
        adventureToUpdate.setCancellationPercentage(adventure.getCancellationPercentage());
        adventureToUpdate.setAllowedBehavior(adventure.getAllowedBehavior());
        adventureToUpdate.setUnallowedBehavior(adventure.getUnallowedBehavior());
        adventureToUpdate.setFishingEquipment(adventure.getFishingEquipment());
        adventureToUpdate.setImages(adventure.getImages());

        adventureToUpdate.setPricelistItems(adventure.getPricelistItems());
        for (PriceListItem item : adventureToUpdate.getPricelistItems()){
            item.setRentingEntity(adventureToUpdate);
        }

        adventureToUpdate.setAddress(adventure.getAddress());

        return adventureRepository.save(adventureToUpdate);
    }

    //brisanje postojeceg treninga preko id-a
    @Override
    public void delete(Integer id){
        adventureRepository.deleteById(id);
    }


    @Override
    public Adventure findOne(Integer id){
        Adventure appointment = this.adventureRepository.findById(id).get();
        return appointment;
        //return treningRepository.getOne(id);
    }
   /* @Override
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
    }*/

    @Override
    public Adventure fetchById(Integer id) throws IOException {
        Adventure adventure = adventureRepository.fetchById(id);
        adventure.setUnavailablePeriods(new HashSet<>());
        return adventure;
    }

    @Cacheable("adventure")
    public Adventure findById(Integer id) {
        return adventureRepository.findById(id).get();
    }

    public List<Adventure> getAllAdventuresFromInstructor(String email) {
        return adventureRepository.getAdventuresByFishingInstructor_EmailAddress(email);
    }

    public Adventure findByName(String name) {
        return adventureRepository.findAdventureByName(name);
    }

}
