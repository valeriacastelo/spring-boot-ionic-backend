package com.nelioalves.backend.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.nelioalves.backend.services.validation.ClientInsert;

@ClientInsert
public class ClientNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Cannot be empty")
	@Length(min = 5, max = 120, message = "Size between 5 and 120 caracters")
	private String name;
	
	@NotEmpty(message = "Cannot be empty")
	@Email(message = "Email invalid")
	private String email;
	
	@NotEmpty(message = "Cannot be empty")
	private String taxpayerNumber;
	
	private Integer type;
	
	@NotEmpty(message = "Cannot be empty")
	private String sreetAddress;
	
	@NotEmpty(message = "Cannot be empty")
	private String zipCode;
	
	@NotEmpty(message = "Cannot be empty")
	private String phone1;
	
	private String phone2;
	private String phone3;
	
	private Integer cityId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTaxpayerNumber() {
		return taxpayerNumber;
	}

	public void setTaxpayerNumber(String taxpayerNumber) {
		this.taxpayerNumber = taxpayerNumber;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getSreetAddress() {
		return sreetAddress;
	}

	public void setSreetAddress(String sreetAddress) {
		this.sreetAddress = sreetAddress;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}	
}
