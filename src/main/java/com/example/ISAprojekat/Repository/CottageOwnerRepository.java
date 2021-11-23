package com.example.ISAprojekat.Repository;

import com.example.ISAprojekat.Model.CottageOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CottageOwnerRepository extends JpaRepository<CottageOwner, Long> {
}
