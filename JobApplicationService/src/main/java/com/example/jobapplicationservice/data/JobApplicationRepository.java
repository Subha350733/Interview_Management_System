package com.example.jobapplicationservice.data;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobApplicationRepository extends JpaRepository<JobApplicationEntity, String> {
	
	public Optional<List<JobApplicationEntity>> findByuserId(String userId);
	public Optional<List<JobApplicationEntity>> findByjobProfileId(String jobProfileId);

}
