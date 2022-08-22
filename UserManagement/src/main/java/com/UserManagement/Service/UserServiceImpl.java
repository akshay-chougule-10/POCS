package com.UserManagement.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserManagement.Entity.User;
import com.UserManagement.Repository.UserRepo;

@Service
public class UserServiceImpl implements userService{
	
	@Autowired
	UserRepo userRepo;
	
	
	public UserServiceImpl(UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}
	
	

	public void setUserRepo(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public User saveNewUser(User user) {
		User savedUser = this.userRepo.save(user);
		return savedUser;
	}

	@Override
	public User getUser(int userId) {
		User FetchedUser=this.userRepo.findById(userId).orElse(null);
		return FetchedUser;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> userList=new ArrayList<>();
		userList=this.userRepo.findAll();
		return userList;
	}

	@Override
	public User updateUser(User user,int userId) {
		User UserTobeUpdated=this.userRepo.findById(userId).orElse(null);
		UserTobeUpdated.setFirstName(user.getFirstName());
		UserTobeUpdated.setLastName(user.getLastName());
		UserTobeUpdated.setEmail(user.getEmail());
		UserTobeUpdated.setDob(user.getDob());
		UserTobeUpdated.setDateOfJoining(user.getDateOfJoining());
		return UserTobeUpdated;
	}
	

	@Override
	public User softDeleteUser(int userId) {
		User userTobeSoftDelete = this.userRepo.findById(userId).orElse(null);
		userTobeSoftDelete.setSoftDelete(true);
		this.userRepo.save(userTobeSoftDelete);
		return userTobeSoftDelete;
	}

	@Override
	public void permanantDeleteUser(int userId) {
		this.userRepo.deleteById(userId);
	}

	@Override
	public List<User> getSortedUsersByDOB() {
		List<User> userList=this.userRepo.findAll();
		Collections.sort(userList,new SortOnThebasisOfDOB());
		return userList;
	}

	@Override
	public List<User> getSortedUsersByDateOfJoining() {
		List<User> userList=this.userRepo.findAll();
		Collections.sort(userList,new SortOnThebasisOfJoiningDate());
		return userList;
	}
	
	

}

class SortOnThebasisOfDOB implements Comparator<User>{

	@Override
	public int compare(User o1, User o2) {
		
		return o1.getDob().compareTo(o2.getDob());
	}
	
}

class SortOnThebasisOfJoiningDate implements Comparator<User>{

	@Override
	public int compare(User o1, User o2) {
		
		return o1.getDateOfJoining().compareTo(o2.getDateOfJoining());
	}
	
}
