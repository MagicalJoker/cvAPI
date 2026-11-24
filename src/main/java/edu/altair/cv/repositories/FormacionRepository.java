package edu.altair.cv.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.cv.entities.Alumno;
import edu.altair.cv.entities.Formacion;

@Repository
public interface FormacionRepository extends JpaRepository<Formacion, Long> {
	
	// Métodos derivados para la info de Formacion
	
	boolean existsByNombreTitulación(String nombreTitulación);
	boolean existsByFecha(LocalDate fecha);
	boolean existsByAlumno(Alumno alumno);
	
	List<Formacion> findByNombreTitulación(String nombreTitulación);
	List<Formacion> findByFecha(LocalDate fecha);
	List<Formacion> findByAlumno(Alumno alumno);
	
}