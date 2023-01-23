package com.ficha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.ficha.model.SgDireccion;

public interface DireccionRepository extends JpaRepository<SgDireccion, Long> {
	@Modifying
	@Query(value = "update sg_direcciones set dir_caserio_texto=:catexto, dir_departamento=:depto"
			+ " ,dir_municipio=:mun, dir_direccion=:dirDireccion, dir_zona=:dirzona, dir_canton=:dircanton where dir_pk=:id"
			, nativeQuery = true)
	@Transactional
	Integer updateDir(@PathVariable("dirCaserioTexto") String catexto, @PathVariable("dirDepartamento") Long depto,
			@PathVariable("dirMunicipio") Long mun, @PathVariable("dirDireccion") String dirDireccion,
			@PathVariable("dirZona") Long dirzona,@PathVariable("dirCanton") Long dircanton, @PathVariable("id") Long id);
}
