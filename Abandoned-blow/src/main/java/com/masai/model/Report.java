package com.masai.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Report {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer reportId;
	
	private String report;
	
	private LocalDate reportDate;
	
	
	public Report() {
		// TODO Auto-generated constructor stub
	}


	public Report(Integer reportId, String report, LocalDate reportDate) {
		super();
		this.reportId = reportId;
		this.report = report;
		this.reportDate = reportDate;
	}


	public Integer getReportId() {
		return reportId;
	}


	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}


	public String getReport() {
		return report;
	}


	public void setReport(String report) {
		this.report = report;
	}


	public LocalDate getReportDate() {
		return reportDate;
	}


	public void setReportDate(LocalDate reportDate) {
		this.reportDate = reportDate;
	}


	@Override
	public String toString() {
		return "Report [reportId=" + reportId + ", report=" + report + ", reportDate=" + reportDate + "]";
	}
	
	

}
