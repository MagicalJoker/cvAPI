package edu.altair.cv.services.implementations;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.cv.dtos.alumnos.ExperienciaRequestDto;
import edu.altair.cv.dtos.alumnos.ExperienciaResponseDto;
import edu.altair.cv.entities.Experiencia;
import edu.altair.cv.exceptions.BadRequestException;
import edu.altair.cv.exceptions.ResourceAlreadyExistsException;
import edu.altair.cv.exceptions.ResourceNotFoundException;
import edu.altair.cv.repositories.ExperienciaRepository;
import edu.altair.cv.services.ExperienciaService;

@Service
public class ExperienciaServiceImplementation implements ExperienciaService {

	private ExperienciaResponseDto mapToResponseDto(Experiencia experiencia) {
		return new ExperienciaResponseDto(experiencia.getIdExperiencia(), experiencia.getNombreEmpresa(),
				experiencia.getFechaComienzo(), experiencia.getFechaFinalizacion(), experiencia.getPuesto(),
				experiencia.getDescripcion(), experiencia.getAlumno());
	}

	// Inyeccion del repositorio

	private ExperienciaRepository experienciaRepository;

	public ExperienciaServiceImplementation(ExperienciaRepository experienciaRepository) {
		super();
		this.experienciaRepository = experienciaRepository;
	}
	
	@Override
	@Transactional(readOnly = true)
	public ExperienciaResponseDto obtainById(Long idExperiencia) {
		Experiencia found = experienciaRepository.findById(idExperiencia)
				.orElseThrow(() -> new ResourceNotFoundException("Experiencia", idExperiencia));

		return mapToResponseDto(found);
	}

	@Override
	@Transactional(readOnly = false)
	public ExperienciaResponseDto create(ExperienciaRequestDto requestDto) {
		if (requestDto.nombreEmpresa() == null || requestDto.nombreEmpresa().isBlank()) {
			throw new BadRequestException("El nombre de la empresa es obligatorio");
		}
		if (requestDto.puesto() == null || requestDto.puesto().isBlank()) {
			throw new BadRequestException("El puesto es obligatorio");
		}
		if (experienciaRepository.existsByNombreEmpresa(requestDto.nombreEmpresa())) {
			throw new ResourceAlreadyExistsException(
					"Ya existe una experiencia en la empresa " + requestDto.nombreEmpresa());
		}
		if (experienciaRepository.existsByPuesto(requestDto.puesto())) {
			throw new ResourceAlreadyExistsException("Ya existe una experiencia con el puesto " + requestDto.puesto());
		}
		
		Experiencia newExperiencia = new Experiencia(null, requestDto.nombreEmpresa(), requestDto.fechaComienzo(),
				requestDto.fechaFinalizacion(), requestDto.puesto(), requestDto.descripcion(), requestDto.alumno());

		Experiencia created = experienciaRepository.save(newExperiencia);

		return mapToResponseDto(created);
	}

	@Override
	@Transactional(readOnly = false)
	public ExperienciaResponseDto updateById(Long idExperiencia, ExperienciaRequestDto requestDto) {
		Experiencia experienciaFound = experienciaRepository.findById(idExperiencia)
				.orElseThrow(() -> new ResourceNotFoundException("Experiencia", idExperiencia));

		experienciaFound.setNombreEmpresa(requestDto.nombreEmpresa());
		experienciaFound.setFechaComienzo(requestDto.fechaComienzo());
		experienciaFound.setFechaFinalizacion(requestDto.fechaFinalizacion());
		experienciaFound.setPuesto(requestDto.puesto());
		experienciaFound.setDescripcion(requestDto.descripcion());

		Experiencia updated = experienciaRepository.save(experienciaFound);

		return mapToResponseDto(updated);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteById(Long idExperiencia) {
		if (!experienciaRepository.existsById(idExperiencia)) {
			throw new ResourceNotFoundException("Experiencia", idExperiencia);
		}
		experienciaRepository.deleteById(idExperiencia);
	}

}
