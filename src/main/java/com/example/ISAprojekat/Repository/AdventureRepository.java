package com.example.ISAprojekat.Repository;

import com.example.ISAprojekat.Model.Adventure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdventureRepository extends JpaRepository<Adventure, Integer> {
    List<Adventure> getAdventuresByFishingInstructor_EmailAddress(String id);

    Adventure findAdventureByName(String name);

    List<Adventure> getAdventuresByFishingInstructor_Id(Integer id);


    @Query(value = "select a from Adventure a left join fetch a.pricelistItems left join fetch a.sales where a.id = :id")
    Adventure fetchById(@Param("id") Integer id);

    @Query("select a from Adventure a left join fetch a.fishingInstructor where a.id = :id")
    Adventure fetchInstructorByAdventureId(@Param("id") Integer id);

    @Query(value = "select a from Adventure a left join fetch a.sales where a.fishingInstructor.emailAddress = :emailAddress")
    List<Adventure> fetchAdventuresByFishingInstructor_EmailAddress(@Param("emailAddress") String email);
}
