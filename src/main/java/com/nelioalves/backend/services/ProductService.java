package com.nelioalves.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nelioalves.backend.domain.Category;
import com.nelioalves.backend.domain.Product;
import com.nelioalves.backend.repositories.CategoryRepository;
import com.nelioalves.backend.repositories.ProductRepository;
import com.nelioalves.backend.services.exception.ObjectNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	
	public Product find(Integer id) {
		Optional<Product> op = repo.findById(id);
		
		return op.orElseThrow(() -> new ObjectNotFoundException("Object not found! "
				+ "Id:[" + id + "] Type:[" + Product.class.getName() + "]"));
	}
	
	public Page<Product> search(String name, List<Integer> categoriesId, 
								Integer page, Integer linesPerPage, String orderBy, String direction) {
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Category> categories = categoryRepo.findAllById(categoriesId);
		
		return repo.findDistinctByNameContainingAndCategoriesIn(name, categories, pageRequest);
	}

}
