package com.schoolapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.schoolapi.api.entities.PersonaDiscapacidad;

import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;

public interface PersonaDiscapacidadRepository extends JpaRepository<PersonaDiscapacidad, Long>{
	@Modifying
	@Query(value="delete from centros_educativos.sg_personas_discapacidades where per_pk=:id",nativeQuery = true)
	@Transactional
	Integer deleteDiscapacidad(@PathParam("id") Long id);
}
