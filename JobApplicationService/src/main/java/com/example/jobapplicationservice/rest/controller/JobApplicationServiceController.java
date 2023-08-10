package com.example.jobapplicationservice.rest.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.jobapplicationservice.data.JobApplicationEntity;
import com.example.jobapplicationservice.rest.model.ApplyJobModel;
import com.example.jobapplicationservice.rest.model.UpdateJobModel;
import com.example.jobapplicationservice.service.JobApplicationService;


@RequestMapping("/JobApplication")
@RestController
public class JobApplicationServiceController {
	
	
	@Autowired
	public JobApplicationService jobApplicationService ;
	
	
	@PostMapping
	public ResponseEntity<String> applyForJob(@RequestBody ApplyJobModel applyJobModel) {		
		String applicationId = jobApplicationService.addNewJob(applyJobModel) ;		
		return new ResponseEntity<>("Successfully submitted job application with id :: "+applicationId, HttpStatus.CREATED) ;
	}
	
	@GetMapping("/jobs")
	public ResponseEntity<List<JobApplicationEntity>> getAllJobsForCandidate(@RequestParam String candidateId){
		List<JobApplicationEntity> jobApplications = jobApplicationService.getAllJobsForCandidate(candidateId);
		return new ResponseEntity<>(jobApplications, HttpStatus.OK) ;
	}
	
	@GetMapping("/candidates")
	public ResponseEntity<List<JobApplicationEntity>> getAllCandidatesForJob(@RequestParam String jobId){	
		List<JobApplicationEntity> jobApplications = jobApplicationService.getAllCandidatesForJob(jobId);
		return new ResponseEntity<>(jobApplications, HttpStatus.OK) ;
	}
	
	@PutMapping
	public ResponseEntity<String> updateJobApplication(@RequestBody UpdateJobModel updateJobModel) {
		String response = jobApplicationService.updateJob(updateJobModel) ;	
		return new ResponseEntity<>(response, HttpStatus.OK) ;
	}

}
