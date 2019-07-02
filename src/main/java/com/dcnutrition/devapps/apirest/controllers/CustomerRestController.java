package com.dcnutrition.devapps.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dcnutrition.devapps.apirest.models.entity.Customer;
import com.dcnutrition.devapps.apirest.models.services.ICustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController 
{
	@Autowired
	private ICustomerService customerService;

	@GetMapping("/customers")
	public List<Customer> index(){
		return this.customerService.findAll();
	}

	@GetMapping("/customers/{id}")
	public Customer show(@PathVariable Long id){
		return customerService.findById(id);
	}

	@GetMapping(value = "/customers/find")
	public List<Customer> findByNameAndLastnameAndEmailAndPhone(
			@RequestParam(name = "keyword") String keyword){
		List<Customer> resultado = customerService.findByKeyword(keyword);
		return resultado;
	}

	@PostMapping("/customers")
	@ResponseStatus(HttpStatus.CREATED)
	public Customer save(@RequestBody Customer customer){
		return customerService.save(customer);
	}

	@PutMapping("/customers/{id}")
	public Customer update(@RequestBody Customer customer, @PathVariable Long id){
		Customer currentCustomer = customerService.findById(id);

		// Update fields
		currentCustomer.setBirthday(customer.getBirthday());
		currentCustomer.setCity(customer.getCity());
		currentCustomer.setEmail(customer.getEmail());
		currentCustomer.setHeight(customer.getHeight());
		currentCustomer.setLastname(customer.getLastname());
		currentCustomer.setName(customer.getName());
		currentCustomer.setObservations(customer.getObservations());
		currentCustomer.setPhone(customer.getPhone());
		currentCustomer.setSex(customer.getSex());

		return customerService.save(currentCustomer);
	}

	@DeleteMapping("/customers/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
		customerService.delete(id);
	}
}
