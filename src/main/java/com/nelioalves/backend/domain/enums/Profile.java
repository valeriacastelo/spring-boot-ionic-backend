package com.nelioalves.backend.domain.enums;

public enum Profile {
	
	ADMIN (1, "HOLE_ADMIN"), 
	CLIENT (2, "HOLE_CLIENT");
	
	private int id;
	private String description;
	
	private Profile(int id, String description) {
		this.id = id;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}
	
	public static Profile toEnum (int id) {
		
		for (Profile e : Profile.values()) {
			if (e.getId() == id) {
				return e;
			}
		}
		
		throw new IllegalArgumentException("Invalid id [" + id + "]");
	}
	
}
