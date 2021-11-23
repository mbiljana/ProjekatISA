package com.example.ISAprojekat.Repository;

import com.example.ISAprojekat.Model.RegKorisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegUserRepository extends JpaRepository<RegKorisnik, Long> {
}
