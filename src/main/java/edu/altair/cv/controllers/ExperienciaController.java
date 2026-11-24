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

import edu.altair.cv.dtos.alumnos.ExperienciaRequestDto;
import edu.altair.cv.dtos.alumnos.ExperienciaResponseDto;
import edu.altair.cv.services.ExperienciaService;

@RestController
@RequestMapping("/api/experiencias")
public class ExperienciaController {
	
	private ExperienciaService experienciaService;

	public ExperienciaController(ExperienciaService experienciaService) {
		super();
		this.experienciaService = experienciaService;
	}
	
	@GetMapping("/id/{idExperiencia}")
	public ResponseEntity<ExperienciaResponseDto> obtainById(@PathVariable Long idExperiencia) {
		return ResponseEntity.ok(experienciaService.obtainById(idExperiencia));
	}
	
	@PostMapping
	public ResponseEntity<ExperienciaResponseDto> create(@RequestBody ExperienciaRequestDto requestDto) {
		ExperienciaResponseDto creado = experienciaService.create(requestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(creado);
	}
	
	@PutMapping("/id/{idExperiencia}")
	public ResponseEntity<ExperienciaResponseDto> update(@PathVariable Long idExperiencia, 
			@RequestBody ExperienciaRequestDto requestDto) {
		return ResponseEntity.ok(experienciaService.updateById(idExperiencia, requestDto));
	}
	
	@DeleteMapping("/id/{idExperiencia}")
	public ResponseEntity<ExperienciaResponseDto> delete(@PathVariable Long idExperiencia) {
		experienciaService.deleteById(idExperiencia);
		return ResponseEntity.noContent().build();
	}
	
}
