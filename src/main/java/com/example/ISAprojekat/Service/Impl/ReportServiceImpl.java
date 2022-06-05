package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.Report;
import com.example.ISAprojekat.Repository.ReportRepository;
import com.example.ISAprojekat.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;
    @Autowired
    public ReportServiceImpl(ReportRepository reportRepository){
        this.reportRepository = reportRepository;
    }

    @Override
    public Report create(Report report) {
        Report report1 = this.reportRepository.save(report);
        return report1;
    }
}
