package com.schoolapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.schoolapi.api.entities.PersonaElementoHogarPk;

import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;

@Repository
public interface PersonaElementosHogarRepository extends JpaRepository<PersonaElementoHogarPk, Long> {
	//Elimina los elementos del hogar de la persona
	@Modifying
	@Query(value="delete from centros_educativos.sg_personas_elementos_hogar where per_pk=:id",nativeQuery = true)
	@Transactional
	Integer deleteElementos(@PathParam("id") Long id);
}
