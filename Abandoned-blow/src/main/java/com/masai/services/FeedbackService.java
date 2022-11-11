package com.masai.services;

import java.util.List;

import com.masai.models.Feedback;


public interface FeedbackService {
	
    public Feedback registerFeedback(Feedback feedback);
	
	public Feedback deleteFeedbackById(Integer feedbackId);
	
	public List<Feedback> viewAllFeedback();

}
