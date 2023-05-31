package com.schoolapi.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schoolapi.api.entities.Persona;
import com.schoolapi.api.repositories.PersonaRepository;

@Service
public class PersonaService implements BaseService<Persona>{
	@Autowired
	private PersonaRepository personaRepository;

	@Override
	public List<Persona> findAll() throws Exception {
		try {
			List<Persona> personas=personaRepository.findAll();
			return personas;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Persona findById(Long id) throws Exception {
		try {
			Optional<Persona> persona = personaRepository.findById(id);
			return persona.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());

		}
	}
}
