package com.example.ISAprojekat.Repository;

import com.example.ISAprojekat.Model.FishingInstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FishingInstructorRepository extends JpaRepository<FishingInstructor, Long> {
    FishingInstructor findByEmailAddressAndPassword(String emailAddress, String password);

   /* @Query(value = "select fi from FishingInstructor fi left join fetch fi.unavailablePeriods where fi.email = :email")
    FishingInstructor fetchByEmail(@Param("email") String email);

    @Query(value = "select fi from FishingInstructor fi left join fetch fi.unavailablePeriods where fi.id = :id")
    FishingInstructor fetchInstructorWithUnavailablePeriodsById(@Param("id") Integer id);

    @Query(value = "select fi from Adventure re left join re.fishingInstructor fi left join fetch fi.unavailablePeriods where re.id = :id")
    FishingInstructor fetchByAdventureId(@Param("id") Integer id);*/
}
