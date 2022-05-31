package com.conversor.modelo;

import java.util.List;

public class TemperaturaLocal extends Temperatura{
	private List<TemperaturaExtranjera> temperaturas;
	

	public TemperaturaLocal(String nombre, String acronimo, List<TemperaturaExtranjera> temperaturas) {
		super(nombre, acronimo);
		this.temperaturas = temperaturas;
	}
	
	public List<TemperaturaExtranjera> getTemperaturasExtranjeras() {
		return temperaturas;
	}
	
	public float Convertir(TemperaturaExtranjera temperaturaExtranjera, float valorTemperatura) {
		return temperaturaExtranjera.Convertir(valorTemperatura);
	}

}
