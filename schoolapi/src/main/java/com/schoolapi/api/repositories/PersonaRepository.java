package com.schoolapi.api.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.schoolapi.api.entities.AllegadoDTO;
import com.schoolapi.api.entities.Persona;
import com.schoolapi.api.entities.TelefonoDTO;

import jakarta.transaction.Transactional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
	@Modifying
	@Query(value = "update centros_educativos.sg_personas set per_dui=:dui,per_primer_nombre=:primerNombre"
			+ ", per_segundo_nombre=:segundoNombre,per_primer_apellido=:primerApellido,"
			+ "per_segundo_apellido=:segundoApellido,per_fecha_nacimiento=:fecha,"
			+ "per_nacionalidad_fk=:nac,per_retornada=:ret," + "per_partida_nacimiento_posee=:partida,per_sexo_fk=:sex,"
			+ "per_etnia_fk=:etnia,per_tiene_diagnostico=:diagnostico,per_email=:email,"
			+ "per_tipo_trabajo_fk=:trabajo,per_estado_civil_fk=:civil,"
			+ "per_convivencia_fam_fk=:convivencia,per_embarazo=:embarazo,"
			+ "per_tiene_hijos=:tienehijos,per_cantidad_hijos=:cantidad" + " where per_pk=:id", nativeQuery = true)
	@Transactional
	Integer updatePasoDos(@PathVariable("dui") String dui, @PathVariable("primerNombre") String primerNombre,
			@PathVariable("segundoNombre") String segundoNombre, @PathVariable("primerApellido") String primerApellido,
			@PathVariable("segundoApellido") String segundoApellido, @PathVariable("nac") Long nac,
			@PathVariable("ret") Boolean ret, @PathVariable("partida") Boolean partida, @PathVariable("sex") Long sex,
			@PathVariable("etnia") Long etnia, @PathVariable("diagnostico") Boolean diagnostico,
			@PathVariable("email") String email, @PathVariable("trabajo") Long trabajo,
			@PathVariable("civil") Long civil, @PathVariable("convivencia") Integer convivencia,
			@PathVariable("embarazo") Boolean embarazo, @PathVariable("tienehijos") Boolean tienehijos,
			@PathVariable("cantidad") Integer cantidad, @PathVariable("fecha") LocalDate fecha,
			@PathVariable("id") Long id);

	@Modifying
	@Query(value = "update centros_educativos.sg_personas p set p.per_dui=:dui,p.per_primer_nombre=:primerNombre,"
			+ "p.per_segundo_nombre=:segundoNombre,p.per_primer_apellido=:primerApellido,"
			+ "p.per_segundo_apellido=:segundoApellido,p.per_email=:email,p.per_escolaridad_fk=:escolaridad", nativeQuery = true)
	Boolean updatePersonAllegado(@PathVariable("dui") String dui, @PathVariable("primerNombre") String primerNombre,
			@PathVariable("segundoNombre") String segundoNombre, @PathVariable("primerApellido") String primerApellido,
			@PathVariable("segundoApellido") String segundoApellido, @PathVariable("email") String email,
			@PathVariable("escolaridad") Integer escolaridad);

	@Modifying
	@Query(value = "update centros_educativos.sg_datos_residenciales_personas"
			+ " set per_tiene_servicio_basura=:basura, per_fuente_abastecimiento_agua_residencial"
			+ "=:agua,per_tiene_servicio_energia_electrica_residencial=:energia"
			+ " where per_pk=:id", nativeQuery = true)
	@Transactional
	Integer updatePasoCuatro(@PathVariable("basura") Boolean basura, @PathVariable("agua") Long agua,
			@PathVariable("energia") Boolean energia, @PathVariable("id") Long id);

	@Modifying
	@Query(value = "update centros_educativos.sg_personas set per_tipo_vivienda_fk=:tipo"
			+ " where per_pk=:id", nativeQuery = true)
	@Transactional
	Integer updateTipoVivienda(@PathVariable("tipo") Long tipo, @PathVariable("id") Long id);

	@Modifying
	@Query(value = "update centros_educativos.sg_personas set per_acceso_internet=:internet"
			+ " where per_pk=:id", nativeQuery = true)
	@Transactional
	Integer updateInternet(@PathVariable("internet") Boolean internet, @PathVariable("id") Long id);

	@Modifying
	@Query(value = "update centros_educativos.sg_datos_residenciales_personas"
			+ " set per_tiene_conexion_internet_residencial=:internet where " + "per_pk=:id", nativeQuery = true)
	@Transactional
	Integer updateInternetResidencial(@PathVariable("internet") Boolean internet, @PathVariable("id") Long id);

	@Modifying
	@Query(value = "update centros_educativos.sg_personas set per_dui=:dui,"
			+ "per_primer_nombre=:pnombre,per_segundo_nombre=:snombre,per_primer_apellido=:papellido,"
			+ "per_segundo_apellido=:sapellido,per_email=:email,per_escolaridad_fk=:escolaridad"
			+ " where per_pk=:id", nativeQuery = true)
	@Transactional
	Integer updatePasoSeis(@PathVariable("dui") String dui, @PathVariable("pnombre") String pnombre,
			@PathVariable("snombre") String snombre, @PathVariable("papellido") String papellido,
			@PathVariable("sapellido") String sapellido, @PathVariable("email") String email,
			@PathVariable("escolaridad") Integer escolaridad, @PathVariable("id") Long id);

	@Modifying
	@Query(value = "update centros_educativos.sg_allegados set all_tipo_parentesco=:"
			+ "parentesco where all_persona=:perpk", nativeQuery = true)
	@Transactional
	Integer updateParentesco(@PathVariable("parentesco") Long parentesco, @PathVariable("perpk") Long perpk);

	@Modifying
	@Query(value = "update centros_educativos.sg_personas set per_primer_nombre=:pnombre,"
			+ "per_segundo_nombre=:snombre,per_primer_apellido=:papellido,per_segundo_apellido"
			+ "=:sapellido,per_fecha_nacimiento=:pfecha,per_email=:email where per_pk=:id", nativeQuery = true)
	@Transactional
	Integer updatePerfil(@PathVariable("pnombre") String pnombre, @PathVariable("snombre") String snombre,
			@PathVariable("papellido") String papellido, @PathVariable("sapellido") String sapellido,
			@PathVariable("pfecha") LocalDate pfecha, @PathVariable("email") String email, @PathVariable("id") Long id);

	@Query(value = "select a.all_persona,all_pk,all_tipo_parentesco,p.per_pk,p.per_primer_nombre,"
			+ "p.per_segundo_nombre,p.per_primer_apellido,p.per_segundo_apellido,p.per_email,"
			+ "p.per_dui,p.per_escolaridad_fk from centros_educativos.sg_allegados a,centros_educativos.sg_personas p"
			+ " where a.all_persona_ref=:pk and p.per_pk=a.all_persona", nativeQuery = true)
	@Transactional
	public List<AllegadoDTO> getAllegados(@PathVariable("pk") Long pk);

	@Query(value = "select t.tel_pk,t.tel_telefono,t.tel_persona from centros_educativos.sg_telefonos "
			+ "t,centros_educativos.sg_personas p"
			+ " where t.tel_persona=:pk and p.per_pk=t.tel_persona", nativeQuery = true)
	@Transactional
	public List<TelefonoDTO> getTelefonosAllegado(@PathVariable("pk") Long pk);

	@Query(value = "select cae.cae_calificacion_fk,gra.gra_nombre,sec.sec_nombre,cpe.cpe_nombre,"
			+ " cae.cae_calificacion,ca.cal_seccion_fk,ca.cal_fecha from "
			+ " centros_educativos.sg_estudiantes est, centros_educativos.sg_personas per,"
			+ " centros_educativos.sg_calificaciones_estudiante cae,centros_educativos.sg_calificaciones ca,"
			+ " centros_educativos.sg_secciones sec,centros_educativos.sg_servicio_educativo sdu,"
			+ " centros_educativos.sg_grados gra,centros_educativos.sg_componente_plan_estudio cpe"
			+ " where ca.cal_pk=cae.cae_calificacion_fk and ca.cal_seccion_fk=sec.sec_pk"
			+ " and est.est_pk=cae.cae_estudiante_fk and per.per_nie=:nie and "
			+ "sdu.sdu_pk=sec.sec_servicio_educativo_fk and sdu.sdu_grado_fk=gra.gra_pk and "
			+ "ca.cal_componente_plan_estudio_fk=cpe.cpe_pk and cae.cae_calificacion is not NULL "
			+ " and per.per_pk=est.est_persona", nativeQuery = true)
	@Transactional
	public List<Map<String, Object>> getNotas(@PathVariable("nie") Long nie);

	@Query(value = "\n"
			+ "select cale.cae_calificacion_conceptual_fk,mat.mat_fecha_hasta,mat.mat_fecha_registro,"
			+ "cali.cal_rango_fecha_fk, cali.cal_tipo_periodo_calificacion, \n"
			+ "SEDE.SED_NOMBRE,per.per_primer_nombre,\n"
			+ "per.per_segundo_nombre,per.per_primer_apellido,per.per_segundo_apellido, per.per_pk,PER.PER_NIE, \n"
			+ "G.GRA_NOMBRE, MOE.MOD_NOMBRE,\n"
			+ "raf.rfe_codigo,cpe.cpe_nombre, cale.cae_calificacion\n"
			+ "from  centros_educativos.sg_matriculas mat\n"
			+ "left JOIN centros_educativos.sg_secciones SEC\n"
			+ "ON MAT.MAT_SECCION_FK=SEC.SEC_PK\n"
			+ "left JOIN centros_educativos.sg_servicio_educativo SEE\n"
			+ "ON SEC.SEC_SERVICIO_EDUCATIVO_FK=SEE.SDU_PK\n"
			+ "left JOIN centros_educativos.sg_grados G \n"
			+ "ON G.GRA_PK= SEE.SDU_GRADO_FK\n"
			+ "left JOIN centros_educativos.sg_rel_mod_ed_mod_aten MOD\n"
			+ "ON G.GRA_RELACION_MODALIDAD_FK=MOD.REA_PK\n"
			+ "left JOIN centros_educativos.sg_modalidades MOE\n"
			+ "ON MOD.REA_MODALIDAD_EDUCATIVA_FK=MOE.MOD_PK\n"
			+ "left JOIN centros_educativos.sg_sedes SEDE\n"
			+ "ON SEE.SDU_SEDE_FK=SEDE.SED_PK\n"
			+ "left JOIN centros_educativos.sg_estudiantes EST\n"
			+ "ON MAT.MAT_ESTUDIANTE_FK=EST.EST_PK\n"
			+ "left JOIN centros_educativos.sg_personas PER\n"
			+ "ON EST.EST_PERSONA=PER.PER_PK\n"
			+ "left join centros_educativos.sg_planes_estudio pes\n"
			+ "on sec.sec_plan_estudio_fk=pes.pes_pk\n"
			+ "left join centros_educativos.sg_calificaciones cali\n"
			+ "on sec.sec_pk=cali.cal_seccion_fk\n"
			+ "left join centros_educativos.sg_componente_plan_estudio cpe\n"
			+ "on cali.cal_componente_plan_Estudio_fk=cpe.cpe_pk\n"
			+ "left join centros_educativos.sg_calificaciones_estudiante cale\n"
			+ "on cali.cal_pk=cale.cae_calificacion_fk and est.est_pk=cale.cae_estudiante_fk\n"
			+ "left join centros_educativos.sg_rango_fecha raf\n"
			+ "on cali.cal_rango_fecha_fk=raf.rfe_pk\n"
			+ "where mat.mat_anulada= false and est.est_persona=per.per_pk and per.per_nie=:nie \n"
			+ "and mat.mat_estudiante_fk=est.est_pk", nativeQuery = true)
	public List<Map<String, Object>> getNotasv2(@PathVariable("nie") Long nie);

	@Query(value="select cpe.cpe_nombre,max(mat.mat_fecha_hasta),max(mat.mat_fecha_registro)\n"
			+ "from  centros_educativos.sg_matriculas mat\n"
			+ "left JOIN centros_educativos.sg_secciones SEC\n"
			+ "ON MAT.MAT_SECCION_FK=SEC.SEC_PK\n"
			+ "left JOIN centros_educativos.sg_servicio_educativo SEE\n"
			+ "ON SEC.SEC_SERVICIO_EDUCATIVO_FK=SEE.SDU_PK\n"
			+ "left JOIN centros_educativos.sg_grados G \n"
			+ "ON G.GRA_PK= SEE.SDU_GRADO_FK\n"
			+ "left JOIN centros_educativos.sg_estudiantes EST\n"
			+ "ON MAT.MAT_ESTUDIANTE_FK=EST.EST_PK\n"
			+ "left JOIN centros_educativos.sg_personas PER\n"
			+ "ON EST.EST_PERSONA=PER.PER_PK\n"
			+ "left join centros_educativos.sg_planes_estudio pes\n"
			+ "on sec.sec_plan_estudio_fk=pes.pes_pk\n"
			+ "left join centros_educativos.sg_calificaciones cali\n"
			+ "on sec.sec_pk=cali.cal_seccion_fk\n"
			+ "left join centros_educativos.sg_componente_plan_estudio cpe\n"
			+ "on cali.cal_componente_plan_Estudio_fk=cpe.cpe_pk\n"
			+ "left join centros_educativos.sg_calificaciones_estudiante cale\n"
			+ "on cali.cal_pk=cale.cae_calificacion_fk and est.est_pk=cale.cae_estudiante_fk\n"
			+ "where mat.mat_anulada= false and est.est_persona=per.per_pk and per.per_nie=:nie group by cpe.cpe_nombre\n"
			+ "",nativeQuery=true)
	public List<Map<String, Object>> getNotasMaterias(@PathVariable("nie") Long nie);
	@Query(value="select cal_valor,cal_pk from catalogo.sg_calificaciones",nativeQuery=true)
	public List<Map<String, Object>> getNotasNoNumericas();
}
