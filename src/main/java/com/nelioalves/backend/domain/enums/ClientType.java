package com.nelioalves.backend.domain.enums;

public enum ClientType {
	
	PERSON  (1, "Pessoa Fisica"),
	COMPANY (2, "Pessoa Juridica");
	
	private int id;
	private String description;
	
	private ClientType (int id, String description) {
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}
	
	public static ClientType toEnum (int id) {
		
		for (ClientType e : ClientType.values()) {
			if (e.getId() == id) {
				return e;
			}
		}
		
		throw new IllegalArgumentException("Invalid id [" + id + "]");
	}

}
