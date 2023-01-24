package com.ficha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import com.ficha.model.SgDatosResidencialesPersona;
import com.ficha.dto.SgFichaDatosCuatro;

public interface DatosPasoCuatroRepository extends JpaRepository<SgDatosResidencialesPersona,Long>{
	@Query(value = "select r.per_tiene_servicio_energia_electrica_residencial,"
			+ " r.per_tiene_servicio_basura,r.per_fuente_abastecimiento_agua_residencial,"
			+ " r.per_tiene_conexion_internet_residencial"
			+ " from centros_educativos.sg_datos_residenciales_personas r" + " where r.per_pk=:id", nativeQuery = true)
	@Transactional(readOnly = true)
	public SgFichaDatosCuatro getFichaDatosPasoCuatro(@PathVariable("id") Long id);
}	
