package edu.altair.cv.entities;

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
@Table(name = "aptitud")
public class Aptitud {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_aptitudes")
	private Long idAptitudes;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "descripcion", length = 200)
	private String descripcion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_alumno", foreignKey = @ForeignKey(name = "fk_aptitudes_alumno"))
	private Alumno alumno;

	// Constructores

	public Aptitud() {
	};

	public Aptitud(Long idAptitudes, String nombre, String descripcion, Alumno alumno) {
		super();
		this.idAptitudes = idAptitudes;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.alumno = alumno;
	}

	// Getters & Setters

	public Long getIdAptitudes() {
		return idAptitudes;
	}

	public void setIdAptitudes(Long idAptitudes) {
		this.idAptitudes = idAptitudes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
