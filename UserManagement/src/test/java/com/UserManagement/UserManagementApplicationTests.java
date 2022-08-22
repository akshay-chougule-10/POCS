package com.UserManagement;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.UserManagement.Entity.User;
import com.UserManagement.Repository.UserRepo;
import com.UserManagement.Service.UserServiceImpl;

import lombok.var;


@SpringBootTest
@RunWith(SpringRunner.class)
class UserManagementApplicationTests {
	
	
	
	@InjectMocks
	UserServiceImpl userImpl;
	
	@Mock
	UserRepo userRepo;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void testsaveuser() {
		User user=new User();
		user.setUserId(102);
		user.setFirstName("akshay");
		user.setLastName("lastname");
		user.setDateOfJoining("2022/03/01");
		user.setDob("1998/10/04");
		user.setEmail("akshaychougule@gmail.com");
		user.setSoftDelete(false);
		
		when(userRepo.save(user)).thenReturn(user);
		
		assertEquals(user, userImpl.saveNewUser(user));
	}
	
	@Test
	public void testGetUser() {
		User user=new User(102,"akshay","chougule","1998/10/04","2022/01/12","akshaychougule@gmail.com",false);
		
		when(userRepo.findById(102)).thenReturn(Optional.of(user));
		assertEquals(user, userImpl.getUser(102));
		
	}
	
	@Test
	public void testGetUsers() {
		User user=new User(101,"akshay","chougule","1998/10/04","2022/01/12","akshaychougule@gmail.com",false);
		User user1=new User(101,"Rahul","Aher","1998/10/04","2022/01/12","RahulAher@gmail.com",false);
		
		List<User> ulist=new ArrayList();
		ulist.add(user);
		ulist.add(user1);
		
		when(userRepo.findAll()).thenReturn(ulist);
		assertEquals(ulist, userImpl.getAllUsers());
		
	}
	
	@Test
	public void testDeleteUser() {
		doNothing().when(userRepo).deleteById(101);
		userImpl.permanantDeleteUser(101);
		verify(userRepo,times(1)).deleteById(101);
		
		
	}
	
	@Test
	public void testUpdateUser() {
		User user=new User(101,"akshay","chougule","1998/10/04","2022/01/12","akshaychougule@gmail.com",false);
		when(userRepo.save(user)).thenReturn(user);
		when(userRepo.findById(101)).thenReturn(Optional.of(user));
		assertEquals(user, userImpl.updateUser(user, 101));
		
		
	}

	
	
	
	
	
	
	

}
