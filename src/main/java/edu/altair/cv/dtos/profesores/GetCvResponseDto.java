package edu.altair.cv.dtos.profesores;

import java.util.List;

import edu.altair.cv.entities.Alumno;
import edu.altair.cv.entities.Aptitud;
import edu.altair.cv.entities.Experiencia;
import edu.altair.cv.entities.Formacion;

public record GetCvResponseDto(Alumno alumno, List<Experiencia> experiencias, List<Formacion> formaciones, List<Aptitud> aptitudes) {

}
