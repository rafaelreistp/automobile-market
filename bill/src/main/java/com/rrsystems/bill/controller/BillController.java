package com.rrsystems.bill.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rrsystems.bill.dto.GetBillDetailResponseDTO;
import com.rrsystems.bill.dto.SaveBillRequestDTO;
import com.rrsystems.bill.model.BillModel;
import com.rrsystems.bill.service.BillService;

@RestController
@RequestMapping("/bill")
public class BillController {
	
	@Autowired
	private BillService billService;
	
	@PostMapping
	public ResponseEntity<BillModel> saveBill(@RequestBody @Valid SaveBillRequestDTO saveBillRequestDTO) throws Exception {
		BillModel bill = this.billService.saveBill(saveBillRequestDTO);
		if (bill != null) {
			return new ResponseEntity<>(bill, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.PRECONDITION_FAILED);
		}
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<GetBillDetailResponseDTO> getBillDetail(@PathVariable("id") Long id) {
		return new ResponseEntity<>(this.billService.getBillDetail(id), HttpStatus.OK);
	}

}
