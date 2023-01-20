package com.ficha.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.ficha.dto.SgModalidadesEst;
import com.ficha.model.SgMultiModalidad;
public interface ModalidadPersonaRepository extends JpaRepository<SgMultiModalidad,Long> {
	@Query(value = "select e.est_rec_clases_multimodalidad_fk"
			+ " from sg_estudiantes e" + " where e.est_pk=:id", nativeQuery = true)
	@Transactional(readOnly = true)
	public SgModalidadesEst getModalidadPersona(@PathVariable("id") Long id);
}
