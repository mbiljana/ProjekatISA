package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.DTO.RevisionDTO;
import com.example.ISAprojekat.Model.Korisnik;
import com.example.ISAprojekat.Model.RentingEntity;
import com.example.ISAprojekat.Model.Revision;
import com.example.ISAprojekat.Repository.EntityRepository;
import com.example.ISAprojekat.Repository.FastReservationRepository;
import com.example.ISAprojekat.Repository.RevisionRepository;
import com.example.ISAprojekat.Service.AdvertiserService;
import com.example.ISAprojekat.Service.RevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.rmi.NoSuchObjectException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RevisionServiceImpl implements RevisionService {
   /* @Autowired
    private RevisionRepository revisionRepository;

    @Autowired
    private FastReservationRepository reservationRepository;

    @Autowired
    private EntityRepository entityRepository;

    @Autowired
    private AdvertiserService advertiserService;

    @Override
    public void saveClientRevision(RevisionDTO dto){
        Revision revision=new Revision(dto.getContent(),dto.getMark(),dto.isApproved(),reservationRepository.findById(dto.getReservationId()).get());
        revisionRepository.save(revision);
    }

    @Override
    public List<Revision> getAllPendingRevisions() {
        return revisionRepository.findAllByOrderByIdAsc().stream().filter(r -> r.getApproved() == Boolean.FALSE).collect(Collectors.toList());
    }

    @Override
    public Revision getById(Integer id) {
        return revisionRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) throws NoSuchObjectException {
        Revision revision = revisionRepository.findOneById(id);
        if (revision == null) throw new NoSuchObjectException("No such revision");
        revisionRepository.delete(revision);
    }

    @Override
    @Transactional
    public void approveRevision(Integer id) throws NoSuchObjectException {
        Revision revision = revisionRepository.findOneById(id);
        if (revision == null || revision.getApproved()) throw new NoSuchObjectException("No such revision");

        revision.setApproved(true);
        revisionRepository.save(revision);

        RentingEntity reviewedEntity = entityRepository.findById(revision.getReservation().getRentingEntity().getId()).get();
        double newAverageGrade = revisionRepository.getAverageGradeOfEntityById(reviewedEntity.getId());
        reviewedEntity.setAverageGrade(newAverageGrade);
        entityRepository.save(reviewedEntity);

        sendEmailToAdvertiser(revision, newAverageGrade);
    }
    @Override
    public void sendEmailToAdvertiser(Revision revision, double newAverageGrade) {
        Korisnik advertiser = advertiserService.findAdvertiserByEntityId(revision.getReservation().getRentingEntity().getId());

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hello, ").append(advertiser.getName()).append(" ").append(advertiser.getSurname())
                .append("\nNew revision for your service ").append(revision.getReservation().getRentingEntity().getName()).append(" is approved.")
                .append("\nRevision content: ").append(revision.getContent())
                .append("\nGrade: ").append(revision.getMark())
                .append("\nNew average grade is ").append(newAverageGrade);

        //emailService.sendSimpleMessage(advertiser.getEmailAddress(), "New revision approved", stringBuilder.toString());
    }*/
}
