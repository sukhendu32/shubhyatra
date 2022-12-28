package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.TourPackageException;
import com.masai.models.TourPackage;
import com.masai.services.TourPackageService;

@RestController
@RequestMapping("/travel")
public class TourPackageController {
	
	@Autowired
	private TourPackageService tService;
	
	@PostMapping("/admin/tourPackage")
	public ResponseEntity<TourPackage> registerTourPackage(@Valid @RequestBody TourPackage tpackage) throws TourPackageException
	{
		TourPackage t = tService.registerTourPackage(tpackage);
		return new ResponseEntity<TourPackage>(t, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/admin/tourPackage/{tourPackageId}")
	public ResponseEntity<TourPackage> deleteTourPackage(@PathVariable("tourPackageId") Integer Id) throws TourPackageException
	{
		TourPackage t = tService.deleteTourPackageById(Id);
		
		return new ResponseEntity<TourPackage>(t, HttpStatus.OK);
	}
	
	@GetMapping("/tourPackage")
	public ResponseEntity<List<TourPackage>> viewAllTourPackage() throws TourPackageException
	{
		List<TourPackage> list = tService.viewAllTourPackage(); 
		
		return new ResponseEntity<List<TourPackage>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/tourPackage/{tourPackageId}")
	public ResponseEntity<TourPackage> findTourPackage(@PathVariable("tourPackageId") Integer Id) throws TourPackageException
	{
		TourPackage t = tService.findTourPackageById(Id);
		
		return new ResponseEntity<TourPackage>(t, HttpStatus.OK);
	}
	
	@PutMapping("/admin/tourPackage")
	public ResponseEntity<TourPackage> udateTourPackageDetails(@Valid @RequestBody TourPackage tourPackage) throws TourPackageException
	{
		TourPackage t = tService.updateTourPackage(tourPackage);
		
		return new ResponseEntity<TourPackage>(t, HttpStatus.OK);
	}

}
