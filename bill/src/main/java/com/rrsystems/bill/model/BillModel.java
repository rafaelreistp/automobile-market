package com.rrsystems.bill.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BillModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long automobileId;
	
	private BigDecimal value;
	
	private Date dueDate;
	
	private Date registerDate;
	
	public BillModel() {
		super();
	}

	public BillModel(Long automobileId, BigDecimal value, Date dueDate) {
		super();
		this.automobileId = automobileId;
		this.value = value;
		this.dueDate = dueDate;
		this.registerDate = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAutomobileId() {
		return automobileId;
	}

	public void setAutomobileId(Long automobileId) {
		this.automobileId = automobileId;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
	

}
