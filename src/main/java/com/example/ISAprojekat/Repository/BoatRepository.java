package com.example.ISAprojekat.Repository;

import com.example.ISAprojekat.Model.Boat;
import com.example.ISAprojekat.Model.BoatOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import java.util.List;

@Repository
public interface BoatRepository extends JpaRepository<Boat, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value = "0")})
    Boat findLockedById(Long id);



}
