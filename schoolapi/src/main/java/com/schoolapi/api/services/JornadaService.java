package com.schoolapi.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schoolapi.api.entities.Jornada;
import com.schoolapi.api.repositories.JornadaRepository;

import jakarta.transaction.Transactional;

@Service
public class JornadaService implements BaseService<Jornada>{
	@Autowired
	private JornadaRepository jornadaRepository;
	@Override
	@Transactional
	public List<Jornada> findAll() throws Exception {
		try {
			List<Jornada> jornadas = jornadaRepository.findAll();
			return jornadas;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Jornada findById(Long id) throws Exception {
		try {
			Optional<Jornada> jornada = jornadaRepository.findById(id);
			return jornada.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());

		}
	}

}
