package com.conversor.modelo;

import java.util.ArrayList;
import java.util.List;

public class MonedaARS extends Moneda{
	private List<Divisa> divisas = CargarDivisas();

	public MonedaARS(String pais, String moneda, String acronimo) {
		super(pais, moneda, acronimo, CargarDivisas());	
	}
	
	private static List<Divisa> CargarDivisas() {
		List<Divisa> divisas = new ArrayList<>();
		divisas.add(new Divisa("Dolares", 0.0084f));
		divisas.add(new Divisa("Euros", 0.0078f));
		divisas.add(new Divisa("Libras", 0.0067f));
		divisas.add(new Divisa("Yens", 1.07f));
		divisas.add(new Divisa("Wons Surcoreanos", 10.62f));
		
		return divisas;
	}
	
	public List<Divisa> getDivisas() {
		return divisas;
	}
}
