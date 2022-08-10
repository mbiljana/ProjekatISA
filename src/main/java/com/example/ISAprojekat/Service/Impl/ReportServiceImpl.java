package com.example.ISAprojekat.Service.Impl;

import com.example.ISAprojekat.Model.Report;
import com.example.ISAprojekat.Repository.ReportRepository;
import com.example.ISAprojekat.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Override
    public void save(Report report) {
        this.reportRepository.save(report);
    }
    @Override
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }
}
