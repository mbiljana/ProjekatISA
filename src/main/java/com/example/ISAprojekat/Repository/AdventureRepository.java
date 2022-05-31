package com.example.ISAprojekat.Repository;

import com.example.ISAprojekat.Model.Adventure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdventureRepository extends JpaRepository<Adventure, Long> {
    List<Adventure> findAllByAdventureName(String adventureName);

}
