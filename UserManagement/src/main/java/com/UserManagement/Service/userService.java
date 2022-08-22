package com.UserManagement.Service;

import java.util.List;

import com.UserManagement.Entity.User;

public interface userService {
	
	public User saveNewUser(User user);
	public User getUser(int userId);
	public List<User> getSortedUsersByDOB();
	public List<User> getSortedUsersByDateOfJoining();
	public List<User> getAllUsers();
	public User updateUser(User user,int userId);
	public User softDeleteUser(int userId);
	public void permanantDeleteUser(int userId);

}
