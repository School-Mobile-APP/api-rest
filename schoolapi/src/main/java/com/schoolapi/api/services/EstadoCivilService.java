package com.schoolapi.api.services; 
import java.util.List;
import java.util.Optional; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schoolapi.api.entities.EstadoCivil;
import com.schoolapi.api.repositories.EstadoCivilRepository;
import jakarta.transaction.Transactional;

@Service
public class EstadoCivilService implements BaseService<EstadoCivil> {

	@Autowired
	private EstadoCivilRepository estadoCivilRepository;

	@Override
	@Transactional
	public List<EstadoCivil> findAll() throws Exception {
		try {
			List<EstadoCivil> estadosCiviles = estadoCivilRepository.findAll();
			return estadosCiviles;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public EstadoCivil findById(Long id) throws Exception {
		try {
			Optional<EstadoCivil> estadoCivil = estadoCivilRepository.findById(id);
			return estadoCivil.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());

		}
	}

}
