package com.narinder.trainings.userservice.dto;

import com.narinder.trainings.userservice.service.User;

public class UserDetails {
	
	private Integer userId;
	
	private String username;
	
	private String address;
	
	private String emailId;
	
	private String contact;
	
	public UserDetails() {
		
	}
	
	public UserDetails(User user) {
		this.setAddress(user.getAddress());
		this.setContact(user.getContact());
		this.setEmailId(user.getEmailId());
		this.setUsername(user.getUsername());
		this.setUserId(user.getUserId());
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
}
