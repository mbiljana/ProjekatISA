package com.example.ISAprojekat.Repository;

import com.example.ISAprojekat.Model.FastReservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FastReservationRepository extends JpaRepository<FastReservation,Integer> {
    List<FastReservation> getReservationByRentingEntity_Id(Integer id);

}
