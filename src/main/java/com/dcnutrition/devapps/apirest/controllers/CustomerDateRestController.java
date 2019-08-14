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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dcnutrition.devapps.apirest.models.entity.Customer;
import com.dcnutrition.devapps.apirest.models.entity.CustomerDate;
import com.dcnutrition.devapps.apirest.models.services.ICustomerDateService;
import com.dcnutrition.devapps.apirest.models.services.ICustomerService;

@RestController
@RequestMapping("/api")
public class CustomerDateRestController 
{

	@Autowired(required=true)
	private ICustomerDateService dateService;
	
	@Autowired(required=true)
	private ICustomerService customerService;

	@GetMapping("/customerdates")
	public List<?> index(){
		return this.dateService.findAllByCustomer();
	}

	@GetMapping("/customerdates/{id}")
	public CustomerDate show(@PathVariable Long id){
		return dateService.findById(id);
	}

	@PostMapping("/customerdates/{customerId}")
	public CustomerDate save(@RequestBody CustomerDate date, @PathVariable Long customerId){
		Customer customer = customerService.findById(customerId);
		date.setCustomer(customer);
		CustomerDate c = dateService.save(date);
		/*c.setCustomer(customer);
		dateService.save(date); */
		return c;
	}

	@PutMapping("/customerdates/{id}")
	public CustomerDate update(@RequestBody CustomerDate date, @PathVariable Long id){
		CustomerDate currentDate = dateService.findById(id);

		// Update fields
		currentDate.setStart(date.getStart());
		currentDate.setEnd(date.getEnd());
		currentDate.setColor(date.getColor());
		currentDate.setObservations(date.getObservations());
		
		return dateService.save(currentDate);
	}

	@DeleteMapping("/customerdates/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
		dateService.delete(id);
	}
}
