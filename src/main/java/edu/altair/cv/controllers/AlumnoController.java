package edu.altair.cv.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.altair.cv.dtos.alumnos.AlumnoInfoRequestDto;
import edu.altair.cv.dtos.alumnos.AlumnoInfoResponseDto;
import edu.altair.cv.services.AlumnoService;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

	private AlumnoService alumnoService;

	public AlumnoController(AlumnoService alumnoService) {
		super();
		this.alumnoService = alumnoService;
	}

	@GetMapping("/id/{idAlumno}")
	public ResponseEntity<AlumnoInfoResponseDto> obtainById(@PathVariable Long idAlumno) {
		return ResponseEntity.ok(alumnoService.obtainById(idAlumno));
	}

	@PostMapping
	public ResponseEntity<AlumnoInfoResponseDto> create(@RequestBody AlumnoInfoRequestDto requestDto) {
		AlumnoInfoResponseDto creado = alumnoService.create(requestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(creado);
	}

	@PutMapping("/tlf/{telefonoPersonal}")
	public ResponseEntity<AlumnoInfoResponseDto> update(@PathVariable String telefonoPersonal,
			@RequestBody AlumnoInfoRequestDto requestDto) {
		return ResponseEntity.ok(alumnoService.updateByTlf(telefonoPersonal, requestDto));
	}

	@DeleteMapping("/tlf/{telefonoPersonal}")
	public ResponseEntity<AlumnoInfoResponseDto> delete(@PathVariable String telefonoPersonal) {
		alumnoService.deleteByTlf(telefonoPersonal);
		return ResponseEntity.noContent().build();
	}

}
