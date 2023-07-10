package com.schoolapi.api.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.schoolapi.api.entities.Persona;

import jakarta.transaction.Transactional;

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
	Boolean updatePersonStepTwo(@PathVariable("dui") String dui,@PathVariable("primerNombre") String primerNombre,@PathVariable("segundoNombre") String segundoNombre,
			@PathVariable("primerApellido")String primerApellido,@PathVariable("segundoApellido") String segundoApellido,
			@PathVariable("nac") Integer nac,@PathVariable("ret") Boolean ret,@PathVariable("partida") Boolean partida,
			@PathVariable("sex") Integer sex,@PathVariable("etn") Integer etn,@PathVariable("diagnostico") Boolean diagnostico,
			@PathVariable("email") String email,@PathVariable("trabajo") Integer trabajo,
			@PathVariable("civil") Integer civil,@PathVariable("convivencia") Integer convivencia,
			@PathVariable("embarazo")Boolean embarazo,@PathVariable("tienehijos") Boolean tienehijos,
			@PathVariable("cantidad") Integer cantidad,@PathVariable("id") Integer id);
	@Modifying
	@Query(value="update centros_educativos.sg_personas p set p.per_dui=:dui,p.per_primer_nombre=:primerNombre,"
			+ "p.per_segundo_nombre=:segundoNombre,p.per_primer_apellido=:primerApellido,"
			+ "p.per_segundo_apellido=:segundoApellido,p.per_email=:email,p.per_escolaridad_fk=:escolaridad",nativeQuery = true)
	Boolean updatePersonAllegado(@PathVariable("dui") String dui,@PathVariable("primerNombre") String primerNombre,
			@PathVariable("segundoNombre") String segundoNombre,@PathVariable("primerApellido")String primerApellido,
			@PathVariable("segundoApellido") String segundoApellido,@PathVariable("email") String email,@PathVariable("escolaridad")Integer escolaridad);
	@Modifying
	@Query(value ="update centros_educativos.sg_datos_residenciales_personas dp"
			+ " set dp.per_tiene_servicio_basura=:basura, dp.per_fuente_abastecimiento_agua_residencial"
			+ "=:agua,dp.per_tiene_servicio_energia_electrica_residencial=:energia"
			+ " where dp.per_pk=:id",nativeQuery = true)
	boolean updateStepFour(@PathVariable("basura") Boolean basura,@PathVariable("agua") Long agua,
			@PathVariable("energia") Boolean energia,@PathVariable("id") Long id);
	@Modifying
	@Query(value="update centros_educativos.sg_personas p set p.per_acceso_internet=:internet"
			+ " where p.per_pk=:id",nativeQuery = true)
	boolean updateInternet(@PathVariable("internet") Boolean internet, @PathVariable("id") Long id);
	@Modifying
	@Query(value="update centros_educativos.sg_datos_residenciales_personas dp"
			+ " set dp.per_tiene_conexion_internet_residencial=:internet where "
			+ "dp.per_pk=:id",nativeQuery = true)
	boolean updateInternetResidencial(@PathVariable("internet") Boolean internet,@PathVariable("id") Long id);
	@Modifying
	@Query(value="update centros_educativos.sg_personas p set p.per_dui=:dui,p.per_primer_nombre=:"
			+ "pnombre,p.per_segundo_nombre=:snombre,p.per_primer_apellido=:papellido,"
			+ "p.per_segundo_apellido=:sapellido,p.per_email=:email,p.per_escolaridad_fk=:escolaridad"
			+ " where p.per_pk=:id",nativeQuery = true)
	boolean updatePasoSeis(@PathVariable("dui")String dui,@PathVariable("pnombre") String pnombre,
			@PathVariable("snombre") String snombre, @PathVariable("papellido")String papellido,
			@PathVariable("sapellido") String sapellido,@PathVariable("email") String email,
			@PathVariable("escolaridad") Integer escolaridad,@PathVariable("id") Integer id);
	@Modifying
	@Query(value="update centros_educativos.sg_allegados a set a.all_tipo_parentesco=:"
			+ "parentesco where a.all_persona_ref=:perpk",nativeQuery = true)
	boolean updateParentesco(@PathVariable("parentesco") Integer parentesco,@PathVariable("perpk") Integer perpk);
	@Modifying
	@Query(value="update centros_educativos.sg_personas set per_primer_nombre=:pnombre,"
			+ "per_segundo_nombre=:snombre,per_primer_apellido=:papellido,per_segundo_apellido"
			+ "=:sapellido,per_fecha_nacimiento=:pfecha,per_email=:email where per_pk=:id",nativeQuery = true)
	@Transactional
	Integer updatePerfil(@PathVariable("pnombre")String pnombre,@PathVariable("snombre") String snombre,
			@PathVariable("papellido")String papellido,@PathVariable("sapellido") String sapellido,
			@PathVariable("pfecha")LocalDate pfecha,@PathVariable("email") String email,@PathVariable("id") Long id);
}
