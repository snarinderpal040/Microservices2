package com.narinder.socialmedia.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.narinder.socialmedia.dto.UserDTO;
import com.narinder.socialmedia.services.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping(path = "hello")
	public String helloCallToPostsService() {
		return service.hello();
	}
	
	
	@PostMapping("users")
	public ResponseEntity<UserDTO> addUser(@Valid @RequestBody UserDTO userDTO) {
		UserDTO save = service.save(userDTO);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(save.getName())
				.toUri();
		
		return ResponseEntity.created(location).body(save);
	}
	
	@GetMapping("users/{id}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable String name) {
		return new ResponseEntity<UserDTO>(service.findById(name), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "users/{id}")
	public String deleteById(@PathVariable String name) {
		return service.deleteById(name);
	}
	
	@GetMapping(value = "users/posts/{username}")
	public ResponseEntity<UserDTO> getPostsByUsernmae(@PathVariable String username){
		return new ResponseEntity<UserDTO>(service.getPostsByUsername(username), HttpStatus.OK);
	}
	
}
