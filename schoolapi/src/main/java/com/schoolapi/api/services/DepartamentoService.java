package com.schoolapi.api.services;

import java.util.List;
import java.util.Optional;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolapi.api.entities.Departamento;
import com.schoolapi.api.repositories.DepartamentoRepository;

import jakarta.transaction.Transactional;

@Service
public class DepartamentoService implements BaseService<Departamento> {
	@Autowired
	private DepartamentoRepository departamentoRepository;

	@Override
	@Transactional
	public List<Departamento> findAll() throws Exception {
		try {
			List<Departamento> departamentos=departamentoRepository.findAll();
			System.out.println(departamentos);
			return departamentos;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Departamento findById(Long id) throws Exception {
		try {
			Optional<Departamento> departamento=departamentoRepository.findById(id);
			return departamento.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * @Override
	 * 
	 * @Transactional public Departamento save(Departamento entity) throws Exception
	 * { try { entity=departamentoRepository.save(entity); return entity; } catch
	 * (Exception e) { throw new Exception(e.getMessage()); } }
	 */

	/*
	 * @Override public Departamento update(Long id, Departamento Entity) throws
	 * Exception { try { Optional<Departamento>
	 * deptoFindOptional=departamentoRepository.findById(id); Departamento
	 * deptoModified=deptoFindOptional.get();
	 * deptoModified=departamentoRepository.save(Entity); return deptoModified; }
	 * catch (Exception e) { throw new Exception(e.getMessage()); } }
	 */
	/*
	 * @Override public boolean delete(Long id) throws Exception { try {
	 * if(departamentoRepository.existsById(id)) {
	 * departamentoRepository.deleteById(id); return true; }else { throw new
	 * Exception(); } } catch (Exception e) { throw new Exception(e.getMessage()); }
	 * }
	 */

}
