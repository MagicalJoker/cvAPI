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

import edu.altair.cv.dtos.alumnos.VehiculoRequestDto;
import edu.altair.cv.dtos.alumnos.VehiculoResponseDto;
import edu.altair.cv.services.VehiculoService;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {
	
	private VehiculoService vehiculoService;

	public VehiculoController(VehiculoService vehiculoService) {
		super();
		this.vehiculoService = vehiculoService;
	}
	
	@GetMapping("/id/{idVehiculo}")
	public ResponseEntity<VehiculoResponseDto> obtainById(@PathVariable Long idVehiculo) {
		return ResponseEntity.ok(vehiculoService.obtainById(idVehiculo));
	}
	
	@PostMapping
	public ResponseEntity<VehiculoResponseDto> create(@RequestBody VehiculoRequestDto requestDto) {
		VehiculoResponseDto creado = vehiculoService.create(requestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(creado);
	}
	
	@PutMapping("/id/{idVehiculo}")
	public ResponseEntity<VehiculoResponseDto> update(@PathVariable Long idVehiculo,
													  @RequestBody VehiculoRequestDto requestDto) {
		return ResponseEntity.ok(vehiculoService.updateById(idVehiculo, requestDto));
	}
	
	@DeleteMapping("/id/{idVehiculo}")
	public ResponseEntity<VehiculoResponseDto> delete(@PathVariable Long idVehiculo) {
		vehiculoService.deleteById(idVehiculo);
		return ResponseEntity.noContent().build();
	}
	
}