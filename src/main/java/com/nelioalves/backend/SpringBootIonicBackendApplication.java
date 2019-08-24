package com.nelioalves.backend;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelioalves.backend.domain.Category;
import com.nelioalves.backend.domain.City;
import com.nelioalves.backend.domain.Product;
import com.nelioalves.backend.domain.State;
import com.nelioalves.backend.repositories.CategoryRepository;
import com.nelioalves.backend.repositories.CityRepository;
import com.nelioalves.backend.repositories.ProductRepository;
import com.nelioalves.backend.repositories.StateRepository;

@SpringBootApplication
public class SpringBootIonicBackendApplication implements CommandLineRunner{
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private StateRepository stateRepo;
	
	@Autowired
	private CityRepository cityRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootIonicBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Computing");
		Category cat2 = new Category(null, "Office");
		
		Product p1 = new Product(null, "Computer", 2000.00);
		Product p2 = new Product(null, "Printer", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		State s1 = new State(null, "Minas Gerais");
		State s2 = new State(null, "Sao Paulo");
		
		City c1 = new City(null, "Uberlandia", s1);
		City c2 = new City(null, "Campinas", s2);
		City c3 = new City(null, "Sao Paulo", s2);
		
		s1.getCities().addAll(Arrays.asList(c1));
		s2.getCities().addAll(Arrays.asList(c2, c3));
		
		categoryRepo.saveAll(Arrays.asList(cat1, cat2));
		productRepo.saveAll(Arrays.asList(p1,p2,p3));
		
		stateRepo.saveAll(Arrays.asList(s1,s2));
		cityRepo.saveAll(Arrays.asList(c1,c2, c3));
		
	}

}
