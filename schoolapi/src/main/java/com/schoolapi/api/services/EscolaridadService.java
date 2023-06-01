package com.schoolapi.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schoolapi.api.entities.Escolaridad;
import com.schoolapi.api.repositories.EscolaridadRepository;

@Service
public class EscolaridadService implements BaseService<Escolaridad>{
	@Autowired
	private EscolaridadRepository escolaridadRepository;

	@Override
	public List<Escolaridad> findAll() throws Exception {
		try {
			List<Escolaridad> escolaridades=escolaridadRepository.findAll();
			return escolaridades;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Escolaridad findById(Long id) throws Exception {
		try {
			Optional<Escolaridad> escolaridad=escolaridadRepository.findById(id);
			return escolaridad.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
