package com.example.ISAprojekat.Repository;

import com.example.ISAprojekat.Model.BoatOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface BoatOwnerRepository extends JpaRepository<BoatOwner,Long> {
    BoatOwner findByEmailAddressAndPassword(String emailAddress, String password);
}
