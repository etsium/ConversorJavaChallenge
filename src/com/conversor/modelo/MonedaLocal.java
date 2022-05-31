package com.conversor.modelo;

import java.util.List;


public class MonedaLocal extends Moneda {
	private String pais;
	private List<MonedaExtranjera> monedasExtranjeras;

	public MonedaLocal(String nombreMoneda,String acronimoMoneda, String pais, List<MonedaExtranjera> monedasExtranjeras) {
		super(nombreMoneda, acronimoMoneda);
		this.pais = pais;
		this.monedasExtranjeras = monedasExtranjeras;
	}

	public List<MonedaExtranjera> getMonedasExtranjeras() {
		return monedasExtranjeras;
	}

	public float ConvertirMoneda(float cantidadIntecambio, MonedaExtranjera monedaExtranjera) {
		return cantidadIntecambio * monedaExtranjera.getDivisa();
	}	
}
