package com.dcnutrition.devapps.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcnutrition.devapps.apirest.models.dao.ICustomerDao;
import com.dcnutrition.devapps.apirest.models.entity.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	private ICustomerDao customerDao;

	@Override
	@Transactional(readOnly=true)
	public List<Customer> findAll() {
		return customerDao.findAll();
	}
	
	@Override
	public Customer findById(Long id) {
		return customerDao.findById(id).orElse(null);
	}

	@Override
	public List<Customer> findByKeyword(String keyword) {
		return customerDao.findByKeyword(keyword);
	}
	
	@Override
	public Customer save(Customer customer) {
		Customer c = customerDao.save(customer);
		return c;
	}

	@Override
	public Customer update(Customer customer) {
		Customer c = customerDao.save(customer);
		return c;
	}

	@Override
	public void delete(Long id) {
		customerDao.deleteById(id);
	}
}
