package com.schoolapi.api.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schoolapi.api.entities.Nacionalidad;
import com.schoolapi.api.repositories.NacionalidadRepository;

import jakarta.transaction.Transactional;

@Service
public class NacionalidadesService implements BaseService<Nacionalidad>{
	@Autowired
	private NacionalidadRepository nacionalidadRepository;
	@Override
	@Transactional
	public List<Nacionalidad> findAll() throws Exception {
		try {
			List<Nacionalidad> nacionalidades=nacionalidadRepository.findAll();
			return nacionalidades;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	@Override
	public Nacionalidad findById(Long id) throws Exception {
		try {
			Optional<Nacionalidad> nacionalidad=nacionalidadRepository.findById(id);
			return nacionalidad.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
