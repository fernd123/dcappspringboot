package com.dcnutrition.devapps.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcnutrition.devapps.apirest.models.dao.IDietDao;
import com.dcnutrition.devapps.apirest.models.dao.IMeasureDao;
import com.dcnutrition.devapps.apirest.models.dao.ITrainingDao;
import com.dcnutrition.devapps.apirest.models.entity.Diet;
import com.dcnutrition.devapps.apirest.models.entity.Measure;
import com.dcnutrition.devapps.apirest.models.entity.Training;

@Service
public class TrainingServiceImpl implements ITrainingService{

	@Autowired
	private ITrainingDao trainingDao;

	@Override
	@Transactional(readOnly=true)
	public List<Training> findAll() {
		return trainingDao.findAll();
	}
	
	@Override
	public Training findById(Long id) {
		return trainingDao.findById(id).orElse(null);
	}
	
	@Override
	public Training save(Training training) {
		Training t = trainingDao.save(training);
		return t;
	}

	@Override
	public Training update(Training training) {
		Training t = trainingDao.save(training);
		return t;
	}

	@Override
	public void delete(Long id) {
		trainingDao.deleteById(id);
	}
}
