package com.schoolapi.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schoolapi.api.entities.ReferenciasApoyo;
import com.schoolapi.api.repositories.ReferenciasApoyoRepository;

import jakarta.transaction.Transactional;

@Service
public class ReferenciaService implements BaseService<ReferenciasApoyo>{
	@Autowired
	private ReferenciasApoyoRepository referenciasApoyoRepository;
	@Override
	@Transactional
	public List<ReferenciasApoyo> findAll() throws Exception {
		try {
			List<ReferenciasApoyo> referencias=referenciasApoyoRepository.findAll();
			return referencias;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public ReferenciasApoyo findById(Long id) throws Exception {
		try {
			Optional<ReferenciasApoyo> referencia=referenciasApoyoRepository.findById(id);
			return referencia.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	

}
