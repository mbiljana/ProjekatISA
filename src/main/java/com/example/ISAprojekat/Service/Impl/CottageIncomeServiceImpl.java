package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.CottageIncome;
import com.example.ISAprojekat.Repository.CottageIncomeRepository;
import com.example.ISAprojekat.Service.CottageIncomeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CottageIncomeServiceImpl implements CottageIncomeService {

    private final CottageIncomeRepository cottageIncomeRepository;

    public CottageIncomeServiceImpl(CottageIncomeRepository cottageIncomeRepository){
        this.cottageIncomeRepository = cottageIncomeRepository;
    }

    @Override
    public CottageIncome save(CottageIncome cottageIncome) {
        return this.cottageIncomeRepository.save(cottageIncome);
    }

    @Override
    public List<CottageIncome> findAll() {
        return this.cottageIncomeRepository.findAll();
    }
}
