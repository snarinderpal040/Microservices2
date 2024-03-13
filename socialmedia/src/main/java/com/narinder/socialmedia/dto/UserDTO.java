package com.narinder.socialmedia.dto;

import java.time.LocalDate;
import java.util.List;

public class UserDTO {
	
	private Integer id;
	
	private String name;
	
	private LocalDate birthdate;
	
	private List<PostDTO> post;
	
	public UserDTO() {
		
	}

	public UserDTO(Integer id, String name, LocalDate birthdate, List<PostDTO> post) {
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
		this.post = post;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return "UserDTO [id=" + id + ", name=" + name + ", birthdate=" + birthdate + ", post=" + post + "]";
	}

}
