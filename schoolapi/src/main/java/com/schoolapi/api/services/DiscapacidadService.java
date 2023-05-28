package com.schoolapi.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schoolapi.api.entities.Discapacidad;
import com.schoolapi.api.repositories.DiscapacidadRepository;

import jakarta.transaction.Transactional;

@Service
public class DiscapacidadService implements BaseService<Discapacidad>{
	@Autowired
	private DiscapacidadRepository discapacidadRepository;

	@Override
	@Transactional
	public List<Discapacidad> findAll() throws Exception {
		try {
			List<Discapacidad> discapacidades=discapacidadRepository.findAll();
			return discapacidades;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Discapacidad findById(Long id) throws Exception {
		try {
			Optional<Discapacidad> discapacidad=discapacidadRepository.findById(id);
			return discapacidad.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
