package com.example.jobapplicationservice.service;

import java.util.List;

import com.example.jobapplicationservice.data.JobApplicationEntity;
import com.example.jobapplicationservice.rest.model.ApplyJobModel;
import com.example.jobapplicationservice.rest.model.UpdateJobModel;

public interface JobApplicationService {

	public String addNewJob(ApplyJobModel applyJobModel);
	public String updateJob(UpdateJobModel updateJobModel);
	public List<JobApplicationEntity> getAllJobsForCandidate(String userId);
	public List<JobApplicationEntity> getAllCandidatesForJob(String jobProfileId);

}
