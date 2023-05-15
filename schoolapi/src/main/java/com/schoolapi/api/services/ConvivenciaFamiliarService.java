package com.schoolapi.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolapi.api.entities.ConvivenciaFamiliar;
import com.schoolapi.api.entities.Municipio;
import com.schoolapi.api.repositories.ConvivenciaFamiliarRepository;

import jakarta.transaction.Transactional;

@Service
public class ConvivenciaFamiliarService implements BaseService<ConvivenciaFamiliar>{
	
	@Autowired
	private ConvivenciaFamiliarRepository convivenciaFamiliarRepository;
	@Override
	@Transactional
	public List<ConvivenciaFamiliar> findAll() throws Exception {
		try {
			List<ConvivenciaFamiliar> convivencias=convivenciaFamiliarRepository.findAll();
			return convivencias;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public ConvivenciaFamiliar findById(Long id) throws Exception {
		try {
			Optional<ConvivenciaFamiliar> convivencia=convivenciaFamiliarRepository.findById(id);
			return convivencia.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
