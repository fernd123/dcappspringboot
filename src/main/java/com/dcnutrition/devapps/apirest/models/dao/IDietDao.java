package com.dcnutrition.devapps.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcnutrition.devapps.apirest.models.entity.Diet;

public interface IDietDao extends JpaRepository<Diet, Long>{

	
}
