package com.rrsystems.automobile.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.rrsystems.automobile.dto.SaveAutomobileRequestDTO;
import com.rrsystems.automobile.model.AutomobileModel;
import com.rrsystems.automobile.service.AutomobileService;

@ExtendWith(MockitoExtension.class)
class AutomobileControllerTest {

	@InjectMocks
	private AutomobileController controller;
	
	@Mock
	private AutomobileService service;
	
	@Test
	void getAllAutomobilesTest() {
		Mockito.when(service.getAllAutomobiles()).thenReturn(new ArrayList<>());
		ResponseEntity<List<AutomobileModel>> response = controller.getAllAutomobiles();
		Mockito.verify(service, Mockito.times(1)).getAllAutomobiles();
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	void getAutomobileByIdTest() {
		Mockito.when(service.getAutomobileById(Mockito.anyLong())).thenReturn(new AutomobileModel());
		ResponseEntity<AutomobileModel> response = controller.getAutomobileById(0L);
		Mockito.verify(service, Mockito.times(1)).getAutomobileById(0L);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	void getAutomobileByIdEmptyTest() {
		Mockito.when(service.getAutomobileById(Mockito.anyLong())).thenReturn(null);
		ResponseEntity<AutomobileModel> response = controller.getAutomobileById(0L);
		Mockito.verify(service, Mockito.times(1)).getAutomobileById(0L);
		assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
	}
	
	@Test
	void saveAutomobileTest() {
		ResponseEntity<AutomobileModel> response = controller.saveAutomobile(new SaveAutomobileRequestDTO());
		Mockito.verify(service, Mockito.times(1)).saveAutomobile(Mockito.any());
		assertEquals(response.getStatusCode(), HttpStatus.CREATED);
	}

}
