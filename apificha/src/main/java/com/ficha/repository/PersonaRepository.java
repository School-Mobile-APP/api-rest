package com.ficha.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.ficha.model.SgPersona;
import com.ficha.model.SgPersonaDiscapacidad;
public interface PersonaRepository extends JpaRepository<SgPersona, Long>{
	@Query(value = "select pd.per_pk,pd.dis_pk "
			+ "from sg_personas_discapacidades pd"
			+ " where pd.per_pk=:id", nativeQuery = true)
	List<SgPersonaDiscapacidad> getDiscapacidades(@PathVariable("id") Long id);
	@Modifying
	@Query(value = "update sg_personas set per_tipo_vivienda_fk=:viv where per_pk=:id"
			, nativeQuery = true)
	@Transactional
	Integer updateTipoVivienda(@PathVariable("perTipoVivienda") Long viv, @PathVariable("id") Long id);
	@Modifying	
	@Query(value = "update sg_personas set per_acceso_internet=:internet where per_pk=:id"
			, nativeQuery = true)
	@Transactional
	Integer updateAccesoInternet(@PathVariable("internet") Boolean internet, @PathVariable("id") Long id);
}
