package com.example.ISAprojekat.Repository;

import com.example.ISAprojekat.Model.BoatOwner;
import com.example.ISAprojekat.Model.Cottage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CottageRepository extends JpaRepository<Cottage,Integer> {
}
