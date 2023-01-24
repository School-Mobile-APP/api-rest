package com.ficha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.ficha.model.SgPersonaTerapia;

public interface TerapiaRepository extends JpaRepository<SgPersonaTerapia, Long>{
	@Query(value = "select pt.per_pk,pt.ter_pk"
			+ " from centros_educativos.sg_personas_terapias pt" + " where pt.per_pk=:id", nativeQuery = true)
	@Transactional(readOnly = true)
	public List<SgPersonaTerapia> getTerapias(@PathVariable("id") Long id);
	@Modifying
	@Query(value = "delete from centros_educativos.sg_personas_terapias pt where "
			+"pt.per_pk=:pk", nativeQuery = true)
	 @Transactional
	public void deleteTer(@PathVariable("pk") Long pk);
}
