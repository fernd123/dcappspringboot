package com.dcnutrition.devapps.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcnutrition.devapps.apirest.models.dao.IDietDao;
import com.dcnutrition.devapps.apirest.models.dao.IMeasureDao;
import com.dcnutrition.devapps.apirest.models.entity.Diet;
import com.dcnutrition.devapps.apirest.models.entity.Measure;

@Service
public class DietServiceImpl implements IDietService{

	@Autowired
	private IDietDao dietDao;

	@Override
	@Transactional(readOnly=true)
	public List<Diet> findAll() {
		return dietDao.findAll();
	}
	
	@Override
	public Diet findById(Long id) {
		return dietDao.findById(id).orElse(null);
	}
	
	@Override
	public Diet save(Diet diet) {
		Diet d = dietDao.save(diet);
		return d;
	}

	@Override
	public Diet update(Diet diet) {
		Diet d = dietDao.save(diet);
		return d;
	}

	@Override
	public void delete(Long id) {
		dietDao.deleteById(id);
	}
}
