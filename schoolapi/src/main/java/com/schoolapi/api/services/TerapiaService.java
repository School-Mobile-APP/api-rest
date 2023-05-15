package com.schoolapi.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolapi.api.entities.Jornada;
import com.schoolapi.api.entities.Terapia;
import com.schoolapi.api.repositories.TerapiaRepository;

import jakarta.transaction.Transactional;
@Service
public class TerapiaService implements BaseService<Terapia>{
	@Autowired
	private TerapiaRepository terapiaRepository;
	@Override
	@Transactional
	public List<Terapia> findAll() throws Exception {
		try {
			List<Terapia> terapias = terapiaRepository.findAll();
			return terapias;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Terapia findById(Long id) throws Exception {
		try {
			Optional<Terapia> terapia = terapiaRepository.findById(id);
			return terapia.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());

		}
	}

}
