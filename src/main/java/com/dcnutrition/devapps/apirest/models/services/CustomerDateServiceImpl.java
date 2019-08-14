package com.dcnutrition.devapps.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcnutrition.devapps.apirest.models.dao.ICustomerDateDao;
import com.dcnutrition.devapps.apirest.models.entity.CustomerDate;

@Service
public class CustomerDateServiceImpl implements ICustomerDateService{

	@Autowired
	private ICustomerDateDao dateDao;

	@Override
	@Transactional(readOnly=true)
	public List<?> findAllByCustomer() {
		return dateDao.findAllByCustomer();
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<CustomerDate> findAll() {
		return dateDao.findAll();
	}
	
	@Override
	public CustomerDate findById(Long id) {
		return dateDao.findById(id).orElse(null);
	}
	
	@Override
	public CustomerDate save(CustomerDate date) {
		CustomerDate m = dateDao.save(date);
		return m;
	}
	
	@Override
	public CustomerDate update(CustomerDate date) {
		CustomerDate m = dateDao.save(date);
		return m;
	}

	@Override
	public void delete(Long id) {
		dateDao.deleteById(id);
	}
}
