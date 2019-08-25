package com.nelioalves.backend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.backend.domain.Category;
import com.nelioalves.backend.domain.Order;
import com.nelioalves.backend.repositories.OrderRepository;
import com.nelioalves.backend.services.exception.ObjectNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repo;
	
	public Order find(Integer id) {
		Optional<Order> op = repo.findById(id);
		
		return op.orElseThrow(() -> new ObjectNotFoundException("Object not found! "
				+ "Id:[" + id + "] Type:[" + Category.class.getName() + "]"));
	}

}
