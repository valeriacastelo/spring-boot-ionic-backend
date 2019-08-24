package com.nelioalves.backend.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.nelioalves.backend.domain.enums.PaymentStatus;

@Entity
public class InvoicePayment extends Payment {
	private static final long serialVersionUID = 1L;
	
	private Date dueDate;
	private Date payedDate;
	
	public InvoicePayment() {
		
	}

	public InvoicePayment(Integer id, PaymentStatus status, Order order, Date dueDate, Date payedDate) {
		super(id, status, order);
		this.dueDate = dueDate;
		this.payedDate = payedDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getPayedDate() {
		return payedDate;
	}

	public void setPayedDate(Date payedDate) {
		this.payedDate = payedDate;
	}	

}
