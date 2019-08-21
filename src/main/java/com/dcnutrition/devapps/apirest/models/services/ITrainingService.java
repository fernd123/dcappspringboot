package com.dcnutrition.devapps.apirest.models.services;

import java.util.List;

import com.dcnutrition.devapps.apirest.models.entity.Training;

public interface ITrainingService {

	public List<Training> findAll();
	public Training findById(Long id);
	public Training save(Training training);
	public Training update(Training training);
	public void delete(Long id);

}
