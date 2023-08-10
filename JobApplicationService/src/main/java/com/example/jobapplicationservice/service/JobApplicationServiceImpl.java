package com.example.jobapplicationservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.jobapplicationservice.data.JobApplicationEntity;
import com.example.jobapplicationservice.data.JobApplicationRepository;
import com.example.jobapplicationservice.exception.ResourceNotFoundException;
import com.example.jobapplicationservice.rest.model.ApplyJobModel;
import com.example.jobapplicationservice.rest.model.UpdateJobModel;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {
	
	@Autowired
	public JobApplicationRepository jobApplicationRepository ;
	

	@Override
	public String addNewJob(ApplyJobModel applyJobModel) {
		
		JobApplicationEntity jobApplicationEntity = new JobApplicationEntity();
		
		String id = UUID.randomUUID().toString();
		jobApplicationEntity.setJobApplicationId(id);
		jobApplicationEntity.setUserId(applyJobModel.getUserId());
		jobApplicationEntity.setJobProfileId(applyJobModel.getJobProfileId());
		jobApplicationEntity.setStatus("Applied");
		
		jobApplicationRepository.save(jobApplicationEntity);
		
		return id;
	}


	@Override
	public String updateJob(UpdateJobModel updateJobModel) {

		JobApplicationEntity jobApplicationEntity = jobApplicationRepository.findById(updateJobModel.getJobApplicationId())
				.orElseThrow(
					() -> new ResourceNotFoundException("Application" , "Id" , updateJobModel.getJobApplicationId())	
		);
		
		jobApplicationEntity.setStatus(updateJobModel.getApplicationStatus());
		jobApplicationRepository.save(jobApplicationEntity);
		
		return "Application Updated Successfully";
	}
	
	@Override
	public List<JobApplicationEntity> getAllJobsForCandidate(String userId) {

		List<JobApplicationEntity> jobApplications = jobApplicationRepository.findByuserId(userId).orElseThrow(
				() -> new ResourceNotFoundException("Application" , "Id" , userId)
		);
		
		return jobApplications ;
	}
	
	@Override
	public List<JobApplicationEntity> getAllCandidatesForJob(String jobProfileId) {

		List<JobApplicationEntity> jobApplications = jobApplicationRepository.findByjobProfileId(jobProfileId).orElseThrow(
				() -> new ResourceNotFoundException("Application" , "Id" , jobProfileId)
		);
		
		return jobApplications ;
	}

}
