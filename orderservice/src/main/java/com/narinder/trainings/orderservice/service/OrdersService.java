package com.narinder.trainings.orderservice.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.narinder.trainings.orderservice.exceptions.OrderNotFoundException;
import com.narinder.trainings.orderservice.models.Orders;
import com.narinder.trainings.orderservice.repositories.OrderRepository;

@Service
public class OrdersService {

	@Autowired
	private OrderRepository repo;

	public List<Orders> getOrdersByUsername(String username) {
		return repo.findByUsername(username)
				.orElseThrow(() -> new OrderNotFoundException("No orders with username : " + username));
	}
	
	public Orders findById(int orderId) {
		return repo.findById(orderId)
				.orElseThrow(() -> new OrderNotFoundException("No oder found with id : " + orderId));
	}
	
	public ResponseEntity<String> saveOrder(Orders orders) {
		repo.save(orders);
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{orderId}").buildAndExpand(orders.getOrderId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	public List<Orders> findAllOrders(){
		return (List<Orders>) repo.findAll();
	}

	public String deleteById(int id) {
		repo.deleteById(id);
		return "Order deleted";
	}

}
