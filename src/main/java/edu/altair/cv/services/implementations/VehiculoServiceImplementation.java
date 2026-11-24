package edu.altair.cv.services.implementations;

import edu.altair.cv.entities.Vehiculo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.altair.cv.dtos.alumnos.VehiculoRequestDto;
import edu.altair.cv.dtos.alumnos.VehiculoResponseDto;
import edu.altair.cv.exceptions.ResourceNotFoundException;
import edu.altair.cv.repositories.VehiculoRepository;
import edu.altair.cv.services.VehiculoService;

@Service
public class VehiculoServiceImplementation implements VehiculoService {

	private VehiculoResponseDto mapToResponseDto(Vehiculo vehiculo) {
		return new VehiculoResponseDto(vehiculo.getIdVehiculo(), vehiculo.isTieneCarnet(),
				vehiculo.isTieneVehiculo());
	}

	// Inyeccion del repositorio

	private VehiculoRepository vehiculoRepository;

	public VehiculoServiceImplementation(VehiculoRepository vehiculoRepository) {
		super();
		this.vehiculoRepository = vehiculoRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public VehiculoResponseDto obtainById(Long idVehiculo) {
		Vehiculo found = vehiculoRepository.findById(idVehiculo)
				.orElseThrow(() -> new ResourceNotFoundException("Vehiculo", idVehiculo));

		return mapToResponseDto(found);
	}

	@Override
	@Transactional(readOnly = false)
	public VehiculoResponseDto create(VehiculoRequestDto requestDto) {
		Vehiculo newVehiculo = new Vehiculo(null, requestDto.tieneCarnet(), requestDto.tieneVehiculo());

		Vehiculo created = vehiculoRepository.save(newVehiculo);

		return mapToResponseDto(created);
	}

	@Override
	@Transactional(readOnly = false)
	public VehiculoResponseDto updateById(Long idVehiculo, VehiculoRequestDto requestDto) {
		Vehiculo vehiculoFound = vehiculoRepository.findById(idVehiculo)
				.orElseThrow(() -> new ResourceNotFoundException("Vehiculo", idVehiculo));

		vehiculoFound.setTieneCarnet(requestDto.tieneCarnet());
		vehiculoFound.setTieneVehiculo(requestDto.tieneVehiculo());

		Vehiculo updated = vehiculoRepository.save(vehiculoFound);

		return mapToResponseDto(updated);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteById(Long idVehiculo) {
		if (!vehiculoRepository.existsById(idVehiculo)) {
			throw new ResourceNotFoundException("Vehiculo", idVehiculo);
		}
		vehiculoRepository.deleteById(idVehiculo);
	}

}