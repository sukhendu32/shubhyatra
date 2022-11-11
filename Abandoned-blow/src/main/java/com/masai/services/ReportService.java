package com.masai.services;

import java.util.List;

import com.masai.models.Report;


public interface ReportService {
	
    public Report registerReport(Report report);
	
	public Report deleteReportById(Integer reportId);
	
	public List<Report> viewAllReport();

}
