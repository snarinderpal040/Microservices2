package com.narinder.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.narinder.socialmedia.entities.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	User findByName(String username);
	
}
