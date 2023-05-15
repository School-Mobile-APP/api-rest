package com.schoolapi.api.services;import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schoolapi.api.entities.CanalAtencion;
import com.schoolapi.api.repositories.CanalAtencionRepository;

import jakarta.transaction.Transactional;
@Service
public class CanalService implements BaseService<CanalAtencion>{
	@Autowired
	private CanalAtencionRepository canalRepository;
	@Override
	@Transactional
	public List<CanalAtencion> findAll() throws Exception {
		try {
			List<CanalAtencion> canales=canalRepository.findAll();
			return canales;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public CanalAtencion findById(Long id) throws Exception {
		try {
			Optional<CanalAtencion> canal=canalRepository.findById(id);
			return canal.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
