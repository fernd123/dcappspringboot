package com.dcnutrition.devapps.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcnutrition.devapps.apirest.models.entity.Training;

public interface ITrainingDao extends JpaRepository<Training, Long>{

	
}
