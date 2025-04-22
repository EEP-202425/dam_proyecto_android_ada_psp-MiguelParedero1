package com.alquilercoches.dominios;

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

	public Coche() {

	}

	public Coche(String marca, String modelo, String matricula, boolean disponible) {
		this.marca = marca;
		this.modelo = modelo;
		this.matricula = matricula;
		this.disponible = disponible;
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

}
