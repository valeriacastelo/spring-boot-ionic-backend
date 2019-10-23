package com.nelioalves.backend.services;

import java.util.Date;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.nelioalves.backend.domain.Order;

public abstract class AbstractEmailService implements EmailService {
	
	@Value("{default.sender")
	private String sender;
	
	@Autowired
	private TemplateEngine templateEngine;

	@Override
	public void sendOrderConfirmationEmail(Order obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromOder(obj);
		
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromOder(Order obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getClient().getEmail());
		sm.setFrom(sender);
		sm.setSubject("Order has been placed! Number: " + obj.getId());
		sm.setText(obj.toString());
		return sm;
	}
	
	protected String htmlFromOrderTemplate(Order obj) {
		Context context = new Context();
		context.setVariable("order", obj);
		
		return templateEngine.process("email/orderConfirmation", context);
	}
	
	@Override
	public void sendOrderConfirmationHtmlEmail(Order obj) {
		
		try {
			MimeMessagePreparator mm = prepareMimeMailMessageFromOder(obj);
			sendHtmlEmail(mm);
		} catch (MessagingException e) {
			sendOrderConfirmationEmail(obj);
		}
	}

	protected MimeMessagePreparator prepareMimeMailMessageFromOder(Order obj) throws MessagingException {
		MimeMessagePreparator messagePreparator = mimeMessage -> {
			MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
			mmh.setTo(obj.getClient().getEmail());
			mmh.setFrom(this.sender);
			mmh.setSubject("Order has been placed! Number: " + obj.getId());
			mmh.setSentDate(new Date(System.currentTimeMillis()));
			mmh.setText(htmlFromOrderTemplate(obj), true);
		};
		
		return messagePreparator;
	}
}
