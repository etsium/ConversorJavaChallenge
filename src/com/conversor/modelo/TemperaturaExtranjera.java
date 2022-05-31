package com.conversor.modelo;


public class TemperaturaExtranjera extends Temperatura {
	private String nombreEscala;
	private float subidaporGrado;
	private float ceroGrados;
	
	public TemperaturaExtranjera(String nombreEscala, String nombre, String acronimo, float subidaporGrado, float ceroGrados) {
		super(nombre, acronimo);
		this.nombreEscala = nombreEscala;
		this.subidaporGrado = subidaporGrado;
		this.ceroGrados = ceroGrados;
	}
	
	public String getNombreEscala() {
		return nombreEscala;
	}
	
	public float Convertir(float valorTemperatura) {
		return this.ceroGrados + this.subidaporGrado * valorTemperatura;
	}
	
  
}
