package com.example.userservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.userservice.data.UserEntity;
import com.example.userservice.data.UserRepository;
import com.example.userservice.exception.ResourceNotFoundException;
import com.example.userservice.rest.model.UserRestModel;

@Component
public class UserServiceImpl implements UserService {
	
	@Autowired
	public UserRepository userRepository ;
	
	@Override
	public String addNewUser(UserRestModel userRestModel) {
		
		String id = UUID.randomUUID().toString();
		
		UserEntity user = new UserEntity();
		BeanUtils.copyProperties(userRestModel, user);
		user.setUserId(id);
		
		userRepository.save(user);
		
		return id ;
	}
	
	@Override
	public List<UserEntity> getAllUsers() {
		List<UserEntity> userList = new ArrayList<>();
		userList = userRepository.findAll();
		return userList ;
	}

	@Override
	public UserEntity getUserById(String id) {
		
		UserEntity user = userRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("User","UserId",id)
		);
		
		return user;
	}

	@Override
	public UserEntity updateUser(UserEntity userEntity) {
		
		if(userRepository.existsById(userEntity.getUserId())) {
			userRepository.save(userEntity);
		}else {
			throw new ResourceNotFoundException("User","UserId",userEntity.getUserId());
		}
		
		return userEntity;
	}

}
