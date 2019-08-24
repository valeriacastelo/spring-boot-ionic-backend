package com.nelioalves.backend.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.backend.domain.Product;
import com.nelioalves.backend.services.ProductService;

@RestController
@RequestMapping(value="products")
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find (@PathVariable Integer id) {
		Product product = service.find(id);
		
		return ResponseEntity.ok(product);
	}
	
}