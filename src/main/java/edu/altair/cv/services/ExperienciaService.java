package edu.altair.cv.services;

import edu.altair.cv.dtos.alumnos.ExperienciaRequestDto;
import edu.altair.cv.dtos.alumnos.ExperienciaResponseDto;

public interface ExperienciaService {
	
	public ExperienciaResponseDto obtainById(Long idExperiencia);
	public ExperienciaResponseDto create(ExperienciaRequestDto requestDto);
	public ExperienciaResponseDto updateById(Long idExperiencia, ExperienciaRequestDto requestDto);
	
	public void deleteById(Long idExperiencia);
	
}
