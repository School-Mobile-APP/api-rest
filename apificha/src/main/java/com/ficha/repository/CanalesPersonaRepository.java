package com.ficha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.ficha.model.SgEstCanalesAtencion;
import com.ficha.dto.SgCanalesEst;

public interface CanalesPersonaRepository extends JpaRepository<SgEstCanalesAtencion,Long>{
	
	@Query(value = "select ce.eca_pk,ce.eca_canal_fk"
			+ " from sg_est_canales_atencion ce" + " where ce.eca_estudiante_fk=:id", nativeQuery = true)
	@Transactional(readOnly = true)
	public List<SgCanalesEst> getPersonaCanales(@PathVariable("id") Long id);
	@Modifying
	@Query(value = "delete from sg_est_canales_atencion ec where "
			+"ec.eca_estudiante_fk=:pk", nativeQuery = true)
	 @Transactional
	public void deleteCanales(@PathVariable("pk") Long pk);
}
