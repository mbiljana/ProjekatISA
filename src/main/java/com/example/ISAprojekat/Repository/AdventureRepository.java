package com.example.ISAprojekat.Repository;

import com.example.ISAprojekat.Model.Adventure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdventureRepository extends JpaRepository<Adventure, Integer> {
    //List<Adventure> findAllByAdventureName(String adventureName);
    //List<Adventure> getAdventuresByFishingInstructor_EmailAddress(String email);
    List<Adventure> getAdventuresByFishingInstructor_Id(Integer id);

    @Query("select a from Adventure a left join fetch a.fishingInstructor where a.id = :id")
    Adventure fetchInstructorByAdventureId(@Param("id") Integer id);

    /*@Query(value = "select a from Adventure a left join fetch a.sales where a.fishingInstructor.emailAddress = :email")
    List<Adventure> fetchAdventuresByFishingInstructor_Email(@Param("email") String email);*/
}
