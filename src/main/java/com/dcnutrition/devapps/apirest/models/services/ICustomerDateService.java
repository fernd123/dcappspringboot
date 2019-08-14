package com.dcnutrition.devapps.apirest.models.services;

import java.util.List;

import com.dcnutrition.devapps.apirest.models.entity.CustomerDate;

public interface ICustomerDateService {

	public List<?> findAllByCustomer();
	public List<CustomerDate> findAll();
	public CustomerDate findById(Long id);
	public CustomerDate save(CustomerDate date);
	public CustomerDate update(CustomerDate date);
	public void delete(Long id);

}
