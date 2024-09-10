package com.ipartek.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordenadores")
public class Ordenador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "ram")
	private int ram;

	@Column(name = "hdd")
	private int hdd;

	@Column(name = "precio")
	private double precio;

	@ManyToOne
	private Marca marca;

	public Ordenador(int id, String nombre, int ram, int hdd, double precio, Marca marca) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ram = ram;
		this.hdd = hdd;
		this.precio = precio;
		this.marca = marca;
	}

	public Ordenador() {
		super();
		this.id = 0;
		this.nombre = "";
		this.ram = 0;
		this.hdd = 0;
		this.precio = 0.0;
		this.marca = new Marca();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getHdd() {
		return hdd;
	}

	public void setHdd(int hdd) {
		this.hdd = hdd;
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
		return "Ordenador [id=" + id + ", nombre=" + nombre + ", ram=" + ram + ", hdd=" + hdd + ", precio=" + precio
				+ ", marca=" + marca + "]";
	}

}
