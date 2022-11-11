package com.masai.services;

import java.util.List;

import com.masai.models.TourPackage;

public interface TourPackageService {

    public TourPackage registerTourPackage(TourPackage tourPackage);
	
	public TourPackage deleteTourPackageById(Integer tourPackageId);
	
	public List<TourPackage> viewAllTourPackage();
}
