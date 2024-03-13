package com.narinder.socialmedia.services;

import java.util.List;

import com.narinder.socialmedia.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.narinder.socialmedia.configurations.Config;
import com.narinder.socialmedia.dto.PostDTO;
import com.narinder.socialmedia.dto.UserDTO;
import com.narinder.socialmedia.exceptions.UserNotFoundException;
import com.narinder.socialmedia.repository.UserRepository;

import io.github.resilience4j.retry.annotation.Retry;

@Service
public class UserService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	UserRepository repo;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private Config config;
	
	public UserDTO userToUserDto(User user) {
		UserDTO uDto = new UserDTO();
		uDto.setBirthdate(user.getBirthdate());
		uDto.setName(user.getName());
		return uDto;
	}
	
	public User userDtoToUser(UserDTO userDTO) {
		return new User(userDTO.getName(), userDTO.getBirthdate());
	}
	
	
	public UserDTO getPostsByUsername(String username) {
		User user = repo.findByName(username);
		UserDTO userDTO = userToUserDto(user);
		
		@SuppressWarnings("unchecked")
		List<PostDTO> posts = restTemplate.getForObject(config.getUrl() + "/posts/" + username, List.class);
		userDTO.setPost(posts);
		
		return userDTO;
	}

	public UserDTO save(UserDTO userDTO) {
		User user = userDtoToUser(userDTO);
		User savedUser = repo.save(user);
		UserDTO userDTO2 = userToUserDto(savedUser);
		return userDTO2;
	}

	public UserDTO findById(String name) {
		User user = repo.findById(name).orElseThrow(() -> new UserNotFoundException("User not found with name : " + name));
		return userToUserDto(user);
	}

	public String deleteById(String name) {
		repo.deleteById(name);
		return "user deleted with name : " + name;
	}
	
	@Retry(name = "default", fallbackMethod = "hardCodedValue")
	public String hello() {
		logger.info("Call to invalid method in the posts service");
		return new RestTemplate().getForEntity(config.getUrl() + "/posts/hello", String.class).getBody();
	}
	
	public String hardCodedValue(Exception ex) {
		return "Deafult hardcoded response in the case of failed response";
	}

}
