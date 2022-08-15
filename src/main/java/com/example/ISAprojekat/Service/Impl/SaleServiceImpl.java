package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.*;
import com.example.ISAprojekat.Repository.*;
import com.example.ISAprojekat.Service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SaleServiceImpl implements SaleService {

   /* @Autowired
    private EntityRepository entityRepository;

    @Autowired
    private AdventureRepository adventureRepository;

    @Autowired
    private KorisnikRepository userRepository;

    @Autowired
    private FastReservationRepository fastReservationRepository;

    //@Autowired
    //private EmailService emailService;

    @Autowired
    private SaleRepository saleRepository;

    @Override
    @Transactional
    public Sale createSaleForEntity(Sale sale, Integer entityId) throws PessimisticLockingFailureException {
        RentingEntity entity;
        try {
            entity = entityRepository.findLockedById(entityId);
        } catch(PessimisticLockingFailureException ex) { throw  new PessimisticLockingFailureException("Client already reserved this entity!"); }

        entity.setSales(entityRepository.fetchWithSales(entityId).getSales());
        entity.setUnavailablePeriods(entityRepository.fetchWithPeriods(entityId).getUnavailablePeriods());

        if (overlapsWithExistingUnavailablePeriod(sale, entity))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is already defined unavailable period in this time range!");
        if (overlapsWithExistingSale(sale, entity))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is already defined sale in this time range!");
        if (overlapsWithExistingReservation(sale, entity))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is already booked reservation in this time range!");

        sale.setRentingEntity(entity);
        entity.getSales().add(sale);
        entityRepository.save(entity);

        //sendEmailForSubscribers(sale, entityId);

        return sale;
    }


    public boolean overlapsWithExistingUnavailablePeriod(Sale sale, RentingEntity entity) {
        Adventure adventure =adventureRepository.fetchInstructorByAdventureId(entity.getId());
        if (adventure != null) {

            for (UnavailablePeriod period : userRepository.fetchInstructorWithUnavailablePeriodsById(entity.getId()).getUnavailablePeriods()) {
                if(period.getFromDateTime().before(sale.getSaleEndTime()) && period.getToDateTime().after(sale.getDateTimeFrom()))
                    return true;
            }
        } else {
            for (UnavailablePeriod period : entity.getUnavailablePeriods()) {
                if(period.getFromDateTime().before(sale.getSaleEndTime()) && period.getToDateTime().after(sale.getDateTimeFrom()))
                    return true;
            }
        }

        return false;
    }

    public boolean overlapsWithExistingSale(Sale sale, RentingEntity entity) {
        for(Sale s : entity.getSales()) {
            if (s.getDateTimeFrom().before(sale.getSaleEndTime()) && s.getSaleEndTime().after(sale.getDateTimeFrom()))
                return true;
        }
        return false;
    }

    public boolean overlapsWithExistingReservation(Sale sale, RentingEntity entity) {
        List<FastReservation> reservations = fastReservationRepository.fetchByEntityId(entity.getId());
        for(FastReservation r : reservations) {
            if (r.getStartDate().before(sale.getSaleEndTime()) && r.getReservationEndTime().after(sale.getDateTimeFrom()))
                return true;
        }
        return false;
    }

    @Override
    public Set<Sale> getAllSalesForLoggedInstructor(String email) {
        List<Adventure> adventures = adventureRepository.fetchAdventuresByFishingInstructor_Email(email);

        Set<Sale> sales = new HashSet<>();
       /* for(Adventure a : adventures) {
            for(Sale s : a.getSales()) {
                s.setRentingEntity(a);
                sales.add(s);
            }
        }*/
     //   return sales;
    //}
}
