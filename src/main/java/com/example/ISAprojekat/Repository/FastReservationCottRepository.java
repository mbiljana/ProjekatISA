package com.example.ISAprojekat.Repository;

import com.example.ISAprojekat.Model.FastReservationCott;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FastReservationCottRepository extends JpaRepository<FastReservationCott, Long> {
}
