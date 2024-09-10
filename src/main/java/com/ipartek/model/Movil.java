package com.ipartek.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "moviles")
public class Movil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "modelo")
	private String modelo;

	@Column(name = "precio")
	private double precio;

	// Muchos moviles tienen una misma marca
	@ManyToOne
	private Marca marca;

	public Movil(int id, String modelo, double precio, Marca marca) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.precio = precio;
		this.marca = marca;
	}

	public Movil() {
		super();
		this.id = 0;
		this.modelo = "";
		this.precio = 0.0;
		this.marca = new Marca();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "Movil [id=" + id + ", modelo=" + modelo + ", precio=" + precio + ", marca=" + marca + "]";
	}

}
