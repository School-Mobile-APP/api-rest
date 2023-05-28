package com.schoolapi.api.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
import com.schoolapi.api.entities.FuentesAgua;
import com.schoolapi.api.repositories.FuentesAguaRepository;

import jakarta.transaction.Transactional;

@Service
public class FuentesAguaService implements BaseService<FuentesAgua>{
	@Autowired
	private FuentesAguaRepository fuentesAguaRepository;
	@Override
	@Transactional
	public List<FuentesAgua> findAll() throws Exception {
		try {
			List<FuentesAgua> aguas=fuentesAguaRepository.findAll();
			return aguas;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public FuentesAgua findById(Long id) throws Exception {
		try {
			Optional<FuentesAgua> agua=fuentesAguaRepository.findById(id);
			return agua.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
