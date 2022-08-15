package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.Korisnik;
import com.example.ISAprojekat.Model.RentingEntity;
import com.example.ISAprojekat.Repository.DeleteRequestRepository;
import com.example.ISAprojekat.Repository.KorisnikRepository;
import com.example.ISAprojekat.Service.DeleteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeleteUserServiceImpl implements DeleteUserService {
   /* @Autowired
    private KorisnikRepository korisnikRepository;


    @Autowired
    private DeleteRequestRepository deleteRequestRepository;

    @Override
    @Transactional
    public void deleteUser(Integer id) {
        Korisnik registeredUser = korisnikRepository.findById(id).get();
        deleteRequestRepository.deleteAllByKorisnik_id(id);
        //complaintRepository.deleteAllByClient_Id(registeredUser.getId());

        if (registeredUser.getUloge().get(1).equals("ROLE_COTTAGE_OWNER") ||
                registeredUser.getUloge().get(1).equals("ROLE_SHIP_OWNER") ||
                registeredUser.getUloge().get(1).equals("ROLE_INSTRUCTOR")) {
           /* List<? extends RentingEntity> entities = advertiserService.findEntitiesByAdvertiserId(registeredUser.getId());

            if(entities != null) {
                for(RentingEntity entity : entities ) {
                    entityService.deleteEntity(entity.getId());
                }
            }
        }

        if (registeredUser.getUloge().get(1).equals("ROLE_CLIENT")) {
            reportRepository.deleteAllByClient_Id(registeredUser.getId());

            List<Reservation> reservations = reservationRepository.getReservationsByClient_Id(registeredUser.getId());
            for(Reservation r : reservations) {
                revisionRepository.deleteAllByReservation_Id(r.getId());
            }
            reservationRepository.deleteAllByClient_Id(registeredUser.getId());
        }

        //this.verificationTokenService.DeleteTokenByUser(registrationRequestRepository.getById(id));
        userRepository.delete(registeredUser);
    }*/
        //}
   // }
}