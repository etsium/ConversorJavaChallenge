package com.conversor.modelo;

public abstract class Moneda {
	private String nombreMoneda;
	private String acronimoMoneda;
	
	public Moneda(String moneda, String acronimoMoneda) {
		this.nombreMoneda = moneda;
		this.acronimoMoneda = acronimoMoneda;
	}
	
	public String getNombreMoneda() {
		return nombreMoneda;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nombreMoneda;
	}
		
}
