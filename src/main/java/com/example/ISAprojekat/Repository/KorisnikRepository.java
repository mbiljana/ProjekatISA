package com.example.ISAprojekat.Repository;


import com.example.ISAprojekat.Model.Korisnik;
import com.example.ISAprojekat.Model.Korisnikk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
    Korisnik findByUsernameAndPassword(String username, String password);
}
