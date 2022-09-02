package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.Cottage;
import com.example.ISAprojekat.Model.CottageIncome;

import java.util.List;

public interface CottageIncomeService {

    CottageIncome save(CottageIncome cottageIncome);
    List<CottageIncome> findAll();
}
