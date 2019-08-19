package com.nelioalves.backend.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nelioalves.backend.domain.Category;

@RestController
@RequestMapping(value="categories")
public class CategoryResource {
	
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
