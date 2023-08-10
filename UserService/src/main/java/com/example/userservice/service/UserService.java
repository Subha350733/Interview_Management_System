package com.example.userservice.service;

import java.util.List;
import com.example.userservice.data.UserEntity;
import com.example.userservice.rest.model.UserRestModel;

public interface UserService {
	
	public String addNewUser(UserRestModel userRestModel) ;
	public List<UserEntity> getAllUsers();
	public UserEntity getUserById(String id);
	public UserEntity updateUser(UserEntity userEntity);
	

}
