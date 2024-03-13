package com.narinder.trainings.userservice.dto;

import java.util.List;

import com.narinder.trainings.userservice.service.User;

public class OrderDetails {
	
	private Integer userId;
	
	private String username;
	
	private String address;
	
	private String emailId;
	
	private String contact;
	
	private List<Orders> orders;
	
	public OrderDetails() {
		
	}
	
	public OrderDetails(User user, List<Orders> orders) {
		this.setUserId(user.getUserId());
		this.setAddress(user.getAddress());
		this.setContact(user.getContact());
		this.setEmailId(user.getEmailId());
		this.setUsername(user.getUsername());
		this.setOrders(orders);
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

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	
}
