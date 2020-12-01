package com.rrsystems.automobile.controller;

import java.util.List;

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

import com.rrsystems.automobile.dto.SaveAutomobileRequestDTO;
import com.rrsystems.automobile.model.AutomobileModel;
import com.rrsystems.automobile.service.AutomobileService;

@RestController
@RequestMapping("/automobile")
public class AutomobileController {
	
	@Autowired
	private AutomobileService automobileService;
	
	@GetMapping
	public ResponseEntity<List<AutomobileModel>> getAllAutomobiles() {
		return new ResponseEntity<>(this.automobileService.getAllAutomobiles(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AutomobileModel> getAutomobileById(@PathVariable("id") Long id) {
		AutomobileModel automobile = this.automobileService.getAutomobileById(id);
		if (automobile != null) {
			return new ResponseEntity<>(automobile, HttpStatus.OK);	
		} else {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		
	}
	
	@PostMapping
	public ResponseEntity<AutomobileModel> saveAutomobile(@RequestBody @Valid SaveAutomobileRequestDTO saveAutomobileRequestDTO) {
		return new ResponseEntity<>(this.automobileService.saveAutomobile(saveAutomobileRequestDTO), HttpStatus.CREATED);
	}
	

}
