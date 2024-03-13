package com.narinder.trainings.userservice.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.narinder.trainings.userservice.service.User;

@Repository
public interface UserRespository extends CrudRepository<User, Integer> {
	
	public Optional<User> findByUsername(String username);
	
	public List<User> findByAddress(String Address);
	
	public Optional<User> findByEmailId(String emailId);
	
	@Query(value = "select * from user where emailid = : emailId", nativeQuery = true)
	public Optional<User> getByEmailId(String emailId);

}
