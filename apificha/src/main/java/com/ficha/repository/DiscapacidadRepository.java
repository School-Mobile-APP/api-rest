package com.ficha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.ficha.model.SgPersonaDiscapacidad;

public interface DiscapacidadRepository extends JpaRepository<SgPersonaDiscapacidad, Long>{
	@Query(value = "select pd.per_pk,pd.dis_pk"
			+ " from sg_personas_discapacidades pd" + " where pd.per_pk=:id", nativeQuery = true)
	@Transactional(readOnly = true)
	public List<SgPersonaDiscapacidad> getDiscapacidades(@PathVariable("id") Long id);
	@Modifying
	@Query(value = "delete from sg_personas_discapacidades pd where "
			+"pd.per_pk=:pk", nativeQuery = true)
	 @Transactional
	public void deleteDis(@PathVariable("pk") Long pk);
}
