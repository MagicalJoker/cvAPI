package edu.altair.cv.dtos.alumnos;

import java.time.LocalDate;

import edu.altair.cv.entities.Alumno;

public record ExperienciaRequestDto(String nombreEmpresa,
									LocalDate fechaComienzo,
									LocalDate fechaFinalizacion,
									String puesto,
									String descripcion,
									Alumno alumno) {

}
