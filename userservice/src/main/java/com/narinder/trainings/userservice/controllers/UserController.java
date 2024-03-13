package com.narinder.trainings.userservice.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.narinder.trainings.userservice.dto.OrderDetails;
import com.narinder.trainings.userservice.dto.UserDetails;
import com.narinder.trainings.userservice.service.User;
import com.narinder.trainings.userservice.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/users")
	public ResponseEntity<List<UserDetails>> getAllUsers(){
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/users/username/{username}")
	public ResponseEntity<UserDetails> getUserByUsername(@PathVariable String username){
		return new ResponseEntity<> (service.findByUsername(username), HttpStatus.OK);
	}
	
	@GetMapping("/users/orders/{username}")
	public ResponseEntity<OrderDetails> getOrdersByUsername(@PathVariable String username){
		return new ResponseEntity<> (service.getOrderByUsername(username), HttpStatus.OK);
	}
	
	@GetMapping("/users/address/{address}")
	public ResponseEntity<List<UserDetails>> getUserByAddress(@PathVariable String address){
		return new ResponseEntity<> (service.findByAddress(address), HttpStatus.OK);
	}
	
	@GetMapping("/users/email/{emailId}")
	public ResponseEntity<UserDetails> getUserByEmailId(@PathVariable String emailId){
		return new ResponseEntity<> (service.findByEmailId(emailId), HttpStatus.OK);
	}
	
	@GetMapping("/users/{uid}")
	public ResponseEntity<UserDetails> getUserById(@PathVariable int uid) {
		return new ResponseEntity<> (service.findById(uid), HttpStatus.OK);
	}
	
	@PostMapping("/saveuser")
	public ResponseEntity<UserDetails> insertUser(@Valid @RequestBody User user) {
		return service.saveUser(user);
	}
	
	@PutMapping("/update/{uid}")
	public ResponseEntity<UserDetails> updateUser(@PathVariable int uid, @RequestBody User user) {
		return new ResponseEntity<> (service.updateUser(uid, user), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("delete/{uid}")
	public ResponseEntity<String> deleteUser(@PathVariable int uid) {
		return new ResponseEntity<> (service.deleteUser(uid), HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/users/{uid}")
	public ResponseEntity<UserDetails> updateUserPartially(@PathVariable int uid, @RequestBody Map<String, Object> map) {
		return new ResponseEntity<> (service.updateUserPartially(uid, map), HttpStatus.ACCEPTED);
	}

}
