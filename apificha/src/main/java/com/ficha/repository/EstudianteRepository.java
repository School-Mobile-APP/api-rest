package com.ficha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.ficha.model.SgEstudiante;

public interface EstudianteRepository extends JpaRepository<SgEstudiante, Long> {
	@Modifying
	@Query(value = "update centros_educativos.sg_estudiantes set est_sintoniza_canal_10=:diez,"
			+ " est_rec_clases_multimodalidad_fk=:modalidad where est_pk=:id", nativeQuery = true)
	@Transactional
	Integer updatePasoCinco(@PathVariable("diez") Boolean diez, @PathVariable("modalidad") Long modalidad,
			@PathVariable("id") Long id);
}
