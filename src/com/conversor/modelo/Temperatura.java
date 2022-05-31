package com.conversor.modelo;

public abstract class Temperatura {
	private String nombre;
	private String acronimo;
	
	public Temperatura(String nombre, String acronimo) {
		super();
		this.nombre = nombre;
		this.acronimo = acronimo;
	}
	
	public String getNombreTemperatura() {
		return nombre;
	}
	
	public String getAcronimo() {
		return acronimo;
	}
}
