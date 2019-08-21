package com.dcnutrition.devapps.apirest.controllers;

import java.io.IOException;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dcnutrition.devapps.apirest.models.entity.Customer;
import com.dcnutrition.devapps.apirest.models.entity.Diet;
import com.dcnutrition.devapps.apirest.models.entity.Training;
import com.dcnutrition.devapps.apirest.models.services.FileService;
import com.dcnutrition.devapps.apirest.models.services.ICustomerService;
import com.dcnutrition.devapps.apirest.models.services.IDietService;
import com.dcnutrition.devapps.apirest.models.services.ITrainingService;
 
@RestController
@RequestMapping("/api")
public class FileController {
 
	private final FileService fileService;
 
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private ITrainingService trainingService;
	
	@Autowired
	private IDietService dietService;
	
	@Autowired
	public FileController(FileService fileService) {
		this.fileService = fileService;
	}
 
	@PostMapping(value = "/files/{type}/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void handleFileUpload(@RequestParam("file") MultipartFile file, @PathVariable String type, @PathVariable Long id) throws IOException {
		Customer currentCustomer = customerService.findById(id);
		String path = fileService.storeFile(file, currentCustomer);
		
		if(type.equals("T")) {
			Training t = new Training();
			t.setName(path);
			t.setCustomer(currentCustomer);
			trainingService.save(t);
		}else {
			Diet d = new Diet();
			d.setName(path);
			d.setCustomer(currentCustomer);
			dietService.save(d);
		}
		
	}
 
}