package com.nelioalves.backend;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelioalves.backend.domain.Category;
import com.nelioalves.backend.repositories.CategoryRepository;

@SpringBootApplication
public class SpringBootIonicBackendApplication implements CommandLineRunner{
	
	@Autowired
	private CategoryRepository categoryRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootIonicBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category catComputing = new Category(null, "Computing");
		Category catOffice = new Category(null, "Office");
		
		categoryRepo.saveAll(Arrays.asList(catComputing, catOffice));
		
	}

}
