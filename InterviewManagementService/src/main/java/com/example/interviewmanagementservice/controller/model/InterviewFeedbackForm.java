package com.example.interviewmanagementservice.controller.model;

import lombok.Data;

@Data
public class InterviewFeedbackForm {
	
	public String interviewFeedbackId ;
	public String jobApplicationId ;
	public String interviewStatus ;
	public String javaRating ;
	public String springBootRating ;
	public String angularRating ;
	public String communicationRating ;
	public String leadershipRating ;

}
