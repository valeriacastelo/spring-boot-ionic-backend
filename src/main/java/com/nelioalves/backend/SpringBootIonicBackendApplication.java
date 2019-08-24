package com.nelioalves.backend;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelioalves.backend.domain.Address;
import com.nelioalves.backend.domain.Category;
import com.nelioalves.backend.domain.City;
import com.nelioalves.backend.domain.Client;
import com.nelioalves.backend.domain.Product;
import com.nelioalves.backend.domain.State;
import com.nelioalves.backend.domain.enums.ClientType;
import com.nelioalves.backend.repositories.AddressRepository;
import com.nelioalves.backend.repositories.CategoryRepository;
import com.nelioalves.backend.repositories.CityRepository;
import com.nelioalves.backend.repositories.ClientRepository;
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
	
	@Autowired
	private AddressRepository addressRepo;
	
	@Autowired
	private ClientRepository clientRepo;

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
		
		City cit1 = new City(null, "Uberlandia", s1);
		City cit2 = new City(null, "Campinas", s2);
		City cit3 = new City(null, "Sao Paulo", s2);
		
		s1.getCities().addAll(Arrays.asList(cit1));
		s2.getCities().addAll(Arrays.asList(cit2, cit3));
		
		categoryRepo.saveAll(Arrays.asList(cat1, cat2));
		productRepo.saveAll(Arrays.asList(p1,p2,p3));
		
		stateRepo.saveAll(Arrays.asList(s1,s2));
		cityRepo.saveAll(Arrays.asList(cit1,cit2, cit3));
		
		Client cli1 = new Client(null, "Maria Silva", "maria@gmail.com", "36378912377", ClientType.PERSON);
		
		Address add1 = new Address(null, "Apto 203, 300 Rua Flores, Jardim", "38220834", cit1, cli1);
		Address add2 = new Address(null, "Sala 108, 105 Avenida Matos, Centro", "38777012", cit2, cli1);
		
		cli1.getPhones().addAll(Arrays.asList("27363323", "93838393"));
		cli1.getAddresses().addAll(Arrays.asList(add1, add2));
		
		clientRepo.save(cli1);
		addressRepo.saveAll(Arrays.asList(add1, add2));
		
		
		
	}

}
