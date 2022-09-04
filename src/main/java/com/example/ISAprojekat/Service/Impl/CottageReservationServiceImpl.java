package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.Boat;
import com.example.ISAprojekat.Model.BoatReservation;
import com.example.ISAprojekat.Model.Cottage;
import com.example.ISAprojekat.Model.CottageReservation;
import com.example.ISAprojekat.Model.DTO.CreateResDTO;
import com.example.ISAprojekat.Model.DTO.ReservationDTO;
import com.example.ISAprojekat.Repository.CottageRepository;
import com.example.ISAprojekat.Repository.CottageReservationRepository;
import com.example.ISAprojekat.Service.CottageReservationService;
import com.example.ISAprojekat.Service.CottageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CottageReservationServiceImpl implements CottageReservationService {

    private final CottageReservationRepository cottageReservationRepository;
    private final CottageRepository cottageRepository;
    private final CottageService cottageService;

    @Autowired
    public CottageReservationServiceImpl(CottageReservationRepository cottageReservationRepository,
                                         CottageRepository cottageRepository,CottageService cottageService){
        this.cottageReservationRepository = cottageReservationRepository;
        this.cottageRepository = cottageRepository;
        this.cottageService = cottageService;
    }

    @Override
    public List<CottageReservation> findAll() {
        List<CottageReservation> cottageReservations = this.cottageReservationRepository.findAll();
        return cottageReservations;
    }

    @Override
    public CottageReservation create(CottageReservation cottageReservation) throws Exception {
        if(cottageReservation.getId() != null){
            throw new Exception("Reservation must be unique");
        }
        CottageReservation newB = this.cottageReservationRepository.save(cottageReservation);
        return  newB;
    }

    @Override
    public void delete(Long idRes) {
        this.cottageReservationRepository.deleteById(idRes);
    }

    @Override
    @Transactional
    public Boolean Save(CottageReservation reservation){
        try {
            reservation.setCottage(this.cottageRepository.findLockedById(reservation.getCottage().getId()));
        } catch(PessimisticLockingFailureException ex) { throw  new PessimisticLockingFailureException("This boat is already reserved!!"); }
        CottageReservation updatedReservation=cottageService.checkIfAlreadyReserved(reservation);
        if(updatedReservation==null)
            return false;
        if(!saveTransactional(updatedReservation)) return false;
        return true;
    }

    @Transactional()
    public boolean saveTransactional(CottageReservation reservation){
        try{
            CottageReservation savedReservation = cottageReservationRepository.save(reservation);
            Cottage entity = reservation.getCottage();
            entity.getCottageReservation().add(savedReservation);
            cottageRepository.save(entity);
        }catch (ObjectOptimisticLockingFailureException e){
            return false;
        }catch(PessimisticLockingFailureException ex){
            return false;
        }
        return true;
    }



    @Override
    @Transactional
    public CottageReservation SaveCott(CottageReservation reservation){
        try {
            reservation.setCottage(this.cottageRepository.findLockedById(reservation.getCottage().getId()));
        } catch(PessimisticLockingFailureException ex) { throw  new PessimisticLockingFailureException("This boat is already reserved!!"); }
        return this.cottageReservationRepository.save(reservation);
    }




}
