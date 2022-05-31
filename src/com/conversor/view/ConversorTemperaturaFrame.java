package com.conversor.view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.conversor.modelo.TemperaturaExtranjera;
import com.conversor.modelo.TemperaturaLocal;

public class ConversorTemperaturaFrame extends ConversorFrame{
	private List<TemperaturaLocal> listatemperaturas = new ArrayList<>();	
	private TemperaturaLocal temperaturaLocal;
	private TemperaturaExtranjera temperaturaExtranjera;
	private float valorTemperatura;
	
	public ConversorTemperaturaFrame() {
		CargarTemperaturas();
	}
	
	private void CargarTemperaturas() {		
		//this.listatemperaturas.add(new TemperaturaLocal("Kelvin", "K", ObtenerTemperaturasEstranjerasPorEscala("Kelvin")));
		this.listatemperaturas.add(new TemperaturaLocal("Grado Celsius", "C", ObtenerTemperaturasEstranjerasPorEscala("Grado Celsius")));
		this.listatemperaturas.add(new TemperaturaLocal("Grado Fahrenheit", "F", ObtenerTemperaturasEstranjerasPorEscala("Grado Fahrenheit")));
		//this.listatemperaturas.add(new TemperaturaLocal("Rankine", "Ra", ObtenerTemperaturasEstranjerasPorEscala("Rankine")));
		//this.listatemperaturas.add(new TemperaturaLocal("Grado Réaumur", "Re", ObtenerTemperaturasEstranjerasPorEscala("Grado Réaumur")));
		//this.listatemperaturas.add(new TemperaturaLocal("Grado Rømer", "Ro", ObtenerTemperaturasEstranjerasPorEscala("Grado Rømer")));
		//this.listatemperaturas.add(new TemperaturaLocal("Grado Newton", "N", ObtenerTemperaturasEstranjerasPorEscala("Grado Newton")));
		//this.listatemperaturas.add(new TemperaturaLocal("Grado Delisle", "De", ObtenerTemperaturasEstranjerasPorEscala("Grado Delisle")));
	}
	
	public void IniciarConversorTemperatura() {
		this.valorTemperatura = MostrarMensajeInputConvertir();
		EstablecerTemperaturasParaIntercambio(ElegirTipoCambio());
		MostrarMensaje(PreparaMensaje(ConvertirTemperatura()));
	}
	
	private String PreparaMensaje(float numeroConvertido) {
		return this.valorTemperatura + "°" + this.temperaturaLocal.getAcronimo() + " son " + numeroConvertido + "°" + this.temperaturaExtranjera.getAcronimo();
	}

	private float ConvertirTemperatura() {
		return this.temperaturaExtranjera.Convertir(this.valorTemperatura);
	}
	
	public Float MostrarMensajeInputConvertir() {
		Float valorIngresado = null;
		while (valorIngresado == null) {
			try {
				valorIngresado = MostrarMensajeInputConvertir("Ingrese el valor de la temperatura que deseas convertir", "Conversor de Monedas");
			} catch (NumberFormatException e) {
				MostrarMensaje("Valor no Válido");
			}	
		}
		return valorIngresado;
	}

	public String ElegirTipoCambio() {
		Object[] options = EnlistarConversion().toArray();
		return ElegirTipoCambio(options, "Seleccione una opción de conversión","Conversor de Temperaturas");
	}
	
	private List<String> EnlistarConversion() {
		List<String> temperaturas = new ArrayList<String>();
		this.listatemperaturas.forEach(tempereturaLocal -> {
			tempereturaLocal.getTemperaturasExtranjeras().forEach(temperaturaExtranjera -> {
				temperaturas.add("De " + tempereturaLocal.getNombreTemperatura() + " a " + temperaturaExtranjera.getNombreTemperatura());
			});				
		});		
		return temperaturas;
	}

	private void EstablecerTemperaturasParaIntercambio(String comparacion) {
		this.listatemperaturas.forEach(tempereturaLocal -> {
				tempereturaLocal.getTemperaturasExtranjeras().forEach(temperaturaExtranjera -> {	
					if(comparacion.equals("De " + tempereturaLocal.getNombreTemperatura() + " a " + temperaturaExtranjera.getNombreTemperatura())) {
						this.temperaturaLocal = tempereturaLocal;
						this.temperaturaExtranjera = temperaturaExtranjera;
					}
				});						
		});
		
	}	
	
	//Simulacion Obteniendo Temperaturas de base de datos
	private List<TemperaturaExtranjera> ObtenerTemperaturasEstranjerasPorEscala(String nombreEscala) {
		List<TemperaturaExtranjera> temperaturasExtrajeras = new ArrayList<TemperaturaExtranjera>();
		temperaturasExtrajeras.add(new TemperaturaExtranjera("Grado Celsius","Kelvin","K", 1f, 273.15f));
		temperaturasExtrajeras.add(new TemperaturaExtranjera("Grado Celsius","Grado Fahrenheit","F", 1.8f, 32f));
		temperaturasExtrajeras.add(new TemperaturaExtranjera("Grado Celsius","Rankine","Ra", 1.8f, 491.67f));	
		temperaturasExtrajeras.add(new TemperaturaExtranjera("Grado Celsius","Grado Réaumur","Re", 0.8f, 0f));
		temperaturasExtrajeras.add(new TemperaturaExtranjera("Grado Celsius","Grado Rømer","Ro", 0.525f, 7.50f));
		temperaturasExtrajeras.add(new TemperaturaExtranjera("Grado Celsius","Grado Newton","N", 0.33f, 0f));	
		temperaturasExtrajeras.add(new TemperaturaExtranjera("Grado Celsius","Grado Delisle","De", -1.5f, 150f));				
		temperaturasExtrajeras.add(new TemperaturaExtranjera("Grado Fahrenheit","Kelvin","K", 1f, 255.372222f));
		temperaturasExtrajeras.add(new TemperaturaExtranjera("Grado Fahrenheit","Grado Celsius","C", 1f, -17.777778f));		
		temperaturasExtrajeras.add(new TemperaturaExtranjera("Grado Fahrenheit","Rankine","Ra", 1f, 459.67f));	
		temperaturasExtrajeras.add(new TemperaturaExtranjera("Grado Fahrenheit","Grado Réaumur","Re", 0.44f, -14.22f));	
		temperaturasExtrajeras.add(new TemperaturaExtranjera("Grado Fahrenheit","Grado Rømer","Ro", 0.29166666666666666633333333333333f, -1.8333333333f));	
		temperaturasExtrajeras.add(new TemperaturaExtranjera("Grado Fahrenheit","Grado Newton","N", 1f, -5.866667f));	
		temperaturasExtrajeras.add(new TemperaturaExtranjera("Grado Fahrenheit","Grado Delisle","De", 1f, 176.666667f));	
	
		return temperaturasExtrajeras.stream()
				.filter(temperatura -> temperatura.getNombreEscala().equals(nombreEscala))
				.collect(Collectors.toUnmodifiableList());
	}
}
