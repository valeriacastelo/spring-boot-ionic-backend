package com.nelioalves.backend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.backend.domain.Product;
import com.nelioalves.backend.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repo;
	
	public Product find(Integer id) {
		Optional<Product> op = repo.findById(id);
		
		return op.orElse(null);
	}

}
