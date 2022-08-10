package com.example.ISAprojekat.Repository;


import com.example.ISAprojekat.Model.Admin;
import com.example.ISAprojekat.Model.DTO.KorisnikDTO;
import com.example.ISAprojekat.Model.FishingInstructor;
import com.example.ISAprojekat.Model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Integer> {
    Korisnik findByUsernameAndPassword(String username, String password);
    Korisnik findByEmailAddressAndPassword(String email, String password);
    Korisnik findByUsername(String username);
    //Korisnik getByEmailAddress(String email);
    Korisnik findByEmailAddress(String email);
    @Query(value = "select fi from FishingInstructor fi left join fetch fi.unavailablePeriods where fi.emailAddress = :email")
    FishingInstructor fetchByEmail(@Param("email") String email);

    @Query("select new com.example.ISAprojekat.Model.DTO.KorisnikDTO(u) from Korisnik u where u.username = ?1")
    KorisnikDTO myProfileInformation(String username);
}
