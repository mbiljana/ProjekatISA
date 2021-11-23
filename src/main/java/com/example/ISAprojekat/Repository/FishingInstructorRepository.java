package com.example.ISAprojekat.Repository;

import com.example.ISAprojekat.Model.Admin;
import com.example.ISAprojekat.Model.FishingInstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FishingInstructorRepository extends JpaRepository<FishingInstructor, Long> {
}
