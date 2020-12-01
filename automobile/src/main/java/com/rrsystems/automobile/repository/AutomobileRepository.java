package com.rrsystems.automobile.repository;

import org.springframework.stereotype.Repository;

import com.rrsystems.automobile.model.AutomobileModel;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface AutomobileRepository extends CrudRepository<AutomobileModel, Long> {

	@Override
	List<AutomobileModel> findAll();
}
