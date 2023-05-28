package com.schoolapi.api.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schoolapi.api.entities.Zona;
import com.schoolapi.api.repositories.ZonaRepository;

import jakarta.transaction.Transactional;

@Service
public class ZonaService implements BaseService<Zona> {
	@Autowired
	private ZonaRepository zonaRepository;
	@Override
	@Transactional
	public List<Zona> findAll() throws Exception {
		try {
			List<Zona> zonas=zonaRepository.findAll();
			return zonas;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Zona findById(Long id) throws Exception {
		try {
			Optional<Zona> zona=zonaRepository.findById(id);
			return zona.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	

}
