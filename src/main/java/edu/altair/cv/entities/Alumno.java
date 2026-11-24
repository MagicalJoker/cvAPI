package edu.altair.cv.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "alumno")
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_alumno")
	private Long idAlumno;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "apellido_1", nullable = false)
	private String apellido1;

	@Column(name = "apellido_2", nullable = false)
	private String apellido2;

	@Column(name = "email_personal")
	private String emailPersonal;

	@Column(name = "telefono_personal")
	private String telefonoPersonal;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "ciclo", nullable = false)
	private String ciclo;

	@Column(name = "curso", nullable = false)
	private String curso;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_vehiculo", foreignKey = @ForeignKey(name = "fk_vehiculo_idVehiculo"))
	private Vehiculo vehiculo;

	// Constructores

	public Alumno() {
	};

	public Alumno(Long idAlumno, String nombre, String apellido1, String apellido2, String emailPersonal,
			String telefonoPersonal, String direccion, String ciclo, String curso, Vehiculo vehiculo) {
		super();
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.emailPersonal = emailPersonal;
		this.telefonoPersonal = telefonoPersonal;
		this.direccion = direccion;
		this.ciclo = ciclo;
		this.curso = curso;
		this.vehiculo = vehiculo;
	}

	// Getters & Setters

	public Long getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Long idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getEmailPersonal() {
		return emailPersonal;
	}

	public void setEmailPersonal(String emailPersonal) {
		this.emailPersonal = emailPersonal;
	}

	public String getTelefonoPersonal() {
		return telefonoPersonal;
	}

	public void setTelefonoPersonal(String telefonoPersonal) {
		this.telefonoPersonal = telefonoPersonal;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

}
