package com.rrsystems.automobile.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SaveAutomobileRequestDTO {
	
	@NotEmpty
	private String brand;
	
	@NotEmpty
	private String model;
	
	@NotNull
	private BigDecimal value;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
	

}
