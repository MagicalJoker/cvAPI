package edu.altair.cv.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.altair.cv.entities.Experiencia;

@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia, Long> {
	
	boolean existsByNombreEmpresa(String nombreEmpresa);
	boolean existsByPuesto(String puesto);
	
	List<Experiencia> findByNombreEmpresa(String nombreEmpresa);
	List<Experiencia> findByPuesto(String puesto);
	
}
