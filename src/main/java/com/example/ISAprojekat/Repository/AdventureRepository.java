package com.example.ISAprojekat.Repository;

import com.example.ISAprojekat.Model.Adventure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdventureRepository extends JpaRepository<Adventure, Long> {
}
