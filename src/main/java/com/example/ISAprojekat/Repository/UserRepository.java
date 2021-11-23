package com.example.ISAprojekat.Repository;

import com.example.ISAprojekat.Model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Korisnik, Long> {
}
