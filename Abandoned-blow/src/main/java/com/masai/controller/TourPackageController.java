package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.TourPackageException;
import com.masai.models.TourPackage;
import com.masai.services.TourPackageService;

@RestController
public class TourPackageController {
	
	@Autowired
	private TourPackageService tService;
	
	@PostMapping("/TourPackage")
	public TourPackage registerTourPackage(@RequestBody TourPackage tpackage) throws TourPackageException
	{
		return tService.registerTourPackage(tpackage);
	}
	
	@DeleteMapping("/TourPackage/{Id}")
	public TourPackage deleteTourPackage(@PathVariable("Id") Integer Id) throws TourPackageException
	{
		return tService.deleteTourPackageById(Id);
	}
	
	@GetMapping("/TourPackage")
	public List<TourPackage> viewAllTourPackage()
	{
		return tService.viewAllTourPackage();
	}

}
