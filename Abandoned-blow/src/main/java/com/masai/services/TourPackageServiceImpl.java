package com.masai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.TourPackageException;
import com.masai.models.TourPackage;
import com.masai.repository.TourPackageRepo;

@Service
public class TourPackageServiceImpl implements TourPackageService{

	@Autowired
	private TourPackageRepo tRepo;
	
	@Override
	public TourPackage registerTourPackage(TourPackage tourPackage) throws TourPackageException{
		
		TourPackage t = tRepo.save(tourPackage);
		
		if(t!=null)
		{
			return t;
		}
		else
		{
			return null;
		}
	}

	@Override
	public TourPackage deleteTourPackageById(Integer tourPackageId) throws TourPackageException{
		
		Optional<TourPackage> opt = tRepo.findById(tourPackageId);
		
		if(opt.isPresent())
		{
			tRepo.delete(opt.get());
			
			return opt.get();
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<TourPackage> viewAllTourPackage() {
		
		List<TourPackage> list = tRepo.findAll();
		
		if(list.size()>0)
		{
			return list;
		}
		else
		{
			return null;
		}
	}

}
