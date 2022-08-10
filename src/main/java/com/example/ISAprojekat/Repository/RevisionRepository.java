package com.example.ISAprojekat.Repository;

import com.example.ISAprojekat.Model.Revision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import java.util.List;

public interface RevisionRepository extends JpaRepository<Revision,Integer> {
    List<Revision> findAllByOrderByIdAsc();

    void deleteAllByReservation_Id(Integer id);

    @Query(value = "select avg(r.mark) from Revision r where r.reservation.rentingEntity.id = :id and r.isApproved = true")
    double getAverageGradeOfEntityById(@Param("id") Integer id);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select r from Revision r where r.id = :id")
    @QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value ="0")})
    Revision findOneById(@Param("id") Integer id);
}
