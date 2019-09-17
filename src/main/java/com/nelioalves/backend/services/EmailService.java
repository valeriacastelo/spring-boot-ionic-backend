package com.nelioalves.backend.services;

import org.springframework.mail.SimpleMailMessage;

import com.nelioalves.backend.domain.Order;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Order obj);
	
	void sendEmail(SimpleMailMessage msg);

}
