package edu.altair.cv.services;

import edu.altair.cv.dtos.alumnos.FormacionRequestDto;
import edu.altair.cv.dtos.alumnos.FormacionResponseDto;

public interface FormacionService {
	
	public FormacionResponseDto obtainById(Long idFormacion);
	public FormacionResponseDto create(FormacionRequestDto requestDto);
	public FormacionResponseDto updateById(Long idFormacion, FormacionRequestDto requestDto);
	
	public void deleteById(Long idFormacion);
	
}