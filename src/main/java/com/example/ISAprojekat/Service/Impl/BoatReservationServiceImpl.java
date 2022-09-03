package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.Boat;
import com.example.ISAprojekat.Model.BoatReservation;
import com.example.ISAprojekat.Model.FastReservation;
import com.example.ISAprojekat.Repository.BoatRepository;
import com.example.ISAprojekat.Repository.BoatReservationRepository;
import com.example.ISAprojekat.Repository.FastReservationRepository;
import com.example.ISAprojekat.Service.BoatReservationService;
import com.example.ISAprojekat.Service.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BoatReservationServiceImpl implements BoatReservationService {

    private final BoatReservationRepository boatReservationRepository;
    private final FastReservationRepository fastReservationRepository;
    private final BoatRepository boatRepository;
    private final BoatService boatService;

    @Autowired
    public BoatReservationServiceImpl(BoatReservationRepository boatReservationRepository,
                                      FastReservationRepository fastReservationRepository,
                                      BoatRepository boatRepository, BoatService boatService){
        this.boatReservationRepository = boatReservationRepository;
        this.fastReservationRepository = fastReservationRepository;
        this.boatRepository = boatRepository;
        this.boatService = boatService;
    }

    @Override
    public List<BoatReservation> findAll() {
        List<BoatReservation> boatReservations = this.boatReservationRepository.findAll();
        return boatReservations;
    }

    @Override
    public BoatReservation create(BoatReservation boatReservation) throws Exception{
        if(boatReservation.getId() != null){
            throw new Exception("Reservation must be unique");
        }
        BoatReservation newB = this.boatReservationRepository.save(boatReservation);
        return  newB;
    }

    @Override
    public void delete(Long idRes) {
        this.boatReservationRepository.deleteById(idRes);
    }

    @Override
    public List<FastReservation> getFastReservations() {
        return this.fastReservationRepository.findAll();
    }


    @Override
    @Transactional
    public Boolean Save(BoatReservation reservation){
        try {
            reservation.setBoat(this.boatRepository.findLockedById(reservation.getBoat().getId()));
        } catch(PessimisticLockingFailureException ex) { throw  new PessimisticLockingFailureException("Owner already reserved this entity!"); }
        BoatReservation updatedReservation=boatService.checkIfAlreadyReserved(reservation);
        if(updatedReservation==null)
            return false;
        if(!saveTransactional(updatedReservation)) return false;
        return true;
    }

    @Transactional()
    public boolean saveTransactional(BoatReservation reservation){
        try{
            BoatReservation savedReservation = boatReservationRepository.save(reservation);
            Boat entity = reservation.getBoat();
            entity.getBoatReservation().add(savedReservation);
            boatRepository.save(entity);
        }catch (ObjectOptimisticLockingFailureException e){
            return false;
        }catch(PessimisticLockingFailureException ex){
            return false;
        }
        return true;
    }


}
