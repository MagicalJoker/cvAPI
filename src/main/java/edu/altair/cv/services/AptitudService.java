package edu.altair.cv.services;

import edu.altair.cv.dtos.alumnos.AptitudRequestDto;
import edu.altair.cv.dtos.alumnos.AptitudResponseDto;

public interface AptitudService {
	
	public AptitudResponseDto obtainById(Long idAptitudes);
	public AptitudResponseDto create(AptitudRequestDto requestDto);
	public AptitudResponseDto updateById(Long idAptitudes, AptitudRequestDto requestDto);
	
	public void deleteById(Long idAptitudes);
	
}