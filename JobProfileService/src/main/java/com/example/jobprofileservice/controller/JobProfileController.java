package com.example.jobprofileservice.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobprofileservice.data.JobEntity;
import com.example.jobprofileservice.model.JobRestModel;
import com.example.jobprofileservice.service.JobService;

@RequestMapping("/jobs")
@RestController
public class JobProfileController {
	
	@Autowired
	public JobService jobService ;
	
	@GetMapping("/{id}")
	public ResponseEntity<JobEntity> getJob(@PathVariable String id) {		
		JobEntity jobDetail = jobService.getJobById(id);
		return ResponseEntity.ok()
				.header("Custom_header" , "Subha")
				.body(jobDetail);		
	}
	
	@GetMapping
	public ResponseEntity<List<JobEntity>> getAllJobs() {
		List<JobEntity> jobs = jobService.getAllJobs();
		return ResponseEntity.ok(jobs);
	}
	
	@PostMapping
	public ResponseEntity<String> createJob(@RequestBody JobRestModel jobRestModel) {
		String id = jobService.createJob(jobRestModel);
		return new ResponseEntity<>(id, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<JobEntity> updateJob(@RequestBody JobEntity jobEntity) {
		JobEntity job = jobService.updateJob(jobEntity);
		return new ResponseEntity<>(job, HttpStatus.OK);
	}
	

}
