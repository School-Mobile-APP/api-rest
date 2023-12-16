package com.schoolapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.schoolapi.api.entities.Direccion;

import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;

public interface DireccionRepository extends JpaRepository<Direccion, Long> {
	//Actualiza los datos de direccion basado en el id de la direccion
	@Modifying
	@Query(value="update centros_educativos.sg_direcciones "
			+ "set dir_direccion=:direccion, dir_municipio=:municipio,"
			+ " dir_departamento=:departamento, dir_caserio_texto=:caserio,"
			+ " dir_zona=:zona where dir_pk=:id",nativeQuery = true)
	@Transactional
	Integer updateDireccion(@PathParam("direccion")String direccion,@PathParam("municipio") Long municipio,
			@PathParam("departamento") Long departamento, @PathParam("caserio") String caserio,
			@PathParam("zona")Long zona,@PathParam("id")Long id);
	//Actualiza el fk del canton 
	@Modifying
	@Query(value = "update centros_educativos.sg_direcciones set "
			+ "dir_canton=:can where dir_pk=:id",nativeQuery = true)
	@Transactional
	Integer updateCanton(@PathParam("can") Long can, @PathParam("id") Long id);
}
