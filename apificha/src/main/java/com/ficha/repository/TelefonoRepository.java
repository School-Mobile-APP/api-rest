package com.ficha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import com.ficha.model.SgTelefono;

public interface TelefonoRepository extends JpaRepository<SgTelefono, Long> {
	@Query(value = "select *" + " from centros_educativos.sg_telefonos" + " where tel_persona=:id", nativeQuery = true)
	@Transactional(readOnly = true)
	public List<SgTelefono> getTelefonos(@PathVariable("id") Long id);

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO centros_educativos.sg_telefonos (tel_telefono, tel_persona) VALUES(?1,?2)"
	, nativeQuery = true)
	public Integer inserTelefono(String telefono, int persona);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE centros_educativos.sg_telefonos set tel_persona=:persona, tel_telefono=:telefono"
			+ " where tel_pk=:id"
	, nativeQuery = true)
	public Integer updateTelefono(@PathVariable("persona") int persona, @PathVariable("telefono") String telefono,
			@PathVariable("id") Long id);
	@Modifying
	@Query(value = "delete from centros_educativos.sg_telefonos t where "
			+"t.tel_persona=:pk", nativeQuery = true)
	 @Transactional
	public void deleteTel(@PathVariable("pk") Long pk);
}
