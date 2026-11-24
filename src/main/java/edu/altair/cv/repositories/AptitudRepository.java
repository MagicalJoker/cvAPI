package edu.altair.cv.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.cv.entities.Alumno;
import edu.altair.cv.entities.Aptitud;

@Repository
public interface AptitudRepository extends JpaRepository<Aptitud, Long> {
	
	// Métodos derivados para la info de Aptitud
	
	boolean existsByNombre(String nombre);
	boolean existsByAlumno(Alumno alumno);
	
	List<Aptitud> findByNombre(String nombre);
	List<Aptitud> findByAlumno(Alumno alumno);
	
}