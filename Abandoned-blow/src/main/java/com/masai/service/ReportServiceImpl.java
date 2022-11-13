package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.ReportException;
import com.masai.model.CurrentUserLoginSession;
import com.masai.model.Report;
import com.masai.repository.ReportRepository;
import com.masai.repository.SessionRepository;
import com.masai.repository.UserRepository;

@Service
public class ReportServiceImpl implements ReportService{
	
	@Autowired
	SessionRepository sessionRepo;
	
	@Autowired
	ReportRepository reportRepo;
	
	@Autowired
	UserRepository userRepo;

	@Override
	public Report addReport(Report report, String authKey) throws ReportException {
		Optional<CurrentUserLoginSession> curUser = sessionRepo.findByAuthKey(authKey);
		String userType = userRepo.findById(curUser.get().getUserId()).get().getUserType();
		if(userType.equalsIgnoreCase("user")) {
			throw new ReportException("Unauthorized Request...");
		}
		else {
			return reportRepo.save(report);
		}
	}

	@Override
	public Report deleteReport(Integer reportId, String authKey) throws ReportException {
		Optional<CurrentUserLoginSession> curUser = sessionRepo.findByAuthKey(authKey);
		String userType = userRepo.findById(curUser.get().getUserId()).get().getUserType();
		if(userType.equalsIgnoreCase("user")) {
			throw new ReportException("Unauthorized Request...");
		}
		Optional<Report> reportOpt =  reportRepo.findById(reportId);
		if(!reportOpt.isPresent()) {
			throw new ReportException("Report not exist...");
		}
		reportRepo.deleteById(reportId);
		return reportOpt.get();
	}
	

	@Override
	public List<Report> viewAllReports(String authKey) throws ReportException {
		Optional<CurrentUserLoginSession> curUser = sessionRepo.findByAuthKey(authKey);
		String userType = userRepo.findById(curUser.get().getUserId()).get().getUserType();
		if(userType.equalsIgnoreCase("user")) {
			throw new ReportException("Unauthorized Request...");
		}
		else {
			return reportRepo.findAll();
		}
	
	}

}
