package com.nelioalves.backend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.backend.domain.Category;
import com.nelioalves.backend.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repo;
	
	public Category find(Integer id) {
		Optional<Category> op = repo.findById(id);
		
		return op.orElse(null);
	}

}
