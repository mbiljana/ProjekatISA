package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.Sale;
import org.springframework.dao.PessimisticLockingFailureException;

import java.util.List;
import java.util.Set;

public interface SaleService {
    public Sale createSaleForEntity(Sale sale, Integer entityId) throws PessimisticLockingFailureException;
    public Set<Sale> getAllSalesForLoggedInstructor(String email);
     List<Sale> findAll();
}
