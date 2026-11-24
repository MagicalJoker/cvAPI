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

import edu.altair.cv.dtos.alumnos.FormacionRequestDto;
import edu.altair.cv.dtos.alumnos.FormacionResponseDto;
import edu.altair.cv.services.FormacionService;

@RestController
@RequestMapping("/api/formaciones")
public class FormacionController {
	
	private FormacionService formacionService;

	public FormacionController(FormacionService formacionService) {
		super();
		this.formacionService = formacionService;
	}
	
	@GetMapping("/id/{idFormacion}")
	public ResponseEntity<FormacionResponseDto> obtainById(@PathVariable Long idFormacion) {
		return ResponseEntity.ok(formacionService.obtainById(idFormacion));
	}
	
	@PostMapping
	public ResponseEntity<FormacionResponseDto> create(@RequestBody FormacionRequestDto requestDto) {
		FormacionResponseDto creado = formacionService.create(requestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(creado);
	}
	
	@PutMapping("/id/{idFormacion}")
	public ResponseEntity<FormacionResponseDto> update(@PathVariable Long idFormacion, 
			@RequestBody FormacionRequestDto requestDto) {
		return ResponseEntity.ok(formacionService.updateById(idFormacion, requestDto));
	}
	
	@DeleteMapping("/id/{idFormacion}")
	public ResponseEntity<FormacionResponseDto> delete(@PathVariable Long idFormacion) {
		formacionService.deleteById(idFormacion);
		return ResponseEntity.noContent().build();
	}
	
}