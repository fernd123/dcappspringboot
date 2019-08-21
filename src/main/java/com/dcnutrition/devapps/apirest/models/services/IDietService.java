package com.dcnutrition.devapps.apirest.models.services;

import java.util.List;

import com.dcnutrition.devapps.apirest.models.entity.Diet;

public interface IDietService {

	public List<Diet> findAll();
	public Diet findById(Long id);
	public Diet save(Diet diet);
	public Diet update(Diet diet);
	public void delete(Long id);

}
