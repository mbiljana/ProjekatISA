package com.example.ISAprojekat.Repository;

import com.example.ISAprojekat.Model.RegistrationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;
import java.util.List;
import java.util.Optional;

public interface RegistrationRequestRepository extends JpaRepository<RegistrationRequest, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    RegistrationRequest findByEmailAddress(String email);
    Optional<RegistrationRequest> findById(Integer id);
}
