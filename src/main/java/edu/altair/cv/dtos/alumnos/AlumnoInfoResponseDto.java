package edu.altair.cv.dtos.alumnos;

import edu.altair.cv.entities.Vehiculo;

public record AlumnoInfoResponseDto(Long idAlumno, String nombre, String apellido1, String apellido2, String emailPersonal, String telefonoPersonal, String direccion, String ciclo, String curso, Vehiculo vehiculo) {
}
