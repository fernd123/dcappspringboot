package com.dcnutrition.devapps.apirest.models.services;

import java.util.List;

import com.dcnutrition.devapps.apirest.models.entity.Customer;

public interface ICustomerService {

	public List<Customer> findAll();
	public Customer findById(Long id);
	public List<Customer> findByKeyword(String keyword);
	//public List<Customer> findByNameContaining(String name);

	public Customer save(Customer customer);
	public Customer update(Customer customer);
	public void delete(Long id);

}
