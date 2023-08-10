package com.example.interviewmanagementservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.interviewmanagementservice.rest.model.UserEntity;


@FeignClient(url = "http://localhost:8082/user-service" , value = "user-service")
public interface FeignAPIClient {
	
	@GetMapping("/UserService/Users/{id}")
	public UserEntity getUser(@PathVariable String id);

}
