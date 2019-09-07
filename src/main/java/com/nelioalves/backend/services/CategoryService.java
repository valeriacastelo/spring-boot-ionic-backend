package com.nelioalves.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nelioalves.backend.domain.Category;
import com.nelioalves.backend.dto.CategoryDTO;
import com.nelioalves.backend.repositories.CategoryRepository;
import com.nelioalves.backend.services.exception.DataIntegrityException;
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
	
	public void delete (Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch(DataIntegrityViolationException ex) {
			throw new DataIntegrityException("Not possible delete a Category with associated Products");
		}
	}
	
	public List<Category> findAll() {
		return repo.findAll();
	}
	
	public Page<Category> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Category fromDTO(CategoryDTO categoryDTO) {
		return new Category(categoryDTO.getId(), categoryDTO.getName());
	}

}
