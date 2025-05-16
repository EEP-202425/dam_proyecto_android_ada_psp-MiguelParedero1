package com.alquilercoches.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import com.alquilercoches.model.Coche;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"coche_id", "usuario_id", "fechaInicio"}))
public class Alquiler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private double precio;

    private boolean devuelto;


    @ManyToOne
    @JoinColumn(name = "coche_id")
    private Coche coche;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public LocalDate getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public LocalDate getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public boolean isDevuelto() {
		return devuelto;
	}


	public void setDevuelto(boolean devuelto) {
		this.devuelto = devuelto;
	}


	public Coche getCoche() {
		return coche;
	}


	public void setCoche(Coche coche) {
		this.coche = coche;
	}


	//public Usuario getUsuario() {
	//	return usuario;
	//}


	//public void setUsuario(Usuario usuario) {
	//	this.usuario = usuario;
	//}
     
}
