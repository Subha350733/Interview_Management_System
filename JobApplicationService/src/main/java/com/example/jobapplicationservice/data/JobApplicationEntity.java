package com.example.jobapplicationservice.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "JobApplications")
public class JobApplicationEntity {
	
	@Id
	private String jobApplicationId ;
	private String userId ;
	private String jobProfileId ;
	private String status ;

}
