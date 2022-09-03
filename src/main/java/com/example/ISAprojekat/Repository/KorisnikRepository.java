package com.example.ISAprojekat.Repository;


import com.example.ISAprojekat.Model.Admin;
import com.example.ISAprojekat.Model.Client;
import com.example.ISAprojekat.Model.DTO.KorisnikDTO;
import com.example.ISAprojekat.Model.FishingInstructor;
import com.example.ISAprojekat.Model.Korisnik;
import com.example.ISAprojekat.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Integer> {
    Korisnik findByUsernameAndPassword(String username, String password);
    Korisnik findByEmailAddressAndPassword(String email, String password);
    Korisnik findByUsername(String username);
    //Korisnik getByEmailAddress(String email);
    Korisnik findByEmailAddress(String email);
    @Query(value = "select fi from FishingInstructor fi left join fetch fi.unavailablePeriods where fi.emailAddress = :email")
    FishingInstructor fetchByEmailAddress(@Param("email") String email);

    @Query("select new com.example.ISAprojekat.Model.DTO.KorisnikDTO(u) from Korisnik u where u.username = ?1")
    KorisnikDTO myProfileInformation(String username);

    @Query(value = "select fi from FishingInstructor fi left join fetch fi.unavailablePeriods where fi.id = :id")
    FishingInstructor fetchInstructorWithUnavailablePeriodsById(@Param("id") Integer id);

    @Query(value = "select fi from Adventure re left join re.fishingInstructor fi left join fetch fi.unavailablePeriods where re.id = :id")
    FishingInstructor fetchByAdventureId(@Param("id") Integer id);

    @Query(value = "select c from Client c left join fetch c.subscriptions")
    List<Client> fetchAllClients();

    @Query(value="select client from Client client left join fetch client.subscriptions where client.emailAddress = ?1" )
    Client fetchClientWithSubscriptions(String email);

    @Query(value = "select client from Client client where ?1 in (select s.id from client.subscriptions s)")
    List<Client> fetchClientsSubscribedToEntity(Integer id);
}
