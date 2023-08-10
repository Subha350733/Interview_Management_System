package com.example.userservice.rest.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.example.userservice.data.UserEntity;
import com.example.userservice.exception.ErrorDetails;
import com.example.userservice.exception.ResourceNotFoundException;
import com.example.userservice.rest.model.UserRestModel;
import com.example.userservice.service.UserService;


@RequestMapping("/UserService")
@RestController
public class UserServiceController {
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceController.class) ;
	
	@Autowired
	public UserService userService ;
	
	@GetMapping("/Users")
	public ResponseEntity<List<UserEntity>> getAllUsers(){
		List<UserEntity> users = userService.getAllUsers();
		return new ResponseEntity<>(users , HttpStatus.OK);
	}
	
	@GetMapping("/Users/{id}")
	public ResponseEntity<UserEntity> getUser(@PathVariable String id){
		UserEntity user = userService.getUserById(id);
		return new ResponseEntity<>(user , HttpStatus.OK);
	}
	
	@PostMapping("/CreateUser")
	public ResponseEntity<String> createUser(@RequestBody UserRestModel userRestModel) {		
		String id = userService.addNewUser(userRestModel) ;		
		return new ResponseEntity<>(id , HttpStatus.CREATED) ;
	}
	
	@PutMapping("/UpdateUser")
	public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity userEntity) {		
		UserEntity newUserEntity = userService.updateUser(userEntity) ;
		return new ResponseEntity<>(newUserEntity , HttpStatus.OK) ;
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception , WebRequest WebRequest){
		
		ErrorDetails error = new ErrorDetails(
				LocalDateTime.now(),
				exception.getMessage(),
				WebRequest.getDescription(false),
				"USER_NOT_FOUND"
		);
		
		return new ResponseEntity<>(error , HttpStatus.NOT_FOUND);
	}
	

}
