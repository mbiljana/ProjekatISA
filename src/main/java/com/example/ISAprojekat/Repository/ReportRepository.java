package com.example.ISAprojekat.Repository;

import com.example.ISAprojekat.Model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report,Integer> {
    void deleteAllByRentingEntity_Id(Integer id);

    //void deleteAllByClient_Id(Integer id);
}
