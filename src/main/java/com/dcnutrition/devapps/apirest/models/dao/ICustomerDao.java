package com.dcnutrition.devapps.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dcnutrition.devapps.apirest.models.entity.Customer;

public interface ICustomerDao extends JpaRepository<Customer, Long>{
	
	@Query(value = "select c from Customer c where CONCAT(c.name, ' ',c.lastname)  LIKE CONCAT('%',:keyword,'%')")
	public List<Customer> findByKeyword(@Param("keyword") String keyword);

	
}
