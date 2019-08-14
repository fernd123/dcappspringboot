package com.dcnutrition.devapps.apirest.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dcnutrition.devapps.apirest.models.entity.CustomerDate;

public interface ICustomerDateDao extends JpaRepository<CustomerDate, Long>{


	@Query(value = "select cd.id as id, c.id as customer, c.name, c.lastname, cd.start, cd.end from CustomerDate cd left join Customer c on c = cd.customer")
	public List<?> findAllByCustomer();
	
}
