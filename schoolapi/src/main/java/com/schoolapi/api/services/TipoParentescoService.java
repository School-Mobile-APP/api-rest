package com.schoolapi.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schoolapi.api.entities.TipoParentesco;
import com.schoolapi.api.repositories.TipoParentescoRepository;

@Service
public class TipoParentescoService implements BaseService<TipoParentesco>{
	@Autowired
	private TipoParentescoRepository tipoParentescoRepository;
	@Override
	public List<TipoParentesco> findAll() throws Exception {
		try {
			List<TipoParentesco> parentescos=tipoParentescoRepository.findAll();
			return parentescos;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public TipoParentesco findById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
