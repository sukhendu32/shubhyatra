package com.masai.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer feedbackId;
	
	private String feedback;
	
	private LocalDate feedbackDate;
	
	
	public Feedback() {
		// TODO Auto-generated constructor stub
	}


	public Feedback(Integer feedbackId, String feedback, LocalDate feedbackDate) {
		super();
		this.feedbackId = feedbackId;
		this.feedback = feedback;
		this.feedbackDate = feedbackDate;
	}


	public Integer getFeedbackId() {
		return feedbackId;
	}


	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}


	public String getFeedback() {
		return feedback;
	}


	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}


	public LocalDate getFeedbackDate() {
		return feedbackDate;
	}


	public void setFeedbackDate(LocalDate feedbackDate) {
		this.feedbackDate = feedbackDate;
	}


	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", feedback=" + feedback + ", feedbackDate=" + feedbackDate + "]";
	}
	
	
	


}
