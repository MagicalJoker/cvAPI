package edu.altair.cv.dtos.alumnos;

import java.time.LocalDate;

import edu.altair.cv.entities.Alumno;

public record FormacionResponseDto(Long idFormacion, String nombreTitulacion, LocalDate fecha, String descripcion, Alumno alumno) {
}
