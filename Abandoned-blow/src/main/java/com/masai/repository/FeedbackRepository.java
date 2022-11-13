package com.masai.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.exception.FeedbackException;
import com.masai.model.Feedback;
import com.masai.model.User;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
	
	public List<Feedback> findByFeedbackId(Integer feedbackId);
	
	public List<Feedback> findByUser(User user);
	
	public List<Feedback> findByRating(Double rating);
	
	public List<Feedback> findByDate(LocalDate date);
	
	@Query(value = "select f from Feedback f")
	public List<Feedback> getAllFeedbacks() throws FeedbackException;

}
