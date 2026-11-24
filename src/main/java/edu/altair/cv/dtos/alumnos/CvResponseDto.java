package edu.altair.cv.dtos.alumnos;

import java.util.List;

public record CvResponseDto(AlumnoInfoResponseDto alumno, List<ExperienciaResponseDto> Experiencia, List<FormacionResponseDto> Formacion, List<AptitudResponseDto> Aptitud) {

}
