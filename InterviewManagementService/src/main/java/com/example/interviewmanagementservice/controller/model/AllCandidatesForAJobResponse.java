package com.example.interviewmanagementservice.controller.model;

import java.util.List;

import com.example.interviewmanagementservice.rest.model.JobRestModel;
import com.example.interviewmanagementservice.rest.model.UserEntity;

import lombok.Data;

@Data
public class AllCandidatesForAJobResponse {
	
	private JobRestModel jobProfileDetails ;
	private List<CandidateDetails> appliedCandidates ;
	private List<CandidateDetails> selectedCandidates ;
	private List<CandidateDetails> notselectedCandidates ;

}
