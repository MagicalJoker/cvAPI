package edu.altair.cv.services.implementations;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.cv.dtos.alumnos.AlumnoInfoRequestDto;
import edu.altair.cv.dtos.alumnos.AlumnoInfoResponseDto;
import edu.altair.cv.entities.Alumno;
import edu.altair.cv.exceptions.BadRequestException;
import edu.altair.cv.exceptions.ResourceAlreadyExistsException;
import edu.altair.cv.exceptions.ResourceNotFoundException;
import edu.altair.cv.repositories.AlumnoRepository;
import edu.altair.cv.services.AlumnoService;

@Service
public class AlumnoServiceImplementation implements AlumnoService {

	private AlumnoInfoResponseDto mapToResponseDto(Alumno alumno) {
		return new AlumnoInfoResponseDto(alumno.getIdAlumno(), alumno.getNombre(), alumno.getApellido1(),
				alumno.getApellido2(), alumno.getEmailPersonal(), alumno.getTelefonoPersonal(), alumno.getDireccion(),
				alumno.getCiclo(), alumno.getCurso(), alumno.getVehiculo());
	}

	// Inyeccion del repositorio

	private AlumnoRepository alumnoRepository;

	public AlumnoServiceImplementation(AlumnoRepository alumnoRepository) {
		super();
		this.alumnoRepository = alumnoRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public AlumnoInfoResponseDto obtainById(Long idAlumno) {
		Alumno alumno = alumnoRepository.findById(idAlumno)
				.orElseThrow(() -> new ResourceNotFoundException("Alumno", idAlumno));

		Alumno found = alumnoRepository.save(alumno);

		return mapToResponseDto(found);
	}

	@Override
	@Transactional(readOnly = false)
	public AlumnoInfoResponseDto create(AlumnoInfoRequestDto requestDto) {
		if (requestDto.telefonoPersonal() == null || requestDto.telefonoPersonal().isBlank()) {
			throw new BadRequestException("El teléfono personal es obligatorio");
		}
		if (requestDto.emailPersonal() == null || requestDto.emailPersonal().isBlank()) {
			throw new BadRequestException("El email personal es obligatorio");
		}
		if (alumnoRepository.existsByTelefonoPersonal(requestDto.telefonoPersonal())) {
			throw new ResourceAlreadyExistsException(
					"Ya existe un alumno con el teléfono " + requestDto.telefonoPersonal());
		}
		if (alumnoRepository.existsByEmailPersonal(requestDto.emailPersonal())) {
			throw new ResourceAlreadyExistsException("Ya existe un alumno con el email " + requestDto.emailPersonal());
		}

		Alumno newAlumno = new Alumno(null, requestDto.nombre(), requestDto.apellido1(), requestDto.apellido2(),
				requestDto.emailPersonal(), requestDto.telefonoPersonal(), requestDto.direccion(), requestDto.ciclo(),
				requestDto.curso(), requestDto.vehiculo());

		Alumno created = alumnoRepository.save(newAlumno);

		return mapToResponseDto(created);
	}

	@Override
	@Transactional(readOnly = false)
	public AlumnoInfoResponseDto updateByTlf(String telefonoPersonal, AlumnoInfoRequestDto requestDto) {
		Alumno alumnoFound = alumnoRepository.findByTelefonoPersonal(telefonoPersonal)
				.orElseThrow(() -> new ResourceNotFoundException("Alumno", telefonoPersonal));

		alumnoFound.setNombre(requestDto.nombre());
		alumnoFound.setApellido1(requestDto.apellido1());
		alumnoFound.setApellido2(requestDto.apellido2());
		alumnoFound.setEmailPersonal(requestDto.emailPersonal());
		alumnoFound.setTelefonoPersonal(requestDto.telefonoPersonal());
		alumnoFound.setDireccion(requestDto.direccion());
		alumnoFound.setCiclo(requestDto.ciclo());
		alumnoFound.setCurso(requestDto.curso());
		alumnoFound.setVehiculo(requestDto.vehiculo());

		Alumno updated = alumnoRepository.save(alumnoFound);

		return mapToResponseDto(updated);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteByTlf(String telefonoPersonal) {
		Alumno alumno = alumnoRepository.findByTelefonoPersonal(telefonoPersonal)
				.orElseThrow(() -> new ResourceNotFoundException("Alumno", telefonoPersonal));
		alumnoRepository.deleteById(alumno.getIdAlumno());

	}

}
