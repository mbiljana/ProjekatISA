package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.Adventure;
import com.example.ISAprojekat.Model.RentingEntity;
import com.example.ISAprojekat.Repository.*;
import com.example.ISAprojekat.Service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Cacheable;
import java.util.List;

@Service
public class EntityServiceImpl implements EntityService {
    @Autowired
    private EntityRepository entityRepository;

    @Autowired
    private KorisnikRepository userRepository;

    @Autowired
    private FastReservationRepository reservationRepository;

    @Autowired
    private RevisionRepository revisionRepository;

    /*@Autowired
    private IComplaintRepository complaintRepository;*/

    @Autowired
    private ReportRepository reportRepository;



    public List<? extends RentingEntity> GetAllEntities(int state){
        List<? extends RentingEntity> entities=null;
        //if(state==0)entities=entityRepository.getEntityByClass(Adventure.class);
        //else if(state==1)entities=entityRepository.getEntityByClass(Ship.class);
        //else if(state==2) entities=entityRepository.getEntityByClass(Cottage.class);
        return entities;
    }

    @Override
    //@Cacheable("entity")
    public RentingEntity getEntityById(Integer id) {
        return entityRepository.findById(id).get();
    }


}
