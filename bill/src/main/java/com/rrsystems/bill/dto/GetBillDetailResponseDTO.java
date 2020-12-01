package com.rrsystems.bill.dto;

import com.rrsystems.bill.model.BillModel;

public class GetBillDetailResponseDTO {
	
	private BillModel bill;
	private AutomobileDTO automobile;
	
	public GetBillDetailResponseDTO(BillModel bill, AutomobileDTO automobile) {
		super();
		this.bill = bill;
		this.automobile = automobile;
	}

	public BillModel getBill() {
		return bill;
	}

	public void setBill(BillModel bill) {
		this.bill = bill;
	}

	public AutomobileDTO getAutomobile() {
		return automobile;
	}

	public void setAutomobile(AutomobileDTO automobile) {
		this.automobile = automobile;
	}

}
