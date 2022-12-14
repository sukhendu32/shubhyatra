package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.models.Report;

@Repository
public interface ReportRepo extends JpaRepository<Report, Integer>{

}
