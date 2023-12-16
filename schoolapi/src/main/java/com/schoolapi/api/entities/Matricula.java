package com.schoolapi.api.entities;
import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
// representa la tabla matriculas
@Entity
@Table(name="sg_matriculas",schema="centros_educativos")
public class Matricula implements Serializable{
	public Long getMatPk() {
		return matPk;
	}
	public void setMatPk(Long matPk) {
		this.matPk = matPk;
	}
	public String getMatEstado() {
		return matEstado;
	}
	public void setMatEstado(String matEstado) {
		this.matEstado = matEstado;
	}
	public Date getMatFechaRegistro() {
		return matFechaRegistro;
	}
	public void setMatFechaRegistro(Date matFechaRegistro) {
		this.matFechaRegistro = matFechaRegistro;
	}
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="mat_pk")
	private Long matPk;
	@Column(name="mat_estado")
	private String matEstado;
	@Column(name="mat_fecha_registro")
	private Date matFechaRegistro;
	@Column(name="mat_estudiante_fk")
	private Long matEstudianteFk;
	@Column(name="mat_promocion_grado")
	private String matPromocionGrado;
	public String getMatPromocionGrado() {
		return matPromocionGrado;
	}
	public void setMatPromocionGrado(String matPromocionGrado) {
		this.matPromocionGrado = matPromocionGrado;
	}
	public Long getMatEstudianteFk() {
		return matEstudianteFk;
	}
	public void setMatEstudianteFk(Long matEstudianteFk) {
		this.matEstudianteFk = matEstudianteFk;
	}
	@Column(name="mat_fecha_hasta")
	private Date matFechaHasta; 
	public Date getMatFechaHasta() {
		return matFechaHasta;
	}
	public void setMatFechaHasta(Date matFechaHasta) {
		this.matFechaHasta = matFechaHasta;
	}
	public Seccion getSeccion() {
		return seccion;
	}
	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}
	@OneToOne
	@JoinColumn(name="mat_seccion_fk")
	private Seccion seccion;
}
