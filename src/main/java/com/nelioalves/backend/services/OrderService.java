package com.nelioalves.backend.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.backend.domain.Category;
import com.nelioalves.backend.domain.InvoicePayment;
import com.nelioalves.backend.domain.Order;
import com.nelioalves.backend.domain.OrderItem;
import com.nelioalves.backend.domain.Product;
import com.nelioalves.backend.domain.enums.PaymentStatus;
import com.nelioalves.backend.repositories.OrderItemRepository;
import com.nelioalves.backend.repositories.OrderRepository;
import com.nelioalves.backend.repositories.PaymentRepository;
import com.nelioalves.backend.services.exception.ObjectNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repo;
	
	@Autowired
	private InvoiceService invoiceService;
	
	@Autowired
	private PaymentRepository paymentRepo;
	
	@Autowired
	private OrderItemRepository orderItemRepo;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private EmailService emailService;
	
	public Order find(Integer id) {
		Optional<Order> op = repo.findById(id);
		
		return op.orElseThrow(() -> new ObjectNotFoundException("Object not found! "
				+ "Id:[" + id + "] Type:[" + Category.class.getName() + "]"));
	}
	
	public Order insert(Order obj) {
		obj.setId(null);
		obj.setDate(new Date());
		obj.setClient(clientService.find(obj.getClient().getId()));
		obj.getPayment().setStatus(PaymentStatus.PENDING);
		obj.getPayment().setOrder(obj);
		
		if(obj.getPayment() instanceof InvoicePayment) {
			InvoicePayment ip = (InvoicePayment)obj.getPayment();
			invoiceService.fillInvoicePayment(ip, obj.getDate());
		}
		
		repo.save(obj);
		paymentRepo.save(obj.getPayment());
		
		for (OrderItem item : obj.getItens()) {
			item.setDiscount(0.0);
			item.setProduct(productService.find(item.getProduct().getId()));
			item.setPrice(item.getProduct().getPrice());
			item.setOrder(obj);
		}
		
		orderItemRepo.saveAll(obj.getItens());
		emailService.sendOrderConfirmationEmail(obj);
		
		return obj;
	}

}
