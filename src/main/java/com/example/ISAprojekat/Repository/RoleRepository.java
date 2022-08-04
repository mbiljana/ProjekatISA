package com.example.ISAprojekat.Repository;

import com.example.ISAprojekat.Model.Role;
import com.example.ISAprojekat.Model.Uloga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Uloga, Long> {
    List<Uloga> findByName(String name);
    Uloga findOneByName(String name);
}