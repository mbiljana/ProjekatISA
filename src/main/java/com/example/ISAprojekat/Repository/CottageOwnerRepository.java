package com.example.ISAprojekat.Repository;

import com.example.ISAprojekat.Model.BoatOwner;
import com.example.ISAprojekat.Model.CottageOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CottageOwnerRepository extends JpaRepository<CottageOwner,Long> {

    CottageOwner findByEmailAddressAndPassword(String emailAddress, String password);
    CottageOwner findByUsernameAndPassword(String username, String password);
    CottageOwner findByUsername(String username);
}
