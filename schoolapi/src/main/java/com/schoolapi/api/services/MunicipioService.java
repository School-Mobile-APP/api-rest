package com.schoolapi.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.schoolapi.api.entities.Municipio;
import com.schoolapi.api.repositories.MunicipioRepository;

@Service
public class MunicipioService implements BaseService<Municipio>{
	private MunicipioRepository municipiosrepository;
	@Override
	public List<Municipio> findAll() throws Exception {
		try {
			List<Municipio> municipios=municipiosrepository.findAll();
			return municipios;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Municipio findById(Long id) throws Exception {
		try {
			Optional<Municipio> municipio=municipiosrepository.findById(id);
			return municipio.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
}
