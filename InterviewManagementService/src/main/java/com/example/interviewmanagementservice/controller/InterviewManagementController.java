package com.example.interviewmanagementservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.interviewmanagementservice.controller.model.AllCandidatesForAJobResponse;
import com.example.interviewmanagementservice.controller.model.InterviewFeedbackForm;
import com.example.interviewmanagementservice.service.InterviewManagementService;


@RequestMapping("/Interview-Management")
@RestController
public class InterviewManagementController {
	
	@Autowired
	private InterviewManagementService interviewManagementService ;
	
	@GetMapping("/jobs")
	public ResponseEntity<AllCandidatesForAJobResponse> getAllCandidates(@RequestParam String jobProfileId) {		
		AllCandidatesForAJobResponse allCandidatesForAJob = interviewManagementService.getAllCandidates(jobProfileId);
		return new ResponseEntity<>(allCandidatesForAJob,HttpStatus.OK) ;		
	}
	
	public String postInterviewFeedback(InterviewFeedbackForm interviewFeedbackForm) {
		
		return "Posted";
	}
	
	public String updateInterviewFeedback(InterviewFeedbackForm interviewFeedbackForm) {
		
		return "Posted";
	}
	
	public String getInterviewFeedback(String interviewFeedbackId) {
		
		return "Posted";
	}
	

}
