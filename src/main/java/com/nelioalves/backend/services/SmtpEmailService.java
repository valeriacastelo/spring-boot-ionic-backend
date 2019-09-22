package com.nelioalves.backend.services;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class SmtpEmailService extends AbstractEmailService {
	
	private static final Logger LOG = LoggerFactory.getLogger(MockMailService.class);
	
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Sending email by Gmail");
		mailSender.send(msg);
		LOG.info("Email has been sent");
	}

	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		LOG.info("Sending email by Gmail");
		javaMailSender.send(msg);
		LOG.info("Email has been sent");
		
	}
}
