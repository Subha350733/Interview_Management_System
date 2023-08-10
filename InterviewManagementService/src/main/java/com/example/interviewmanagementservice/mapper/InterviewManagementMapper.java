package com.example.interviewmanagementservice.mapper;

import org.springframework.stereotype.Component;

import com.example.interviewmanagementservice.controller.model.CandidateDetails;
import com.example.interviewmanagementservice.rest.model.UserEntity;

@Component
public class InterviewManagementMapper {
	
	public CandidateDetails mapCandidateDetails(UserEntity userEntity) {		
		CandidateDetails candidateDetails = new CandidateDetails();
		candidateDetails.setUserId(userEntity.getUserId());
		candidateDetails.setFirstName(userEntity.getFirstName());
		candidateDetails.setLastName(userEntity.getLastName());
		candidateDetails.setPhNumber(userEntity.getPhNumber());
		candidateDetails.setEmailId(userEntity.getEmailId());
		return candidateDetails ;
	}

}
