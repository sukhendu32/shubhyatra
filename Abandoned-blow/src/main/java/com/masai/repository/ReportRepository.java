package com.masai.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Report;
import com.masai.model.User;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {
	
	public List<Report> findByDate(LocalDate date);
	
	public List<Report> findByReportId(Integer reportId);
	
	public List<Report> findByReportName(String reportName);
	
	public List<Report> findByReportType(String reportType);
	
	public List<Report> findByUser(User user);
	
}
