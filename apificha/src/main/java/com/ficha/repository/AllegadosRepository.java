package com.ficha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import com.ficha.dto.SgAllegadoDto;
import com.ficha.model.SgAllegado;

public interface AllegadosRepository extends JpaRepository<SgAllegado, Long> {
	@Query(value = "select a.all_pk, a.all_persona, a.all_tipo_parentesco, a.all_persona_ref" + " from "
			+ "centros_educativos.sg_allegados a"
			+ " where a.all_persona=:id", nativeQuery = true)
	@Transactional(readOnly = true)
	public SgAllegadoDto getAllegado(@PathVariable("id") Long id);
}
