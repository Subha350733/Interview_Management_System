package com.example.interviewmanagementservice.rest.model;

import java.util.List;
import lombok.Data;

@Data
public class JobRestModel {
	
	public String jobId ;
	public String jobTitle ;
	public String jobDesc ;
	public String location ;
	public String jobType ;
	public List<String> jobSkills ;

}
