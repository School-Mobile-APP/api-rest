package com.schoolapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.schoolapi.api.entities.Telefono;

import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;

@Repository
public interface TelefonoRepository extends JpaRepository<Telefono,Long> {
	//Elimina los telefonos de las personas
	@Modifying
	@Query(value="delete from centros_educativos.sg_telefonos where sg_telefonos.tel_persona=:id",nativeQuery = true)
	@Transactional
	Integer deleteTelefono(@PathParam("id") Long id);
}
