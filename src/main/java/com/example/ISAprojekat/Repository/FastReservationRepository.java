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

    /*@Query("SELECT new com.example.ISAprojekat.Model.DTO.ReservationDTO(r.id,r.startDate,r.duration,r.capacity,r.price,r.isCanceled,r.rentingEntity.id,r.rentingEntity.name)  " +
            "FROM FastReservation r where r.client.emailAddress = ?1 and r.isCanceled = false and r.startDate > ?2")
    List<ReservationDTO> fetchByClientEmail(String email, Date date);

    @Query("Select r FROM FastReservation r left join fetch r.rentingEntity e left join fetch e.unavailablePeriods where r.id=?1")
    FastReservation fetchWithUnavailablePeriods(Integer id);

    @Query("SELECT new com.example.ISAprojekat.Model.DTO.ReservationDTO(r.id,r.startDate,r.duration,r.capacity,r.price,r.isCanceled,r.rentingEntity.id,r.rentingEntity.name)  " +
            "FROM FastReservation r left join r.rentingEntity e WHERE type(e) = ?3 and r.client.emailAddress = ?1 and r.isCanceled = false and r.startDate < ?2")
    List<ReservationDTO> fetchHistoryByClientEmail(String email, Date date,Class<?> type);*/

    @Query("SELECT r FROM FastReservation r left join fetch r.rentingEntity WHERE r.rentingEntity.name = :name and r.isCanceled = false")
    List<FastReservation> fetchByEntityName(@Param("name") String name);
}
