package com.nelioalves.backend.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessagePreparator;

public class MockMailService extends AbstractEmailService {
	
	private static final Logger LOG = LoggerFactory.getLogger(MockMailService.class);

	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Mocking the email sending");
		LOG.info(msg.toString());
		LOG.info("Email has been sent");
	}

	@Override
	public void sendHtmlEmail(MimeMessagePreparator msg) {
		LOG.info("Mocking the HTML email sending");
		LOG.info(msg.toString());
		LOG.info("Email has been sent");
	}	
}
