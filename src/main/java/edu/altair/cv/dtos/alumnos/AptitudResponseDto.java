package edu.altair.cv.dtos.alumnos;

import edu.altair.cv.entities.Alumno;

public record AptitudResponseDto(Long idAptitudes, String nombre, String descripcion, Alumno alumno) {

}