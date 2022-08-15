package com.example.ISAprojekat.Repository;

import com.example.ISAprojekat.Model.Appointment;
import com.example.ISAprojekat.Model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.beans.JavaBean;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {
}
