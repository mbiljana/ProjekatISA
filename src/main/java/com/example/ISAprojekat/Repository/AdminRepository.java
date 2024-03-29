package com.example.ISAprojekat.Repository;

import com.example.ISAprojekat.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Admin findByUsernameAndPassword(String username, String password);


    //Admin findAdminById(Long id);
}
