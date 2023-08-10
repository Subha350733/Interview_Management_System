package com.example.jobprofileservice.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.jobprofileservice.data.JobEntity;
import com.example.jobprofileservice.data.JobRepository;
import com.example.jobprofileservice.mapper.JobMapper;
import com.example.jobprofileservice.model.JobRestModel;

@Component
public class JobService {
	
	@Autowired
	public JobRepository jobRepository ;
	
	@Autowired
	public JobMapper mapper ;

	public String createJob(JobRestModel jobRestModel) {
		
		JobEntity job = new JobEntity();
		String id = UUID.randomUUID().toString() ;
		
		BeanUtils.copyProperties(jobRestModel, job);		
		job.setJobId(id);
		job.setJobStatus("Open");
		jobRepository.save(job);
		
		return id ;
	}

	public List<JobEntity> getAllJobs() {
		return jobRepository.findAll() ;
	}

	public JobEntity getJobById(String id) {	
		Optional<JobEntity> job = jobRepository.findById(id);		
		return job.get() ;
	}

	public JobEntity updateJob(JobEntity jobEntity) {
		
		if(jobRepository.existsById(jobEntity.getJobId())) {
			jobRepository.save(jobEntity);
		}
		
		return jobEntity ;		
	}

}
