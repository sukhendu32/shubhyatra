package com.masai.services;

import java.util.List;

import com.masai.exceptions.TourPackageException;
import com.masai.models.TourPackage;

public interface TourPackageService {

    public TourPackage registerTourPackage(TourPackage tourPackage) throws TourPackageException;
	
	public TourPackage deleteTourPackageById(Integer tourPackageId) throws TourPackageException;
	
	public TourPackage findTourPackageById(Integer tourPackageId) throws TourPackageException;
	
	public TourPackage updateTourPackage(TourPackage tourPackage) throws TourPackageException;
	
	public List<TourPackage> viewAllTourPackage() throws TourPackageException;
}
