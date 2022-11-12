package com.masai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.CustomerException;
import com.masai.exceptions.TestimonialException;
import com.masai.models.Customer;
import com.masai.models.Feedback;
import com.masai.models.Report;
import com.masai.repository.CustomerRepo;
import com.masai.repository.FeedbackRepo;
import com.masai.repository.ReportRepo;

@Service
public class TestimonialServiceImpl implements TestimonialService{

	@Autowired
	private CustomerRepo cRepo;
	
	@Autowired
	private FeedbackRepo fRepo;
	
	@Autowired
	private ReportRepo rRepo;
	
	@Override
	public Feedback customerFeedback(Integer customerId, Feedback feedback) throws CustomerException 
	{
		Optional<Customer> opt = cRepo.findById(customerId);
		
		if(opt.isPresent())
		{
			Customer c = opt.get();
			
			Feedback f = fRepo.save(feedback);
			
			c.setFeedback(f);
			
			cRepo.save(c);
			
			return f;
		}
		else
		{
			throw new CustomerException("Customer not found with Id "+customerId);
		}
		
		
	}

	@Override
	public Report adminReport(Report report){
		
		Report r = rRepo.save(report);
		
		return r;
		
	}

	@Override
	public Report findReportById(Integer reportId) throws TestimonialException {
		
		Optional<Report> opt =  rRepo.findById(reportId);
		
		if(opt.isPresent())
		{
			return opt.get();
		}
		else
		{
			throw new TestimonialException("Report not found by given Id "+reportId);
		}
		
	}

	@Override
	public Feedback findFeedbackById(Integer customerId) throws CustomerException {
		
		Optional<Customer> opt =  cRepo.findById(customerId);
		
		if(opt.isPresent())
		{
			Customer c = opt.get();
			
			return c.getFeedback();
		}
		else
		{
			throw new CustomerException("Customer not found by given Id"+ customerId);
		}
	}

	@Override
	public List<Feedback> findAllFeedbacks() {
		
		return fRepo.findAll();
	}

	@Override
	public List<Report> findAllReports() {
		
		return rRepo.findAll();
	}

}
