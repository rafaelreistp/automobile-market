package com.rrsystems.bill.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.rrsystems.bill.dto.AutomobileDTO;

@FeignClient("automobile")
public interface AutomobileClient {

	@GetMapping("/automobile/{id}")
	ResponseEntity<AutomobileDTO> getAutomobileById(@PathVariable("id") Long id); 
}
