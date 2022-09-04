package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.FastReservation;
import com.example.ISAprojekat.Model.FastReservationCott;
import com.example.ISAprojekat.Repository.CottageRepository;
import com.example.ISAprojekat.Repository.FastReservationCottRepository;
import com.example.ISAprojekat.Repository.FastReservationRepository;
import com.example.ISAprojekat.Service.FastReservationCottService;
import com.example.ISAprojekat.Service.FastReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FastReservationCottServiceImpl implements FastReservationCottService {

    private final FastReservationCottRepository fastReservationCottRepository;
    private final CottageRepository cottageRepository;
    @Autowired
    public FastReservationCottServiceImpl(FastReservationCottRepository fastReservationRepository,
                                          CottageRepository cottageRepository){
        this.fastReservationCottRepository = fastReservationRepository;
        this.cottageRepository = cottageRepository;
    }

    @Override
    public FastReservationCott getOne(Long id) {
        FastReservationCott fastReservationCott = this.fastReservationCottRepository.findById(id).get();
        return fastReservationCott;
    }

    @Override
    public List<FastReservationCott> findAll() {
        List<FastReservationCott> fastReservationCotts = this.fastReservationCottRepository.findAll();
        return fastReservationCotts;
    }

    @Transactional
    @Override
    public FastReservationCott create(FastReservationCott fastReservation) throws Exception {
        if(fastReservation.getId() != null){
            throw new Exception("ID must be unique!");
        }

        try {
            fastReservation.setCottage(this.cottageRepository.findLockedById(fastReservation.getCottage().getId()));
        } catch(PessimisticLockingFailureException ex) { throw  new PessimisticLockingFailureException("This boat is already reserved!!"); }

        FastReservationCott newFR = this.fastReservationCottRepository.save(fastReservation);

        return  newFR;
    }

    @Override
    public void delete(Long id) {
        this.fastReservationCottRepository.deleteById(id);
    }
}
