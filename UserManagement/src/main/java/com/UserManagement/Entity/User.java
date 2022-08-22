package com.UserManagement.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int userId;
	
	@Column(name="firstName",nullable = false)
	String firstName;
	
	@Column(name="lastName",nullable = false)
	String lastName;
	
	@Column(name="dob",nullable = false)
	String dob;
	
	@Column(name="dateOfJoining",nullable = false)
	String dateOfJoining;
	
	@Column(name="email",nullable = false)
	String email;
	
	@Column(name="softdelete",nullable = true)
	boolean softDelete=false;
	

}
