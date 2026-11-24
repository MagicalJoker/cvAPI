package edu.altair.cv.repositories;

import java.util.List;

import edu.altair.cv.entities.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
	
	// Métodospara la info del  Vehiculo del alumnado
	
	boolean existsByTieneCarnet(boolean tieneCarnet);
	boolean existsByTieneVehiculo(boolean tieneVehiculo);
	
	List<Vehiculo> findByTieneCarnet(boolean tieneCarnet);
	List<Vehiculo> findByTieneVehiculo(boolean tieneVehiculo);
	
}