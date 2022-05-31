package com.example.ISAprojekat.Repository;


import com.example.ISAprojekat.Model.Korisnik;
import com.example.ISAprojekat.Model.Korisnikk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
    Korisnik findByUsernameAndPassword(String username, String password);
    Korisnik findByEmailAddressAndPassword(String email, String password);

}
