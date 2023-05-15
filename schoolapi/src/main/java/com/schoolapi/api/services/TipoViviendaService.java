package com.schoolapi.api.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.schoolapi.api.entities.TipoVivienda;
import com.schoolapi.api.repositories.TipoViviendaRepository;

import jakarta.transaction.Transactional;

public class TipoViviendaService implements BaseService<TipoVivienda> {
	@Autowired
	private TipoViviendaRepository tipoViviendaRepository;
	@Override
	@Transactional
	public List<TipoVivienda> findAll() throws Exception {
		try {
			List<TipoVivienda> tiposvivienda = tipoViviendaRepository.findAll();
			return tiposvivienda;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public TipoVivienda findById(Long id) throws Exception {
		try {
			Optional<TipoVivienda> tipovivienda = tipoViviendaRepository.findById(id);
			return tipovivienda.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
