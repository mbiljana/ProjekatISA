package com.example.ISAprojekat.Repository;

import com.example.ISAprojekat.Model.Cottage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CottageRepository extends JpaRepository<Cottage, Long> {
}
