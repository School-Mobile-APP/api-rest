package com.ficha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import com.ficha.model.SgPersonaReferencia;

public interface ReferenciasRepository extends JpaRepository<SgPersonaReferencia, Long>{
	@Modifying
	@Query(value = "delete from centros_educativos.sg_personas_referencias_apoyo a where "
			+"a.per_pk=:pk and a.rea_pk!=:rea", nativeQuery = true)
	 @Transactional
	public void deleteRef(@PathVariable("pk") Long pk,@PathVariable("rea") Long rea);
	@Query(value = "select a.per_pk,a.rea_pk"
			+ " from centros_educativos.sg_personas_referencias_apoyo a" + " where a.per_pk=:id", nativeQuery = true)
	@Transactional(readOnly = true)
	public SgPersonaReferencia getPersonaRef(@PathVariable("id") Long id);

}
