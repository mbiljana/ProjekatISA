package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.CottageOwner;
import com.example.ISAprojekat.Model.FastReservation;
import com.example.ISAprojekat.Repository.BoatRepository;
import com.example.ISAprojekat.Repository.FastReservationRepository;
import com.example.ISAprojekat.Service.FastReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FastReservationServiceImpl implements FastReservationService {

    private final FastReservationRepository fastReservationRepository;
    private final BoatRepository boatRepository;
    @Autowired
    public FastReservationServiceImpl(FastReservationRepository fastReservationRepository,
                                      BoatRepository boatRepository){
        this.fastReservationRepository = fastReservationRepository;
        this.boatRepository = boatRepository;
    }

    @Override
    public FastReservation getOne(Long id) {
        FastReservation fastReservation = this.fastReservationRepository.findById(id).get();
        return fastReservation;
    }

    @Override
    public List<FastReservation> findAll() {
        List<FastReservation> fastReservations = this.fastReservationRepository.findAll();
        return fastReservations;
    }

    @Override
    @Transactional
    public FastReservation create(FastReservation fastReservation) throws Exception {
        if(fastReservation.getId() != null){
            throw new Exception("ID must be unique!");
        }

        try {
            fastReservation.setBoat(this.boatRepository.findLockedById(fastReservation.getBoat().getId()));
        } catch(PessimisticLockingFailureException ex) { throw  new PessimisticLockingFailureException("This boat is already reserved!!"); }

        FastReservation newFR = this.fastReservationRepository.save(fastReservation);
        return  newFR;
    }



    @Override
    public void delete(Long id) {
        this.fastReservationRepository.deleteById(id);
    }
}
