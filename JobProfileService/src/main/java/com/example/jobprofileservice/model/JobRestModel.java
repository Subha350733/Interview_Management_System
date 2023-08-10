package com.example.jobprofileservice.model;

import java.util.List;
import lombok.Data;

@Data
public class JobRestModel {
	
	public String jobTitle ;
	public String jobDesc ;
	public String location ;
	//public String jobStatus ;
	public String jobType ;
	public List<String> jobSkills ;

}
