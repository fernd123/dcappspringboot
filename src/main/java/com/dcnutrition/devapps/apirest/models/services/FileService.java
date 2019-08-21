package com.dcnutrition.devapps.apirest.models.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.dcnutrition.devapps.apirest.models.entity.Customer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

 
@Component
public class FileService {
 	
	//private static final String FILE_DIRECTORY = "/var/files";
	private static final String FILE_DIRECTORY = "D:\\workspace\\dcnutritionapp\\spring-boot-dcnutrition-apirest\\src\\main\\resources\\customerdata";

	public String storeFile(MultipartFile file, Customer currentCustomer) throws IOException {
		
		String path = FILE_DIRECTORY + "/" + currentCustomer.getName()+"_"+currentCustomer.getLastname()+"_"+file.getOriginalFilename();
		Path filePath = Paths.get(path); 
		Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
		
		return path;
	}
}