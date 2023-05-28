package com.schoolapi.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolapi.api.entities.Sexo;
import com.schoolapi.api.repositories.SexoRepository;

import jakarta.transaction.Transactional;

@Service
public class SexoService implements BaseService<Sexo>{
	@Autowired
	private SexoRepository sexoRepository;
	@Override
	@Transactional
	public List<Sexo> findAll() throws Exception {
		try {
			List<Sexo> sexos = sexoRepository.findAll();
			return sexos;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Sexo findById(Long id) throws Exception {
		try {
			Optional<Sexo> sexo=sexoRepository.findById(id);
			return sexo.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
}
