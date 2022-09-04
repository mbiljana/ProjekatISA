package com.example.ISAprojekat.Repository;

import com.example.ISAprojekat.Model.BoatOwner;
import com.example.ISAprojekat.Model.BoatReservation;
import com.example.ISAprojekat.Model.Cottage;
import com.example.ISAprojekat.Model.CottageReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import java.util.List;

public interface CottageRepository extends JpaRepository<Cottage,Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value = "0")})
    Cottage findLockedById(Long id);

}
