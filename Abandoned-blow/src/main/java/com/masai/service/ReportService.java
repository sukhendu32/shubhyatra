package com.masai.service;

import java.util.List;

import com.masai.exception.ReportException;
import com.masai.model.Report;

public interface ReportService {

	/*
	 * All Functions ->
	 * Administrator Access
	 */
	public Report addReport(Report report, String authKey) throws ReportException;
	public List<Report> viewAllReports(String authKey) throws ReportException;
	public Report deleteReport(Integer reportId, String authKey) throws ReportException;
	
}
