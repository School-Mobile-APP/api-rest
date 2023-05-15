package com.schoolapi.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.schoolapi.api.entities.TipoTrabajo;
import com.schoolapi.api.entities.TipoVivienda;
import com.schoolapi.api.repositories.TipoTrabajoRepository;

import jakarta.transaction.Transactional;

public class TipoTrabajoService implements BaseService<TipoTrabajo>{
	@Autowired
	private TipoTrabajoRepository tipoTrabajoRepository;
	@Override
	@Transactional
	public List<TipoTrabajo> findAll() throws Exception {
		try {
			List<TipoTrabajo> tipostrabajo = tipoTrabajoRepository.findAll();
			return tipostrabajo;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public TipoTrabajo findById(Long id) throws Exception {
		try {
			Optional<TipoTrabajo> tipotrabajo = tipoTrabajoRepository.findById(id);
			return tipotrabajo.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
