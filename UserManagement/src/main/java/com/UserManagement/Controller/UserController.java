package com.UserManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UserManagement.Entity.User;
import com.UserManagement.Service.userService;

@RestController
@RequestMapping(value = "/UserManagement")
public class UserController {
	@Autowired
	userService userService;
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addnewUser(@RequestBody User user) {
		User savedUser = this.userService.saveNewUser(user);
		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/getUser/{userId}")
	public ResponseEntity<User> getUser(@PathVariable(name="userId") int userId){
		User FetchedUser=this.userService.getUser(userId);
		return new ResponseEntity<User>(FetchedUser, HttpStatus.OK);
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers(){
		List userList=this.userService.getAllUsers();
		return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
	}
	
	@GetMapping("/getAllUsersSortedOnDOB")
	public ResponseEntity<List<User>> getAllSortedUsersbasedOnDOB(){
		List<User> sortedOnDOBuserList = this.userService.getSortedUsersByDOB();
		return new ResponseEntity<List<User>>(sortedOnDOBuserList,HttpStatus.OK);
	}
	
	@GetMapping("/getAllUsersSortedDateOfJoining")
	public ResponseEntity<List<User>> getAllUsersSortedDateOfJoining(){
		List<User> sortedOndateofjoininguserList = this.userService.getSortedUsersByDateOfJoining();
		return new ResponseEntity<List<User>>(sortedOndateofjoininguserList,HttpStatus.OK);
	}
	
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable int userId){
		User updatedUser=this.userService.updateUser(user,userId);
		return new ResponseEntity<User>(updatedUser, HttpStatus.CREATED);
	}
	
	@PutMapping("/softDeleteUser/{userId}")
	public ResponseEntity<User> softDeleteUser(@PathVariable(name="userId") int userId){
		User softDeletedUser=this.userService.softDeleteUser(userId);
		return new ResponseEntity<User>(softDeletedUser, HttpStatus.OK);
	}
	
	@DeleteMapping("/hardDeleteUser/{userId}")
	public ResponseEntity hardDeleteUser(@PathVariable(name="userId") int userId){
		this.userService.permanantDeleteUser(userId);
		return new ResponseEntity(HttpStatus.OK);
		
	}
	
	

}
