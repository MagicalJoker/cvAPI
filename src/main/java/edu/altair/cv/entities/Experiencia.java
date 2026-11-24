package edu.altair.cv.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "experiencia")
public class Experiencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_experiencia")
	private Long idExperiencia;
	
	@Column(name = "nombre_empresa", nullable = false)
	private String nombreEmpresa;
	
	@Column(name = "fecha_comienzo", nullable = false)
	private LocalDate fechaComienzo;
	
	@Column(name = "fecha_finalizacion", nullable = false)
	private LocalDate fechaFinalizacion;
	
	@Column(name = "puesto", nullable = false)
	private String puesto;
	
	@Column(name = "descripcion", length = 300)
	private String descripcion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_alumno", foreignKey = @ForeignKey(name = "fk_experiencias_alumno"))
	private Alumno alumno;
	
	// Constructores
	
	public Experiencia() {};
	
	public Experiencia(Long idExperiencia, String nombreEmpresa, LocalDate fechaComienzo, LocalDate fechaFinalizacion,
			String puesto, String descripcion, Alumno alumno) {
		super();
		this.idExperiencia = idExperiencia;
		this.nombreEmpresa = nombreEmpresa;
		this.fechaComienzo = fechaComienzo;
		this.fechaFinalizacion = fechaFinalizacion;
		this.puesto = puesto;
		this.descripcion = descripcion;
		this.alumno = alumno;
	}
	
	// Getters & Setters
	
	public Long getIdExperiencia() {
		return idExperiencia;
	}

	public void setIdExperiencia(Long idExperiencia) {
		this.idExperiencia = idExperiencia;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public LocalDate getFechaComienzo() {
		return fechaComienzo;
	}

	public void setFechaComienzo(LocalDate fechaComienzo) {
		this.fechaComienzo = fechaComienzo;
	}

	public LocalDate getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(LocalDate fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
}
