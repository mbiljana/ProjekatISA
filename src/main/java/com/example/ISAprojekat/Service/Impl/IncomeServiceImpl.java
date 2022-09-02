package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.Income;
import com.example.ISAprojekat.Repository.IncomeReposiroty;
import com.example.ISAprojekat.Service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeServiceImpl implements IncomeService {

    private final IncomeReposiroty incomeReposiroty;

    @Autowired
    public IncomeServiceImpl(IncomeReposiroty incomeReposiroty){
        this.incomeReposiroty = incomeReposiroty;
    }


    @Override
    public Income save(Income income) {
        return this.incomeReposiroty.save(income);
    }

    @Override
    public List<Income> findAll() {
        return this.incomeReposiroty.findAll();
    }
}
