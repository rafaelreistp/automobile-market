package com.rrsystems.bill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rrsystems.bill.client.AutomobileClient;
import com.rrsystems.bill.dto.AutomobileDTO;
import com.rrsystems.bill.dto.GetBillDetailResponseDTO;
import com.rrsystems.bill.dto.SaveBillRequestDTO;
import com.rrsystems.bill.model.BillModel;
import com.rrsystems.bill.repository.BillRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;



@Service
public class BillService {

	@Autowired
	private BillRepository billRepository;
	
	@Autowired
	private AutomobileClient automobileClient;
	
	@CircuitBreaker(name = "automobileBackend")
	public BillModel saveBill(SaveBillRequestDTO saveBillRequestDTO) throws Exception {
		ResponseEntity<AutomobileDTO> exchange = this.automobileClient.getAutomobileById(saveBillRequestDTO.getAutomobileId());
		if(exchange.getBody() != null) {
			BillModel bill = new BillModel(saveBillRequestDTO.getAutomobileId(), saveBillRequestDTO.getValue(), saveBillRequestDTO.getDueDate());
			return billRepository.save(bill);
		} else {
			return null;
		}
	}
	
	public GetBillDetailResponseDTO getBillDetail(Long billId) {
		BillModel bill = this.billRepository.findById(billId).orElseThrow();
		ResponseEntity<AutomobileDTO> exchange = this.automobileClient.getAutomobileById(bill.getAutomobileId());
		return new GetBillDetailResponseDTO(bill, exchange.getBody());
	}
	
}
