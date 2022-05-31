package com.conversor.modelo;

public class MonedaExtranjera extends Moneda {
	private String nombreMonedaLocal;
	private String acronimoMonedaExtranjera;
	private float divisa;

	public MonedaExtranjera(String nombreMonedaExtrajera, String acronimoMonedaExtranjera,String nombreMonedaLocal, float divisa) {
		super(nombreMonedaExtrajera, acronimoMonedaExtranjera);
		this.nombreMonedaLocal = nombreMonedaLocal;
		this.divisa = divisa;
	}
	
	public String getNombreMonedaLocal() {
		return nombreMonedaLocal;
	}
	
	public String getAcronimoMonedaExtranjera() {
		return acronimoMonedaExtranjera;
	}
	
	public float getDivisa() {
		return divisa;
	}
}
