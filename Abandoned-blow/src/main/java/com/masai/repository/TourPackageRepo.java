package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.models.TourPackage;

@Repository
public interface TourPackageRepo extends JpaRepository<TourPackage, Integer>{

	public TourPackage findByTourPackageName(String name);
}
