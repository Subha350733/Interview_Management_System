package com.example.jobprofileservice.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.example.jobprofileservice.data.JobEntity;
import com.example.jobprofileservice.model.JobRestModel;

@Component
public class JobMapper {

	public JobRestModel mapJobData(JobEntity jobEntity) {		
		JobRestModel job = new JobRestModel();
		BeanUtils.copyProperties(jobEntity, job);
		return job ;		
	}
	
	public List<JobRestModel> mapAllJobs(List<JobEntity> jobs){
		
		List<JobRestModel> jobList = new ArrayList<JobRestModel>();
		
		for(JobEntity jobEntity : jobs) {
			jobList.add(mapJobData(jobEntity));
		}
		
		return jobList ;
	}
	
	
}
