package com.rrsystems.automobile.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rrsystems.automobile.dto.SaveAutomobileRequestDTO;
import com.rrsystems.automobile.repository.AutomobileRepository;

@ExtendWith(MockitoExtension.class)
class AutomobileServiceTest {
	
	@InjectMocks
	private AutomobileService service;
	
	@Mock
	private AutomobileRepository repository;

	@Test
	void getAllAutomobilesTest() {
		service.getAllAutomobiles();
		Mockito.verify(repository, Mockito.times(1)).findAll();
	}
	
	@Test
	void saveAutomobileTest() {
		service.saveAutomobile(new SaveAutomobileRequestDTO());
		Mockito.verify(repository, Mockito.times(1)).save(Mockito.any());
	}

}
