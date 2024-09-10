package com.ipartek.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "marcas")
public class Marca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nombre")
	private String nombre;

	@OneToMany
	private List<Movil> listaMoviles;

	@OneToMany
	private List<Ordenador> listaOrdenadores;

	public Marca(int id, String nombre, List<Movil> listaMoviles, List<Ordenador> listaOrdenadores) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.listaMoviles = listaMoviles;
		this.listaOrdenadores = listaOrdenadores;
	}

	public Marca() {
		super();
		this.id = 0;
		this.nombre = "";
		this.listaMoviles = new ArrayList<Movil>();
		this.listaOrdenadores = new ArrayList<Ordenador>();
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

	public List<Movil> getListaMoviles() {
		return listaMoviles;
	}

	public void setListaMoviles(List<Movil> listaMoviles) {
		this.listaMoviles = listaMoviles;
	}

	public List<Ordenador> getListaOrdenadores() {
		return listaOrdenadores;
	}

	public void setListaOrdenadores(List<Ordenador> listaOrdenadores) {
		this.listaOrdenadores = listaOrdenadores;
	}

	@Override
	public String toString() {
		return "Marca [id=" + id + ", nombre=" + nombre + ", listaMoviles=" + listaMoviles + ", listaOrdenadores="
				+ listaOrdenadores + "]";
	}

}
