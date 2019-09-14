package com.nelioalves.backend.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.nelioalves.backend.domain.InvoicePayment;

@Service
public class InvoiceService {
	
	public void fillInvoicePayment(InvoicePayment ip, Date orderDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(orderDate);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		
		ip.setDueDate(cal.getTime());
	}

}
