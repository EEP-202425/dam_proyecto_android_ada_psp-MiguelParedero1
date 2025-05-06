package com.alquilercoches.model;

import jakarta.persistence.*;

@Entity
public class Coche {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String marca;
	private String modelo;
	private String matricula;
	private boolean disponible;
	private double precio;

	public Coche() {

	}


	public Coche(Long id, String marca, String modelo, String matricula, boolean disponible, double precio) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.matricula = matricula;
		this.disponible = disponible;
		this.precio = precio;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
