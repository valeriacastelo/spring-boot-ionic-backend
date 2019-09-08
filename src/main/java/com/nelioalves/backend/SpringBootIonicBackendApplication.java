package com.nelioalves.backend;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelioalves.backend.domain.Address;
import com.nelioalves.backend.domain.CardPayment;
import com.nelioalves.backend.domain.Category;
import com.nelioalves.backend.domain.City;
import com.nelioalves.backend.domain.Client;
import com.nelioalves.backend.domain.InvoicePayment;
import com.nelioalves.backend.domain.Order;
import com.nelioalves.backend.domain.OrderItem;
import com.nelioalves.backend.domain.Payment;
import com.nelioalves.backend.domain.Product;
import com.nelioalves.backend.domain.State;
import com.nelioalves.backend.domain.enums.ClientType;
import com.nelioalves.backend.domain.enums.PaymentStatus;
import com.nelioalves.backend.repositories.AddressRepository;
import com.nelioalves.backend.repositories.CategoryRepository;
import com.nelioalves.backend.repositories.CityRepository;
import com.nelioalves.backend.repositories.ClientRepository;
import com.nelioalves.backend.repositories.OrderItemRepository;
import com.nelioalves.backend.repositories.OrderRepository;
import com.nelioalves.backend.repositories.PaymentRepository;
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
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private PaymentRepository paymentRepo;
	
	@Autowired
	private OrderItemRepository orderItemRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootIonicBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Computing");
		Category cat2 = new Category(null, "Office");
		Category cat3 = new Category(null, "Category A");
		Category cat4 = new Category(null, "Category B");
		Category cat5 = new Category(null, "Category C");
		Category cat6 = new Category(null, "Category D");
		Category cat7 = new Category(null, "Category E");
		Category cat8 = new Category(null, "Category F");
		Category cat9 = new Category(null, "Category G");
		Category cat10 = new Category(null, "Category H");
		
		Product prod1 = new Product(null, "Computer", 2000.00);
		Product prod2 = new Product(null, "Printer", 800.00);
		Product prod3 = new Product(null, "Mouse", 80.00);
		Product prod4 = new Product(null, "Product A", 300.00);
		Product prod5 = new Product(null, "Product B", 50.00);
		Product prod6 = new Product(null, "Product C", 200.00);
		Product prod7 = new Product(null, "Product D", 1200.00);
		Product prod8 = new Product(null, "Product E", 800.00);
		Product prod9 = new Product(null, "Product F", 100.00);
		Product prod10 = new Product(null, "Product G", 180.00);
		Product prod11 = new Product(null, "Product H", 90.00);
		
		cat1.getProducts().addAll(Arrays.asList(prod1, prod2, prod3));
		cat2.getProducts().addAll(Arrays.asList(prod2, prod4));
		cat3.getProducts().addAll(Arrays.asList(prod5, prod6));
		cat4.getProducts().addAll(Arrays.asList(prod1, prod2, prod3, prod7));
		cat5.getProducts().addAll(Arrays.asList(prod8));
		cat6.getProducts().addAll(Arrays.asList(prod9, prod10));
		cat7.getProducts().addAll(Arrays.asList(prod11));
		
		prod1.getCategories().addAll(Arrays.asList(cat1, cat4));
		prod2.getCategories().addAll(Arrays.asList(cat1, cat2, cat4));
		prod3.getCategories().addAll(Arrays.asList(cat1, cat4));
		prod4.getCategories().addAll(Arrays.asList(cat2));
		prod5.getCategories().addAll(Arrays.asList(cat3));
		prod6.getCategories().addAll(Arrays.asList(cat3));
		prod7.getCategories().addAll(Arrays.asList(cat4));
		prod8.getCategories().addAll(Arrays.asList(cat5));
		prod9.getCategories().addAll(Arrays.asList(cat6));
		prod10.getCategories().addAll(Arrays.asList(cat6));
		prod11.getCategories().addAll(Arrays.asList(cat7));
		
		State s1 = new State(null, "Minas Gerais");
		State s2 = new State(null, "Sao Paulo");
		
		City cit1 = new City(null, "Uberlandia", s1);
		City cit2 = new City(null, "Campinas", s2);
		City cit3 = new City(null, "Sao Paulo", s2);
		
		s1.getCities().addAll(Arrays.asList(cit1));
		s2.getCities().addAll(Arrays.asList(cit2, cit3));
		
		categoryRepo.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10));
		productRepo.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5, prod6, prod7, prod8, prod9, prod10, prod11));
		
		stateRepo.saveAll(Arrays.asList(s1,s2));
		cityRepo.saveAll(Arrays.asList(cit1,cit2, cit3));
		
		Client cli1 = new Client(null, "Maria Silva", "maria@gmail.com", "36378912377", ClientType.PERSON);
		
		Address add1 = new Address(null, "Apto 203, 300 Rua Flores, Jardim", "38220834", cit1, cli1);
		Address add2 = new Address(null, "Sala 108, 105 Avenida Matos, Centro", "38777012", cit2, cli1);
		
		cli1.getPhones().addAll(Arrays.asList("27363323", "93838393"));
		cli1.getAddresses().addAll(Arrays.asList(add1, add2));
		
		clientRepo.save(cli1);
		addressRepo.saveAll(Arrays.asList(add1, add2));
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Order ord1 = new Order(null, sdf.parse("30/09/2017 10:32:00"), cli1, add1);
		Order ord2 = new Order(null, sdf.parse("10/10/2017 19:35:00"), cli1, add2);
		
		Payment pay1 = new CardPayment(null, PaymentStatus.PAYED, ord1, 6);
		ord1.setPayment(pay1);
		
		
		Payment pay2 = new InvoicePayment(null, PaymentStatus.PENDING, ord2, sdf.parse("20/10/2017 23:59:59"), null);
		ord2.setPayment(pay2);
		
		
		cli1.getOrders().addAll(Arrays.asList(ord1));
		
		orderRepo.saveAll(Arrays.asList(ord1, ord2));
		paymentRepo.saveAll(Arrays.asList(pay1, pay2));
		
		OrderItem item1 = new OrderItem(ord1, prod1, 0.00, 1, 2000.00);
		OrderItem item2 = new OrderItem(ord1, prod3, 0.00, 2, 80.00);
		OrderItem item3 = new OrderItem(ord2, prod2, 100.00, 1, 800.00);
		
		ord1.getItens().addAll(Arrays.asList(item1, item2));
		ord2.getItens().addAll(Arrays.asList(item3));
		
		
		prod1.getItens().addAll(Arrays.asList(item1));
		prod2.getItens().addAll(Arrays.asList(item3));
		prod3.getItens().addAll(Arrays.asList(item2));
		
		orderItemRepo.saveAll(Arrays.asList(item1, item2, item3));
		
	}

}
