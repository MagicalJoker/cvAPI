package edu.altair.cv.services.implementations;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.cv.dtos.alumnos.FormacionRequestDto;
import edu.altair.cv.dtos.alumnos.FormacionResponseDto;
import edu.altair.cv.entities.Formacion;
import edu.altair.cv.exceptions.ResourceNotFoundException;
import edu.altair.cv.repositories.FormacionRepository;
import edu.altair.cv.services.FormacionService;

@Service
public class FormacionServiceImplementation implements FormacionService {

	private FormacionResponseDto mapToResponseDto(Formacion formacion) {
		return new FormacionResponseDto(formacion.getIdFormacion(), formacion.getNombreTitulación(),
				formacion.getFecha(), formacion.getDescripcion(), formacion.getAlumno());
	}

	// Inyeccion del repositorio

	private FormacionRepository formacionRepository;

	public FormacionServiceImplementation(FormacionRepository formacionRepository) {
		super();
		this.formacionRepository = formacionRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public FormacionResponseDto obtainById(Long idFormacion) {
		Formacion found = formacionRepository.findById(idFormacion)
				.orElseThrow(() -> new ResourceNotFoundException("Formación", idFormacion));

		return mapToResponseDto(found);
	}

	@Override
	@Transactional(readOnly = false)
	public FormacionResponseDto create(FormacionRequestDto requestDto) {
		Formacion newFormacion = new Formacion(null, requestDto.nombreTitulacion(), requestDto.fecha(),
				requestDto.descripcion(), requestDto.alumno());

		Formacion created = formacionRepository.save(newFormacion);

		return mapToResponseDto(created);
	}

	@Override
	@Transactional(readOnly = false)
	public FormacionResponseDto updateById(Long idFormacion, FormacionRequestDto requestDto) {
		Formacion formacionFound = formacionRepository.findById(idFormacion)
				.orElseThrow(() -> new ResourceNotFoundException("Formación", idFormacion));

		formacionFound.setNombreTitulación(requestDto.nombreTitulacion());
		formacionFound.setFecha(requestDto.fecha());
		formacionFound.setDescripcion(requestDto.descripcion());
		formacionFound.setAlumno(requestDto.alumno());

		Formacion updated = formacionRepository.save(formacionFound);

		return mapToResponseDto(updated);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteById(Long idFormacion) {
		if (!formacionRepository.existsById(idFormacion)) {
			throw new ResourceNotFoundException("Formación", idFormacion);
		}
		formacionRepository.deleteById(idFormacion);
	}

}