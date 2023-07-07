package com.schoolapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.schoolapi.api.entities.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long>{
	@Modifying
	@Query(value="update centros_educativos.sg_estudiantes e set e.est_rec_clases_multimodalidad_fk=:"
			+ "mul, e.est_sintoniza_canal_10=:canal",nativeQuery = true)
	boolean updateEstudiante(@Param("mul")Long mul,@Param("canal") Boolean canal);
}
