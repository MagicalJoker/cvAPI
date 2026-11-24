package edu.altair.cv.services;

import java.util.List;

import edu.altair.cv.dtos.alumnos.AlumnoInfoResponseDto;
import edu.altair.cv.dtos.alumnos.AptitudResponseDto;
import edu.altair.cv.dtos.alumnos.ExperienciaResponseDto;
import edu.altair.cv.dtos.alumnos.FormacionResponseDto;

public interface CVByAlumnoService {
	
	public AlumnoInfoResponseDto obtainByIdAlumno(Long idAlumno);
	public List<ExperienciaResponseDto> obtainAllExperiencias();
	public List<FormacionResponseDto> obtainAllFormaciones();
	public List<AptitudResponseDto> obtainAllAptitudes();
	
}
