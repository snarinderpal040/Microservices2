package com.narinder.trainings.userservice.service;

import java.lang.reflect.Field;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.narinder.trainings.userservice.dto.OrderDetails;
import com.narinder.trainings.userservice.dto.UserDetails;
import com.narinder.trainings.userservice.exceptions.UserException;
import com.narinder.trainings.userservice.repositories.UserRespository;

@Service
public class UserService {

	@Autowired
	private UserRespository repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${orderservice.url}")
	private String orderServiceUrl;
	
	public OrderDetails getOrderByUsername(String username){
		User existingUser = repo.findByUsername(username)
				.orElseThrow(() -> new UserException("No such user with username : " + username));
		
		@SuppressWarnings("unchecked")
		OrderDetails userDto = new OrderDetails(existingUser,
				restTemplate.getForObject(orderServiceUrl + "orders/username/" + username, List.class));
		
		return userDto;
	}

	public List<UserDetails> findAll() {
		List<User> users = (List<User>) repo.findAll();
		List<UserDetails> userDetails = new ArrayList<>();
		for(User user : users) {
			userDetails.add(new UserDetails(user));
		}
		
		return userDetails;
	}

	public UserDetails findById(int id) {
		User user = repo.findById(id).orElseThrow(() -> new UserException("No such user is present in the system"));
		UserDetails ud = new UserDetails(user);
		return ud;
	}

	public ResponseEntity<UserDetails> saveUser(User user) {
		repo.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getUserId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	public String deleteUser(int id) {
		User existinguser = repo.findById(id)
				.orElseThrow(() -> new UserException("No such user"));
		
		repo.delete(existinguser);
		return "User Deleted";
	}

	public UserDetails updateUser(int id, User user) {
		User existingUser = repo.findById(id).orElseThrow(() -> new UserException("No such user Exists in the system"));

		existingUser.setUsername(user.getUsername() != null ? user.getUsername() : existingUser.getUsername());
		existingUser.setAddress(user.getAddress() != null ? user.getAddress() : existingUser.getAddress());
		existingUser.setEmailId(user.getEmailId() != null ? user.getEmailId() : existingUser.getEmailId());
		existingUser.setContact(user.getContact() != null ? user.getContact() : existingUser.getContact());

		User save = repo.save(existingUser);
		UserDetails ud = new UserDetails(save);

		return ud;
	}

	public UserDetails updateUserPartially(int id, Map<String, Object> map) {

		User existingUser = repo.findById(id).orElseThrow(() -> new UserException("No such user"));

		for (String key : map.keySet()) {
			Field field = ReflectionUtils.findField(User.class, key);
			field.setAccessible(true);
			ReflectionUtils.setField(field, existingUser, map.get(key));
		}

		User save = repo.save(existingUser);
		UserDetails ud = new UserDetails(save);
		return ud;
	}

	public UserDetails findByUsername(String username) {
		User user = repo.findByUsername(username)
				.orElseThrow(() -> new UserException("No such user with username : " + username));
		
		UserDetails ud = new UserDetails(user);
		return ud;
	}
	
	public List<UserDetails> findByAddress(String address){
		List<User> users = repo.findByAddress(address);
		if(users.size() == 0) 
			throw new UserException("No user/users with address : "  + address);
		List<UserDetails> udList = new ArrayList<>();
		for(User user : users) 
			udList.add(new UserDetails(user));
		return udList;
	}
	
	public UserDetails findByEmailId(String emailId){
		User user = repo.findByEmailId(emailId)
				.orElseThrow(() -> new UserException("No user found with emailId : " + emailId));
		UserDetails ud = new UserDetails(user);
		return ud;
	}
	
	public UserDetails getByEmailId(String emailId){
		User user = repo.getByEmailId(emailId)
				.orElseThrow(() -> new UserException("No user found with emailId : " + emailId));
		UserDetails ud = new UserDetails(user);
		return ud;
	}

}
