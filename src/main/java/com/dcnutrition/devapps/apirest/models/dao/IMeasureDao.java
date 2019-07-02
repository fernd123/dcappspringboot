package com.dcnutrition.devapps.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcnutrition.devapps.apirest.models.entity.Measure;

public interface IMeasureDao extends JpaRepository<Measure, Long>{

	
}
