package com.nelioalves.backend.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.nelioalves.backend.domain.Order;

public abstract class AbstractEmailService implements EmailService {
	
	@Value("{default.sender")
	private String sender;

	@Override
	public void sendOrderConfirmationEmail(Order obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromOder(obj);
		
		sendEmail(sm);
	}

	private SimpleMailMessage prepareSimpleMailMessageFromOder(Order obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getClient().getEmail());
		sm.setFrom(sender);
		sm.setSubject("Order has been placed! Number: " + obj.getId());
		sm.setText(obj.toString());
		return sm;
	}

}
