package com.application.rest.persistence.impl;

import java.util.List;
import java.util.Optional;

import com.application.rest.repository.MakerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.application.rest.entities.Maker;
import com.application.rest.persistence.IMakerDao;
import org.springframework.stereotype.Component;

@Component
public class MakerDaoImpl implements IMakerDao {

	@Autowired
	MakerRepository makerRepository;

	@Override
	public List<Maker> findAll() {

		return (List<Maker>) makerRepository.findAll();
	}

	@Override
	public Optional<Maker> findById(Long id) {

		return makerRepository.findById(id);
	}

	@Override
	public void save(Maker maker) {

		makerRepository.save(maker);

	}

	@Override
	public void deleteById(Long id) {
		makerRepository.deleteById(id);

	}

	@Override
	public void saveAll(List<Maker> makers) {

		makerRepository.saveAll(makers);

	}

}
