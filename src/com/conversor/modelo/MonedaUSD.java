package com.conversor.modelo;

import java.util.ArrayList;
import java.util.List;

public class MonedaUSD extends Moneda{
	private List<Divisa> divisas = CargarDivisas();
	
	public MonedaUSD(String pais, String moneda, String acronimo) {
		super(pais, moneda, acronimo, CargarDivisas());
	}	
	
	private static List<Divisa> CargarDivisas() {
		List<Divisa> divisas = new ArrayList<>();
		divisas.add(new Divisa("Pesos Argentinos", 118.90f));
		divisas.add(new Divisa("Euros", 0.93f));
		divisas.add(new Divisa("Libras", 0.80f));
		divisas.add(new Divisa("Yens", 127.34f));
		divisas.add(new Divisa("Wons Surcoreanos", 1264.80f));
		
		return divisas;
	}
	
	public List<Divisa> getDivisas() {
		return divisas;
	}
	
}
