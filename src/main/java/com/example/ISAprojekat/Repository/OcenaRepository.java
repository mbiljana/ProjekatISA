package com.example.ISAprojekat.Repository;

import com.example.ISAprojekat.Model.Ocena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OcenaRepository extends JpaRepository<Ocena,Integer> {
}
