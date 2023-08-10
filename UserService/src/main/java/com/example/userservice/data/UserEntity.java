package com.example.userservice.data;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Users")
public class UserEntity implements Serializable{
	
	private static final long serialVersionUID = 7718561812155690549L;
	
	@Id
	@Column(unique = true)
	public String userId ;
	
	private String firstName ;
	private String lastName ;
	private String emailId ;
	private String phNumber ;
	private String userName ;
	private String password ;
	

}
