package com.nelioalves.backend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.backend.domain.Category;
import com.nelioalves.backend.repositories.CategoryRepository;
import com.nelioalves.backend.services.exception.ObjectNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repo;
	
	public Category find(Integer id) {
		Optional<Category> op = repo.findById(id);
		
		return op.orElseThrow(() -> new ObjectNotFoundException("Object not found! "
				+ "Id:[" + id + "] Type:[" + Category.class.getName() + "]"));
	}
	
	public Category insert(Category category) {
		category.setId(null);
		return repo.save(category);
	}
	
	public Category update(Category category) {
		find(category.getId());
		return repo.save(category);
	}

}
