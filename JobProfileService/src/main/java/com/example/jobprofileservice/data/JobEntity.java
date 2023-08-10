package com.example.jobprofileservice.data;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "jobs")
public class JobEntity {
	
	@Id
	public String jobId ;
	
	public String jobTitle ;
	public String jobDesc ;
	public String location ;
	public String jobStatus ;
	public String jobType ;
	public List<String> jobSkills ;

}
