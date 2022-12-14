package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.UserException;
import com.masai.exceptions.TestimonialException;
import com.masai.models.Feedback;
import com.masai.models.Report;
import com.masai.services.TestimonialService;

@RestController
@RequestMapping("/travel")
public class TestimonialController {
	
	@Autowired
	private TestimonialService tService;
	
	
	@PostMapping("/customer/feedback/{customerId}")
	public ResponseEntity<Feedback> customerFeedback(@PathVariable("customerId") Integer customerId,
			@RequestBody Feedback feedback ) throws UserException
	{
		Feedback f = tService.customerFeedback(customerId, feedback);
		
		return new ResponseEntity<Feedback>(f,HttpStatus.CREATED);
	}
	
	@PostMapping("/admin/report")
	public ResponseEntity<Report> adminReport(@RequestBody Report report)
	{
		Report r = tService.adminReport(report);
		
		return new ResponseEntity<Report>(r,HttpStatus.CREATED);
	}
	
	@GetMapping("/customer/feedback/{customerId}")
	public ResponseEntity<Feedback> findFeedbackById(@PathVariable("customerId") Integer customerId) throws UserException
	{
		Feedback f = tService.findFeedbackById(customerId);
		
		return new ResponseEntity<Feedback>(f,HttpStatus.OK);
	}
	
	@GetMapping("/admin/report/{reportId}")
	public ResponseEntity<Report> findReportById(@PathVariable("reportId") Integer reportId) throws TestimonialException
	{
		Report r = tService.findReportById(reportId);
		
		return new ResponseEntity<Report>(r,HttpStatus.OK);
	}
	
	@GetMapping("/customer/feedback")
	public ResponseEntity<List<Feedback>> findAllFeedback()
	{
		List<Feedback> list = tService.findAllFeedbacks();
		
		return new ResponseEntity<List<Feedback>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/admin/report")
	public ResponseEntity<List<Report>> findAllReport()
	{
		List<Report> list = tService.findAllReports();
		
		return new ResponseEntity<List<Report>>(list,HttpStatus.OK);
	}
	

}
