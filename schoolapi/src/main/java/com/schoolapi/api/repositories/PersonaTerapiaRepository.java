package com.schoolapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.schoolapi.api.entities.PersonaTerapia;

import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;

@Repository
public interface PersonaTerapiaRepository extends JpaRepository<PersonaTerapia, Long> {
	//Elimina las terapias de la persona
	@Modifying
	@Query(value="delete from centros_educativos.sg_personas_terapias where per_pk=:id",nativeQuery = true)
	@Transactional
	Integer deleteTerapia(@PathParam("id") Long id);
}
