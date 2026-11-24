package edu.altair.cv.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vehiculo")
	private Long idVehiculo;
	
	@Column(name = "tiene_carnet")
	private boolean tieneCarnet;
	
	@Column(name = "tiene_vehiculo")
	private boolean tieneVehiculo;
	
	// Constructores
	
	public Vehiculo() {};
	
	public Vehiculo(Long idVehiculo, boolean tieneCarnet, boolean tieneVehiculo) {
		super();
		this.idVehiculo = idVehiculo;
		this.tieneCarnet = tieneCarnet;
		this.tieneVehiculo = tieneVehiculo;
	}
	
	// Getters & Setters
	
	public Long getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public boolean isTieneCarnet() {
		return tieneCarnet;
	}

	public void setTieneCarnet(boolean tieneCarnet) {
		this.tieneCarnet = tieneCarnet;
	}

	public boolean isTieneVehiculo() {
		return tieneVehiculo;
	}

	public void setTieneVehiculo(boolean tieneVehiculo) {
		this.tieneVehiculo = tieneVehiculo;
	}
	
}
