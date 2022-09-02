package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.Income;

import java.util.List;

public interface IncomeService {
    Income save(Income income);
    List<Income> findAll();
}
