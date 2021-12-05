package com.example.ISAprojekat.Repository;

import com.example.ISAprojekat.Model.Admin;
import com.example.ISAprojekat.Model.Boat;
import com.example.ISAprojekat.Model.BoatOwner;
import com.example.ISAprojekat.Model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findByUsernameAndPassword(String username, String password);


    //Admin findAdminById(Long id);
}
