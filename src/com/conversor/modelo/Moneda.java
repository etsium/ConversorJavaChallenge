package com.conversor.modelo;

import java.util.List;


public abstract class Moneda {
	private String pais;
	private String nombreMoneda;
	private String acronimoMoneda;
	private final float valor = 1;
	List<Divisa> divisas;

	public Moneda(String pais, String moneda, String acronimo, List<Divisa> divisas) {
		this.pais = pais;
		this.nombreMoneda = moneda;
		this.acronimoMoneda = acronimo;
		this.divisas = divisas;
	}
	
	public String getNombreMoneda() {
		return nombreMoneda;
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nombreMoneda;
	}
	
	public abstract List<Divisa> getDivisas();
	
	public float ConvertirMoneda(float divisa, float cantidadIntecambio) {
		float conversion = cantidadIntecambio * divisa;
		return conversion;
	}
	
}
