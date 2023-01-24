package com.ficha.repository;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.ficha.dto.SgPersonaDto;
import com.ficha.model.SgPersona;
import com.ficha.model.SgPersonaDiscapacidad;
public interface PersonaRepository extends JpaRepository<SgPersona, Long>{
	@Query(value = "select pd.per_pk,pd.dis_pk "
			+ "from centros_educativos.sg_personas_discapacidades pd"
			+ " where pd.per_pk=:id", nativeQuery = true)
	List<SgPersonaDiscapacidad> getDiscapacidades(@PathVariable("id") Long id);
	@Modifying
	@Query(value = "update centros_educativos.sg_personas set per_tipo_vivienda_fk=:viv where per_pk=:id"
			, nativeQuery = true)
	@Transactional
	Integer updateTipoVivienda(@PathVariable("perTipoVivienda") Long viv, @PathVariable("id") Long id);
	@Modifying	
	@Query(value = "update centros_educativos.sg_personas set per_dui=:dui, per_primer_nombre=:primer"
			+ ",per_segundo_nombre=:segundo, per_primer_apellido=:primera,"
			+ " per_segundo_apellido=:segundoa, per_fecha_nacimiento=:fecha, per_nacionalidad_fk=:nac,"
			+ "per_retornada=:ret, per_partida_nacimiento_presenta=:partida"
			+ ",per_etnia_fk=:etnia,per_tiene_diagnostico=:diagnostico, per_email=:email"
			+ ", per_tiene_whatsapp=:whatsapp, per_tipo_trabajo_fk=:trabajo,"
			+ "per_estado_civil_fk=:civil, per_embarazo=:embarazo, per_tiene_hijos=:hijos,"
			+ "per_cantidad_hijos=:cantidad,per_sexo_fk=:sexo, per_convivencia_fam_fk=:convivencia"
			+ " where per_pk=:id"
			, nativeQuery = true)
	@Transactional
	Integer updatePasoDos(@PathVariable("dui") String dui,@PathVariable("primer") String primer,
			@PathVariable("segundo") String segundo,@PathVariable("primera") String primera,
			@PathVariable("segundoa") String segundoa, @PathVariable("fecha") LocalDate fecha,
			@PathVariable("nac") Long nac,@PathVariable("ret") Boolean ret,
			@PathVariable("partida") Boolean partida,@PathVariable("etnia") Long etnia,
			@PathVariable("diagnostico") Boolean diagnostico,@PathVariable("email") String email,
			@PathVariable("whatsapp") Boolean whatsapp,	@PathVariable("trabajo") Long trabajo,
			@PathVariable("civil") Long civil,@PathVariable("embarazo") Boolean embarazo,
			@PathVariable("hijos") Boolean hijos,@PathVariable("cantidad") Integer cantidad,
			@PathVariable("sexo") Long sexo,@PathVariable("convivencia") Integer convivencia,
			@PathVariable("id") Long id);
	@Modifying	
	@Query(value = "update centros_educativos.sg_personas set per_acceso_internet=:internet where per_pk=:id"
			, nativeQuery = true)
	@Transactional
	Integer updateAccesoInternet(@PathVariable("internet") Boolean internet, @PathVariable("id") Long id);
	@Query(value = "select p.per_dui,p.per_primer_nombre,p.per_primer_apellido,"
			+ "p.per_segundo_nombre, p.per_segundo_apellido,per_email,per_escolaridad_fk"
			+ " " + " from centros_educativos.sg_personas p"
			+ " where p.per_pk=:id", nativeQuery = true)
	@Transactional(readOnly = true)
	public SgPersonaDto getPersona(@PathVariable("id") Long id);
	
	@Modifying	
	@Query(value = "update centros_educativos.sg_personas set per_primer_nombre=:primer"
			+ ",per_segundo_nombre=:segundo, per_primer_apellido=:primera,"
			+ " per_segundo_apellido=:segundoa, per_fecha_nacimiento=:fecha"
			+ ",per_email=:email"
			+ " where per_pk=:id"
			, nativeQuery = true)
	@Transactional
	Integer updatePerfil(@PathVariable("primer") String primer,
			@PathVariable("segundo") String segundo,@PathVariable("primera") String primera,
			@PathVariable("segundoa") String segundoa, @PathVariable("fecha") LocalDate fecha,
			@PathVariable("email") String email,
			@PathVariable("id") Long id);
	
}
