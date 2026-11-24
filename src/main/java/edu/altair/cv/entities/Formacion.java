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
@Table(name = "formacion")
public class Formacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_formacion")
	private Long idFormacion;

	@Column(name = "nombre_titulacion", nullable = false, length = 50)
	private String nombreTitulación;

	@Column(name = "fecha", nullable = false)
	private LocalDate fecha;

	@Column(name = "descripcion", length = 300)
	private String descripcion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_alumno", foreignKey = @ForeignKey(name = "fk_formaciones_alumno"))
	private Alumno alumno;

	// Constructores

	public Formacion() {
	};

	public Formacion(Long idFormacion, String nombreTitulación, LocalDate fecha, String descripcion, Alumno alumno) {
		super();
		this.idFormacion = idFormacion;
		this.nombreTitulación = nombreTitulación;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.alumno = alumno;
	}

	// Getters & Setters

	public Long getIdFormacion() {
		return idFormacion;
	}

	public void setIdFormacion(Long idFormacion) {
		this.idFormacion = idFormacion;
	}

	public String getNombreTitulación() {
		return nombreTitulación;
	}

	public void setNombreTitulación(String nombreTitulación) {
		this.nombreTitulación = nombreTitulación;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
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
