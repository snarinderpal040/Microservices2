package com.narinder.trainings.orderservice.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.narinder.trainings.orderservice.models.Orders;

@Repository
public interface OrderRepository extends CrudRepository<Orders, Integer>{
	
	public Optional<List<Orders>> findByUsername(String username);

}
