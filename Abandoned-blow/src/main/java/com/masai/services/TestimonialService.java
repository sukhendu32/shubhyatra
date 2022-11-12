package com.masai.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.TestimonialException;
import com.masai.models.Feedback;
import com.masai.models.Report;

public interface TestimonialService {
	
	public Feedback customerFeedback(Integer customerId, Feedback feedback) throws CustomerException;
	
	public Report adminReport(Report report);
    
	public Report findReportById(Integer reportId) throws TestimonialException;

	public Feedback findFeedbackById(Integer customerId) throws CustomerException;
	
	public List<Feedback> findAllFeedbacks();
	
	public List<Report> findAllReports();

	
	
}
