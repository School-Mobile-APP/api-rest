package com.schoolapi.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schoolapi.api.entities.EscolaridadEstudiante;
import com.schoolapi.api.repositories.EscolaridadEstudianteRepository;

@Service
public class EscolaridadEstudianteService implements BaseService<EscolaridadEstudiante> {
	@Autowired
	private EscolaridadEstudianteRepository escolaridadEstudianteRepository;

	@Override
	public List<EscolaridadEstudiante> findAll() throws Exception {
		try {
			List<EscolaridadEstudiante> escolaridades=escolaridadEstudianteRepository.findAll();
			return escolaridades;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public EscolaridadEstudiante findById(Long id) throws Exception {
		try {
			Optional<EscolaridadEstudiante> escolaridad=escolaridadEstudianteRepository.findById(id);
			return escolaridad.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
}
