package com.schoolapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.schoolapi.api.entities.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
	//falta fecha
	@Modifying
	@Query(value="update centros_educativos.sg_personas p set p.per_dui=:dui,p.per_primer_nombre=:primerNombre"
			+ ", p.per_segundo_nombre=:segundoNombre,p.per_primer_apellido=:primerApellido,"
			+ "p.per_segundo_apellido=:segundoApellido,p.per_fecha_nacimiento=:fecha,"
			+ "p.per_nac_fk=:nac,p.per_retornada=:ret,"
			+ "p.per_partida_nacimiento_posee=:partida,p.per_sexo_fk=:sex,"
			+ "p.per_etnia_fk=:etnia,p.per_tiene_diagnostico=:diagnostico,p.per_email=:email,"
			+ "p.per_tipo_trabajo_fk=:trabajo,p.per_estado_civil_fk=:civil,"
			+ "p.per_convivencia_familiar_fk=:convivencia,p.per_embarazo=:embarazo,"
			+ "p.per_tiene_hijos=:tienehijos,p.per_cantidad_hijos=:cantidad"
			+ " where p.per_pk=:id",nativeQuery = true)
	Boolean updatePersonStepTwo(@Param("dui") String dui,@Param("primerNombre") String primerNombre,@Param("segundoNombre") String segundoNombre,
			@Param("primerApellido")String primerApellido,@Param("segundoApellido") String segundoApellido,
			@Param("nac") Integer nac,@Param("ret") Boolean ret,@Param("partida") Boolean partida,
			@Param("sex") Integer sex,@Param("etn") Integer etn,@Param("diagnostico") Boolean diagnostico,
			@Param("email") String email,@Param("trabajo") Integer trabajo,
			@Param("civil") Integer civil,@Param("convivencia") Integer convivencia,
			@Param("embarazo")Boolean embarazo,@Param("tienehijos") Boolean tienehijos,
			@Param("cantidad") Integer cantidad,@Param("id") Integer id);
	@Modifying
	@Query(value="update centros_educativos.sg_personas p set p.per_dui=:dui,p.per_primer_nombre=:primerNombre,"
			+ "p.per_segundo_nombre=:segundoNombre,p.per_primer_apellido=:primerApellido,"
			+ "p.per_segundo_apellido=:segundoApellido,p.per_email=:email,p.per_escolaridad_fk=:escolaridad",nativeQuery = true)
	Boolean updatePersonAllegado(@Param("dui") String dui,@Param("primerNombre") String primerNombre,
			@Param("segundoNombre") String segundoNombre,@Param("primerApellido")String primerApellido,
			@Param("segundoApellido") String segundoApellido,@Param("email") String email,@Param("escolaridad")Integer escolaidad);
	@Modifying
	@Query(value ="update centros_educativos.sg_datos_residenciales_personas dp"
			+ " set dp.per_tiene_servicio_basura:=basura, dp.per_fuente_abastecimiento_agua_residencial"
			+ ":=agua,dp.per_tiene_servicio_energia_electrica_residencial=:energia"
			+ " where dp.per_pk=:",nativeQuery = true)
	boolean updateStepFour(@Param("basura") Boolean basura,@Param("agua") Long agua,
			@Param("energia") Boolean energia,@Param("id") Long id);
}
