package com.wilmer.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="empresa")
public class Empresa implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmpresa;
	
	@Column(length = 45)
	private String nombre;
	
	private String numeroNit;

	private String fechaFundacion;
	
	private String direccion;

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumeroNit() {
		return numeroNit;
	}

	public void setNumeroNit(String numeroNit) {
		this.numeroNit = numeroNit;
	}

	public String getFechaFundacion() {
		return fechaFundacion;
	}

	public void setFechaFundacion(String fechaFundacion) {
		this.fechaFundacion = fechaFundacion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}