package com.schoolapi.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.schoolapi.api.entities.Sede;
import com.schoolapi.api.entities.Sexo;
import com.schoolapi.api.repositories.SedeRepository;

import jakarta.transaction.Transactional;

public class SedeService implements BaseService<Sede>{
	@Autowired
	private SedeRepository sedeRepository;
	@Override
	@Transactional
	public List<Sede> findAll() throws Exception {
		try {
			List<Sede> sedes= sedeRepository.findAll();
			return sedes;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Sede findById(Long id) throws Exception {
		try {
			Optional<Sede> sede=sedeRepository.findById(id);
			return sede.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
