package com.nelioalves.backend.domain.enums;

public enum PaymentStatus {
	
	PENDING (1, "Pending"), 
	PAYED (2, "Payed"), 
	CANCELLED (3, "Cancelled");
	
	private int id;
	private String description;
	
	private PaymentStatus(int id, String description) {
		this.id = id;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}
	
	public static PaymentStatus toEnum (int id) {
		
		for (PaymentStatus e : PaymentStatus.values()) {
			if (e.getId() == id) {
				return e;
			}
		}
		
		throw new IllegalArgumentException("Invalid id [" + id + "]");
	}
	
}
