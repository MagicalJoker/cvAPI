package edu.altair.cv.services.implementations;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.cv.dtos.alumnos.AptitudRequestDto;
import edu.altair.cv.dtos.alumnos.AptitudResponseDto;
import edu.altair.cv.entities.Aptitud;
import edu.altair.cv.exceptions.ResourceNotFoundException;
import edu.altair.cv.repositories.AptitudRepository;
import edu.altair.cv.services.AptitudService;

@Service
public class AptitudServiceImplementation implements AptitudService {

	private AptitudResponseDto mapToResponseDto(Aptitud aptitud) {
		return new AptitudResponseDto(aptitud.getIdAptitudes(), aptitud.getNombre(), aptitud.getDescripcion(),
				aptitud.getAlumno());
	}

	// Inyeccion del repositorio

	private AptitudRepository aptitudRepository;

	public AptitudServiceImplementation(AptitudRepository aptitudRepository) {
		super();
		this.aptitudRepository = aptitudRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public AptitudResponseDto obtainById(Long idAptitudes) {
		Aptitud found = aptitudRepository.findById(idAptitudes)
				.orElseThrow(() -> new ResourceNotFoundException("Aptitud", idAptitudes));

		return mapToResponseDto(found);
	}

	@Override
	@Transactional(readOnly = false)
	public AptitudResponseDto create(AptitudRequestDto requestDto) {
		Aptitud newAptitud = new Aptitud(null, requestDto.nombre(), requestDto.descripcion(), requestDto.alumno());

		Aptitud created = aptitudRepository.save(newAptitud);

		return mapToResponseDto(created);
	}

	@Override
	@Transactional(readOnly = false)
	public AptitudResponseDto updateById(Long idAptitudes, AptitudRequestDto requestDto) {
		Aptitud aptitudFound = aptitudRepository.findById(idAptitudes)
				.orElseThrow(() -> new ResourceNotFoundException("Aptitud", idAptitudes));

		aptitudFound.setNombre(requestDto.nombre());
		aptitudFound.setDescripcion(requestDto.descripcion());
		aptitudFound.setAlumno(requestDto.alumno());

		Aptitud updated = aptitudRepository.save(aptitudFound);

		return mapToResponseDto(updated);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteById(Long idAptitudes) {
		if (!aptitudRepository.existsById(idAptitudes)) {
			throw new ResourceNotFoundException("Aptitud", idAptitudes);
		}
		aptitudRepository.deleteById(idAptitudes);
	}

}