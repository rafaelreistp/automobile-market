package com.rrsystems.bill.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rrsystems.bill.model.BillModel;

@Repository
public interface BillRepository extends CrudRepository<BillModel, Long>{

}
