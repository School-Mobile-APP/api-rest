package com.ficha.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import com.ficha.model.SgPersona;
import com.ficha.dto.SgFichaDatos;

public interface DatosFichaRepository extends JpaRepository<SgPersona, Long> {

	@Query(value = "select p.per_tiene_whatsapp,p.per_convivencia_fam_fk,p.per_tipo_vivienda_fk"
			+ " from sg_personas p" + " where p.per_pk=:id", nativeQuery = true)
	@Transactional(readOnly = true)
	public SgFichaDatos getFichaDatosPasoDos(@PathVariable("id") Long id);
}
