package com.conversor.modelo;

public class Conversor {
	private static int countIcrement = 1;
	private int id;
	private String nombre;
	
	public Conversor(String nombre) {
		this.id = countIcrement;
		this.nombre = nombre;
		countIcrement++;
	}
	
	@Override
	public String toString() {
		return this.nombre;
	}
	
	public int getId() {
		return this.id;
	}
}
