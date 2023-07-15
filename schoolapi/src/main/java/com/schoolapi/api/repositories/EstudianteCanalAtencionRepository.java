package com.schoolapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.schoolapi.api.entities.EstudianteCanal;

import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;

@Repository
public interface EstudianteCanalAtencionRepository extends JpaRepository<EstudianteCanal, Long>{
	@Modifying
	@Query(value = "delete from centros_educativos.sg_est_canales_atencion e"
			+ " where e.eca_estudiante_fk=:id",nativeQuery = true)
	@Transactional
	Integer deleteCanalesEstudiantes(@PathParam("id") Long id);

}
