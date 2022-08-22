package com.UserManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UserManagement.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
