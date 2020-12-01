package com.rrsystems.bill.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

public class SaveBillRequestDTO {
	
	@NotNull
	private Long automobileId;
	
	@NotNull
	private BigDecimal value;
	
	@NotNull
	private Date dueDate;

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

}
