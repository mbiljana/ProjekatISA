package com.example.ISAprojekat.Repository;

import com.example.ISAprojekat.Model.BoatReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoatReservationRepository extends JpaRepository<BoatReservation,Long> {

}
