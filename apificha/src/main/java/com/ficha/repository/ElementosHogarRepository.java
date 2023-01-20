package com.ficha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.ficha.model.SgPersonaElemento;

public interface ElementosHogarRepository extends JpaRepository<SgPersonaElemento, Long> {
	@Query(value = "select eh.per_pk,eh.eho_pk" + " from sg_personas_elementos_hogar eh"
			+ " where eh.per_pk=:id", nativeQuery = true)
	@Transactional(readOnly = true)
	public List<SgPersonaElemento> getElementos(@PathVariable("id") Long id);

	// Pueda que necesite un delete con el id especifico del elemento
	@Modifying
	@Query(value = "delete from sg_personas_discapacidades pd where " + "pd.per_pk=:pk", nativeQuery = true)
	@Transactional
	public void deleteDis(@PathVariable("pk") Long pk);
}
