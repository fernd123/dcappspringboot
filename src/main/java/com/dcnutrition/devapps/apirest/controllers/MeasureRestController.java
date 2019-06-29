package com.dcnutrition.devapps.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.dcnutrition.devapps.apirest.models.entity.Measure;
import com.dcnutrition.devapps.apirest.models.services.ICustomerService;
import com.dcnutrition.devapps.apirest.models.services.IMeasureService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins= {"http://localhost:4200"})
public class MeasureRestController 
{

	@Autowired
	private IMeasureService measureService;
	
	@Autowired
	private ICustomerService customerService;

	@GetMapping("/measures")
	public List<Measure> index(){
		return this.measureService.findAll();
	}

	@GetMapping("/measures/{id}")
	public Measure show(@PathVariable Long id){
		return measureService.findById(id);
	}

	@PostMapping("/measures/{customerId}")
	@ResponseStatus(HttpStatus.CREATED)
	public Measure save(@RequestBody Measure measure, @PathVariable Long customerId){
		Customer customer = customerService.findById(customerId);
		measure.setCustomer(customer);
		return measureService.save(measure);
	}

	@PutMapping("/measures/{id}")
	public Measure update(@RequestBody Measure measure, @PathVariable Long id){
		Measure currentMeasure = measureService.findById(id);

		// Update fields
		currentMeasure.setWeight(measure.getWeight());
		currentMeasure.setWaist(measure.getWaist());
		currentMeasure.setBiceps(measure.getBiceps());
		currentMeasure.setChest(measure.getChest());
		currentMeasure.setGluteus(measure.getGluteus());
		currentMeasure.setLeg(measure.getLeg());
		currentMeasure.setMaxFrecueny(measure.getMaxFrecueny());
		currentMeasure.setMinFrecuency(measure.getMinFrecuency());
		
		return measureService.save(currentMeasure);
	}

	@DeleteMapping("/measures/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
		measureService.delete(id);
	}
}
