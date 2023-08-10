package com.example.interviewmanagementservice.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.interviewmanagementservice.controller.model.AllCandidatesForAJobResponse;
import com.example.interviewmanagementservice.controller.model.CandidateDetails;
import com.example.interviewmanagementservice.mapper.InterviewManagementMapper;
import com.example.interviewmanagementservice.rest.model.JobApplicationEntity;
import com.example.interviewmanagementservice.rest.model.JobRestModel;
import com.example.interviewmanagementservice.rest.model.UserEntity;

@Service
public class InterviewManagementServiceImpl implements InterviewManagementService {
	
	private static final Logger log = LoggerFactory.getLogger(InterviewManagementServiceImpl.class) ;
	
	@Autowired
	public RestTemplate restTemplate ;
	
	@Autowired
	public WebClient webClient ;
	
	@Autowired
	public FeignAPIClient apiClient ;
	
	@Autowired
	public InterviewManagementMapper mapper ;
	
	
	
	public AllCandidatesForAJobResponse getAllCandidates(String jobProfileId) {
		
		AllCandidatesForAJobResponse allCandidatesForAJob = new AllCandidatesForAJobResponse();
		
		
		// REST API call using WebClient to job-profile-service
		
		JobRestModel jobDetails = webClient.get()
				.uri("http://localhost:8082/job-profile-service/jobs/"+jobProfileId)
				.retrieve()
				.bodyToMono(JobRestModel.class)
				.block();
		
		log.info("REST API Call using webClient is Successful");

		allCandidatesForAJob.setJobProfileDetails(jobDetails);

		
		// REST API call using RestTemplate to job-application-service
		
		ResponseEntity<List<JobApplicationEntity>> jobApplicationEntity = restTemplate.exchange("http://localhost:8082/job-application-service/JobApplication/candidates?jobId="+jobProfileId, 
																					HttpMethod.GET, 
																					null, 
																					new ParameterizedTypeReference<List<JobApplicationEntity>>(){});
		
		log.info("REST API Call using REST Template is Successful");
		
		List<JobApplicationEntity> jobApplications = jobApplicationEntity.getBody();		
		List<CandidateDetails> appliedCandidateList = new ArrayList<>();
		List<CandidateDetails> selectedCandidateList = new ArrayList<>();
		List<CandidateDetails> notselectedCandidateList = new ArrayList<>();

		for(JobApplicationEntity application : jobApplications) {
			
			String userId = application.getUserId() ;
			
			// REST call using Rest Template to user-service
			
			/*
			ResponseEntity<UserEntity> userDetails = restTemplate.getForEntity("http://localhost:8082/user-service/UserService/Users/"+userId, 
					UserEntity.class);
			*/
			
			// REST API call using FeignClient to user-service
			
			UserEntity userDetails = apiClient.getUser(userId) ;
			
			log.info("REST API Call using FeignClient is Successful");
			
			CandidateDetails candidateDetails = mapper.mapCandidateDetails(userDetails);
			
			if("Selected".equals(application.getStatus())) {
				selectedCandidateList.add(candidateDetails);
			}else if("NotSelected".equals(application.getStatus())) {
				notselectedCandidateList.add(candidateDetails);
			}else {
				appliedCandidateList.add(candidateDetails);
			}
	
		}
		
		allCandidatesForAJob.setAppliedCandidates(appliedCandidateList);
		allCandidatesForAJob.setSelectedCandidates(selectedCandidateList);
		allCandidatesForAJob.setNotselectedCandidates(notselectedCandidateList);
		
		
		return allCandidatesForAJob ;
	}

}
