package com.narinder.socialmedia.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class UserDTO {
		
	@Size(min = 3, message = "name should be atleast 3 characters long")
	private String name;
	
	@Past(message = "Birth date should be in the past")
	private LocalDate birthdate;
	
	private List<PostDTO> post;
	
	public UserDTO() {
		
	}
	
	public UserDTO(String name, LocalDate birthDate) {
		this.name = name;
		this.birthdate = birthDate;
	}

	public UserDTO(String name, LocalDate birthdate, List<PostDTO> post) {
		this.name = name;
		this.birthdate = birthdate;
		this.post = post;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public List<PostDTO> getPost() {
		return post;
	}

	public void setPost(List<PostDTO> post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", birthdate=" + birthdate + ", post=" + post + "]";
	}

}
