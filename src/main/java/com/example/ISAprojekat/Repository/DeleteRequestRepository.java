package com.example.ISAprojekat.Repository;

import com.example.ISAprojekat.Model.DeleteRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;

@Repository
public interface DeleteRequestRepository extends JpaRepository<DeleteRequest,Long> {
    void deleteAllByKorisnik_id(Integer id);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select dr from DeleteRequest dr where dr.id = :id")
    @QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value ="0")})
    DeleteRequest findOneById(@Param("id") Integer id);
}
