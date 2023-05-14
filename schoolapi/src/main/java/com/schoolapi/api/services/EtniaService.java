package com.schoolapi.api.services;

import java.util.List;
import java.util.Optional;

import com.schoolapi.api.entities.Etnia;
import com.schoolapi.api.entities.Municipio;
import com.schoolapi.api.repositories.EtniasRepository;

public class EtniaService implements BaseService<Etnia>{
	private EtniasRepository etniasRepository;

	@Override
	public List<Etnia> findAll() throws Exception {
		try {
			List<Etnia> etnias=etniasRepository.findAll();
			return etnias;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Etnia findById(Long id) throws Exception {
		try {
			Optional<Etnia> etnia=etniasRepository.findById(id);
			return etnia.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	

}
