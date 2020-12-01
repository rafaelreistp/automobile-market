package com.rrsystems.automobile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rrsystems.automobile.dto.SaveAutomobileRequestDTO;
import com.rrsystems.automobile.model.AutomobileModel;
import com.rrsystems.automobile.repository.AutomobileRepository;

@Service
public class AutomobileService {
	
	@Autowired
	private AutomobileRepository automobileRepository;
	
	public List<AutomobileModel> getAllAutomobiles() {
		return this.automobileRepository.findAll();
	}
	
	public AutomobileModel saveAutomobile(SaveAutomobileRequestDTO saveAutomobileRequestDTO) {
		AutomobileModel automobile = new AutomobileModel(saveAutomobileRequestDTO.getBrand(), saveAutomobileRequestDTO.getModel(), saveAutomobileRequestDTO.getValue());
		return this.automobileRepository.save(automobile);
	}

	public AutomobileModel getAutomobileById(Long automobileId) {
		return this.automobileRepository.findById(automobileId).orElse(null);
	}

}
