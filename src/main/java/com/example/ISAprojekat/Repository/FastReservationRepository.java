package com.example.ISAprojekat.Repository;

import com.example.ISAprojekat.Model.DTO.FastReservationDTO;
import com.example.ISAprojekat.Model.DTO.ReservationDTO;
import com.example.ISAprojekat.Model.FastReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;
import java.util.Date;
import java.util.List;

public interface FastReservationRepository extends JpaRepository<FastReservation,Integer> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    FastReservation save(FastReservation reservation);

    @Query("select r from FastReservation r left join fetch r.rentingEntity where r.rentingEntity.id = :id")
    List<FastReservation> fetchByEntityId(@Param("id") Integer id);
    List<FastReservation> getReservationByRentingEntity_Id(Integer id);
}
