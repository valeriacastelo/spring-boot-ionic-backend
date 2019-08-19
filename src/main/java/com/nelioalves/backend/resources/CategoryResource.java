package com.nelioalves.backend.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.backend.domain.Category;
import com.nelioalves.backend.services.CategoryService;

@RestController
@RequestMapping(value="categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find (@PathVariable Integer id) {
		Category category = service.find(id);
		
		return ResponseEntity.ok(category);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Category> list() {
		
		Category catComputing = new Category(1, "Computing");
		Category catOffice = new Category(1, "Office");
		
		List<Category> list = new ArrayList<Category>();
		list.add(catComputing);
		list.add(catOffice);
		
		return list;
	}

}
