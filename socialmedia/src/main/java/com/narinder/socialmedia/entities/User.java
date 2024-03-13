package com.narinder.socialmedia.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@Column(name = "uname")
	private String name;
	
	@Column(name = "udob")
	private LocalDate birthdate;
	
	public User() {
		
	}

	public User(Integer id, String name, LocalDate birthdate) {
		super();
		this.name = name;
		this.birthdate = birthdate;
	}

	public User(String name, LocalDate birthdate) {
		this.name = name;
		this.birthdate = birthdate;
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

	@Override
	public String toString() {
		return "User [name=" + name + ", birthdate=" + birthdate + "]";
	}
	
}
