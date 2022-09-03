package com.example.ISAprojekat.Repository;

import com.example.ISAprojekat.Model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;

public interface ComplaintRepository extends JpaRepository<Complaint,Integer> {
    void deleteAllByRentingEntity_Id(Integer id);

    void deleteAllByClient_Id(Integer id);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select c from Complaint c where c.id = :id")
    @QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value ="0")})
    Complaint findOneById(@Param("id") Integer id);
}
