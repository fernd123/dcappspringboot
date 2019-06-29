package com.dcnutrition.devapps.apirest.models.services;

import java.util.List;

import com.dcnutrition.devapps.apirest.models.entity.Measure;

public interface IMeasureService {

	public List<Measure> findAll();
	public Measure findById(Long id);
	public Measure save(Measure measure);
	public Measure update(Measure measure);
	public void delete(Long id);

}
