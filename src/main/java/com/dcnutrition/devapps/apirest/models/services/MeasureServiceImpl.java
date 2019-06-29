package com.dcnutrition.devapps.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dcnutrition.devapps.apirest.models.dao.IMeasureDao;
import com.dcnutrition.devapps.apirest.models.entity.Measure;

@Service
public class MeasureServiceImpl implements IMeasureService{

	@Autowired
	private IMeasureDao measureDao;

	@Override
	@Transactional(readOnly=true)
	public List<Measure> findAll() {
		return measureDao.findAll();
	}
	
	@Override
	public Measure findById(Long id) {
		return measureDao.findById(id).orElse(null);
	}
	
	@Override
	public Measure save(Measure measure) {
		Measure m = measureDao.save(measure);
		return m;
	}

	@Override
	public Measure update(Measure measure) {
		Measure m = measureDao.save(measure);
		return m;
	}

	@Override
	public void delete(Long id) {
		measureDao.deleteById(id);
	}
}
