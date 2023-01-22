package com.ficha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.ficha.model.SgDatosResidencialesPersona;

public interface DatosResidencialesRepository extends JpaRepository<SgDatosResidencialesPersona,Long>{
	@Modifying	
	@Query(value = "update sg_datos_residenciales_personas set per_tiene_conexion_internet_residencial=:internet where per_pk=:id"
			, nativeQuery = true)
	@Transactional
	Integer updateAccesoInternet(@PathVariable("internet") Boolean internet, @PathVariable("id") Long id);
}
