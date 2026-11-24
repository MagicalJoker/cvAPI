package edu.altair.cv.dtos.alumnos;

import edu.altair.cv.entities.Alumno;

public record AptitudRequestDto(String nombre, String descripcion, Alumno alumno) {

}
