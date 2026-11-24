package edu.altair.cv.services;

import edu.altair.cv.dtos.alumnos.AlumnoInfoRequestDto;
import edu.altair.cv.dtos.alumnos.AlumnoInfoResponseDto;

public interface AlumnoService {
	
	public AlumnoInfoResponseDto obtainById(Long idAlumno);
	public AlumnoInfoResponseDto create(AlumnoInfoRequestDto requestDto);
	public AlumnoInfoResponseDto updateByTlf(String telefonoPersonal, AlumnoInfoRequestDto requestDto);
	
	public void deleteByTlf(String telefonoPersonal);
	
}
