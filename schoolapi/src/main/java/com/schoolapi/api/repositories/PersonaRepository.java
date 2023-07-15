package com.schoolapi.api.repositories;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.schoolapi.api.entities.Persona;

import jakarta.transaction.Transactional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
	//falta fecha
	@Modifying
	@Query(value="update centros_educativos.sg_personas set per_dui=:dui,per_primer_nombre=:primerNombre"
			+ ", per_segundo_nombre=:segundoNombre,per_primer_apellido=:primerApellido,"
			+ "per_segundo_apellido=:segundoApellido,per_fecha_nacimiento=:fecha,"
			+ "per_nacionalidad_fk=:nac,per_retornada=:ret,"
			+ "per_partida_nacimiento_posee=:partida,per_sexo_fk=:sex,"
			+ "per_etnia_fk=:etnia,per_tiene_diagnostico=:diagnostico,per_email=:email,"
			+ "per_tipo_trabajo_fk=:trabajo,per_estado_civil_fk=:civil,"
			+ "per_convivencia_fam_fk=:convivencia,per_embarazo=:embarazo,"
			+ "per_tiene_hijos=:tienehijos,per_cantidad_hijos=:cantidad"
			+ " where per_pk=:id",nativeQuery = true)
	@Transactional
	Integer updatePasoDos(@PathVariable("dui") String dui,@PathVariable("primerNombre") String primerNombre,@PathVariable("segundoNombre") String segundoNombre,
			@PathVariable("primerApellido")String primerApellido,@PathVariable("segundoApellido") String segundoApellido,
			@PathVariable("nac") Long nac,@PathVariable("ret") Boolean ret,@PathVariable("partida") Boolean partida,
			@PathVariable("sex") Long sex,@PathVariable("etnia") Long etnia,@PathVariable("diagnostico") Boolean diagnostico,
			@PathVariable("email") String email,@PathVariable("trabajo") Long trabajo,
			@PathVariable("civil") Long civil,@PathVariable("convivencia") Integer convivencia,
			@PathVariable("embarazo")Boolean embarazo,@PathVariable("tienehijos") Boolean tienehijos,
			@PathVariable("cantidad") Integer cantidad,@PathVariable("fecha") LocalDate fecha,
			@PathVariable("id") Long id);
	@Modifying
	@Query(value="update centros_educativos.sg_personas p set p.per_dui=:dui,p.per_primer_nombre=:primerNombre,"
			+ "p.per_segundo_nombre=:segundoNombre,p.per_primer_apellido=:primerApellido,"
			+ "p.per_segundo_apellido=:segundoApellido,p.per_email=:email,p.per_escolaridad_fk=:escolaridad",nativeQuery = true)
	Boolean updatePersonAllegado(@PathVariable("dui") String dui,@PathVariable("primerNombre") String primerNombre,
			@PathVariable("segundoNombre") String segundoNombre,@PathVariable("primerApellido")String primerApellido,
			@PathVariable("segundoApellido") String segundoApellido,@PathVariable("email") String email,@PathVariable("escolaridad")Integer escolaridad);
	@Modifying
	@Query(value ="update centros_educativos.sg_datos_residenciales_personas"
			+ " set per_tiene_servicio_basura=:basura, per_fuente_abastecimiento_agua_residencial"
			+ "=:agua,per_tiene_servicio_energia_electrica_residencial=:energia"
			+ " where per_pk=:id",nativeQuery = true)
	@Transactional
	Integer updatePasoCuatro(@PathVariable("basura") Boolean basura,@PathVariable("agua") Long agua,
			@PathVariable("energia") Boolean energia,@PathVariable("id") Long id);
	@Modifying
	@Query(value="update centros_educativos.sg_personas set per_acceso_internet=:internet"
			+ " where per_pk=:id",nativeQuery = true)
	@Transactional
	Integer updateInternet(@PathVariable("internet") Boolean internet, @PathVariable("id") Long id);
	@Modifying
	@Query(value="update centros_educativos.sg_datos_residenciales_personas"
			+ " set per_tiene_conexion_internet_residencial=:internet where "
			+ "per_pk=:id",nativeQuery = true)
	@Transactional
	Integer updateInternetResidencial(@PathVariable("internet") Boolean internet,@PathVariable("id") Long id);
	@Modifying
	@Query(value="update centros_educativos.sg_personas set per_dui=:dui,"
			+ "per_primer_nombre=:pnombre,per_segundo_nombre=:snombre,per_primer_apellido=:papellido,"
			+ "per_segundo_apellido=:sapellido,per_email=:email,per_escolaridad_fk=:escolaridad"
			+ " where per_pk=:id",nativeQuery = true)
	@Transactional
	Integer updatePasoSeis(@PathVariable("dui")String dui,@PathVariable("pnombre") String pnombre,
			@PathVariable("snombre") String snombre, @PathVariable("papellido")String papellido,
			@PathVariable("sapellido") String sapellido,@PathVariable("email") String email,
			@PathVariable("escolaridad") Integer escolaridad,@PathVariable("id") Long id);
	@Modifying
	@Query(value="update centros_educativos.sg_allegados set all_tipo_parentesco=:"
			+ "parentesco where all_persona=:perpk",nativeQuery = true)
	@Transactional
	Integer updateParentesco(@PathVariable("parentesco") Long parentesco,@PathVariable("perpk") Long perpk);
	@Modifying
	@Query(value="update centros_educativos.sg_personas set per_primer_nombre=:pnombre,"
			+ "per_segundo_nombre=:snombre,per_primer_apellido=:papellido,per_segundo_apellido"
			+ "=:sapellido,per_fecha_nacimiento=:pfecha,per_email=:email where per_pk=:id",nativeQuery = true)
	@Transactional
	Integer updatePerfil(@PathVariable("pnombre")String pnombre,@PathVariable("snombre") String snombre,
			@PathVariable("papellido")String papellido,@PathVariable("sapellido") String sapellido,
			@PathVariable("pfecha")LocalDate pfecha,@PathVariable("email") String email,@PathVariable("id") Long id);
}
