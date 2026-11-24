package edu.altair.cv.services;

import edu.altair.cv.dtos.alumnos.VehiculoRequestDto;
import edu.altair.cv.dtos.alumnos.VehiculoResponseDto;

public interface VehiculoService {
	
	public VehiculoResponseDto obtainById(Long idVehiculo);
	public VehiculoResponseDto create(VehiculoRequestDto requestDto);
	public VehiculoResponseDto updateById(Long idVehiculo, VehiculoRequestDto requestDto);
	
	public void deleteById(Long idVehiculo);
	
}