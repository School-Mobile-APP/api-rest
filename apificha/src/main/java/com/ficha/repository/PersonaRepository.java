package com.ficha.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.ficha.dto.SgFichaDatos;
import com.ficha.model.SgPersona;
import com.ficha.model.SgPersonaDiscapacidad;
public interface PersonaRepository extends JpaRepository<SgPersona, Long>{
	@Query(value = "select pd.per_pk,pd.dis_pk "
			+ "from sg_personas_discapacidades pd"
			+ " where pd.per_pk=:id", nativeQuery = true)
	List<SgPersonaDiscapacidad> getDiscapacidades(@PathVariable("id") Long id);
}
