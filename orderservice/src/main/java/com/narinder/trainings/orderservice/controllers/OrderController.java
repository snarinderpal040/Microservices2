package com.narinder.trainings.orderservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.narinder.trainings.orderservice.models.Orders;
import com.narinder.trainings.orderservice.service.OrdersService;


@RestController
public class OrderController {
	
	@Autowired
	private OrdersService service;
	
	@GetMapping("/orders/username/{username}")
	public ResponseEntity<List<Orders>> getOrdersByUsername(@PathVariable String username) {
		return new ResponseEntity<>(service.getOrdersByUsername(username), HttpStatus.OK);
	}
	
	@GetMapping("/orders/orderid/{orderId}")
	public ResponseEntity<Orders> getOrderById(@PathVariable int orderId){
		return new ResponseEntity<Orders>(service.findById(orderId) , HttpStatus.OK);
	}
	
	@GetMapping("/orders")
	public ResponseEntity<List<Orders>> getAllOrders(){
		return new ResponseEntity<>(service.findAllOrders() , HttpStatus.OK);
	}
	
	@PostMapping("/orders")
	public ResponseEntity<String> saveOrder(@RequestBody Orders orders){
		return service.saveOrder(orders);
	}
	
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<String> deleteOrderById(@PathVariable int id){
		return new ResponseEntity<String>(service.deleteById(id), HttpStatus.ACCEPTED);
	}

}
