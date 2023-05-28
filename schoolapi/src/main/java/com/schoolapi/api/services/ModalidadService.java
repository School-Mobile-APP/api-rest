package com.schoolapi.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolapi.api.entities.Modalidad;
import com.schoolapi.api.repositories.ModalidadRepository;

import jakarta.transaction.Transactional;

@Service
public class ModalidadService implements BaseService<Modalidad>{
	@Autowired
	private ModalidadRepository modalidadRepository;
	@Override
	@Transactional
	public List<Modalidad> findAll() throws Exception {
		try {
			List<Modalidad> modalidades=modalidadRepository.findAll();
			return modalidades;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Modalidad findById(Long id) throws Exception {
		try {
			Optional<Modalidad> modalidad=modalidadRepository.findById(id);
			return modalidad.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
