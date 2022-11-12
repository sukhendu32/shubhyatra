package com.masai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.TourPackageException;
import com.masai.models.TourPackage;
import com.masai.repository.TourPackageRepo;

@Service
public class TourPackageServiceImpl implements TourPackageService{

	@Autowired
	private TourPackageRepo tRepo;
	
	@Override
	public TourPackage registerTourPackage(TourPackage tourPackage) throws TourPackageException {
		
		TourPackage t = tRepo.save(tourPackage);
		
		if(t!=null)
		{
			return t;
		}
		else
		{
			throw new TourPackageException("TourPackage not registered");
		}
	}

	@Override
	public TourPackage deleteTourPackageById(Integer tourPackageId) throws TourPackageException {
		
		Optional<TourPackage> opt = tRepo.findById(tourPackageId);
		
		if(opt.isPresent())
		{
			tRepo.delete(opt.get());
			
			return opt.get();
		}
		else
		{
			throw new TourPackageException("TourPackage does not with Id "+tourPackageId);
		}
	}

	@Override
	public List<TourPackage> viewAllTourPackage() throws TourPackageException {
		
		List<TourPackage> list = tRepo.findAll();
		
		if(list.size()>0)
		{
			return list;
		}
		else
		{
			throw new TourPackageException("TourPackage not available");
		}
	}

	@Override
	public TourPackage updateTourPackage(TourPackage tourPackage) throws TourPackageException {
		
		Optional<TourPackage> opt = tRepo.findById(tourPackage.getTourPackageId());
		
		if(opt.isPresent())
		{
			tRepo.save(tourPackage);
			
			return tourPackage;
		}
		else
		{
			throw new TourPackageException("TourPackage not found by given details");
		}
	}
	
	@Override
	public TourPackage findTourPackageById(Integer tourPackageId) throws TourPackageException {
		
		Optional<TourPackage> opt = tRepo.findById(tourPackageId);
		
		if(opt.isPresent())
		{
			return opt.get();
		}
		else
		{
			throw new TourPackageException("TourPackage does not with Id "+tourPackageId);
		}
	}

	

}
