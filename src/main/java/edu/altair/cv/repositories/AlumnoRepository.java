package edu.altair.cv.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.cv.entities.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
	
	// Métodos derivados para la info de Alumno
	
	boolean existsByEmailPersonal(String emailPersonal);
	boolean existsByTelefonoPersonal(String telefonoPersonal);
	
	Optional<Alumno> findByEmailPersonal(String emailPersonal);
	Optional<Alumno> findByTelefonoPersonal(String telefonoPersonal);
	
}
