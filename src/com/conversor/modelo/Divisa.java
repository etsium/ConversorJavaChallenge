package com.conversor.modelo;

public class Divisa {
	private String nombreMoneda;
	private float divisa;
	
	public Divisa(String nombreMoneda, float divisa) {
		super();
		this.nombreMoneda = nombreMoneda;
		this.divisa = divisa;
	}
	
	public String getNombreMoneda() {
		return nombreMoneda;
	}
	
	public float getDivisa() {
		return divisa;
	}	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nombreMoneda;
	}
}
