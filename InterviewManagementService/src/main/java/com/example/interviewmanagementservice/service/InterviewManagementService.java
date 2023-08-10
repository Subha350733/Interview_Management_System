package com.example.interviewmanagementservice.service;

import com.example.interviewmanagementservice.controller.model.AllCandidatesForAJobResponse;

public interface InterviewManagementService {
	
	public AllCandidatesForAJobResponse getAllCandidates(String jobProfileId) ;

}
