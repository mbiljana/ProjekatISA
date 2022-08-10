package com.example.ISAprojekat.Service;

import com.example.ISAprojekat.Model.Report;

import java.util.List;

public interface ReportService {
    Report create(Report report);
    void save(Report report);
    List<Report> getAllReports();
}
