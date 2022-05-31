package com.conversor.view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.conversor.modelo.MonedaExtranjera;
import com.conversor.modelo.MonedaLocal;

public class ConversorMonedaFrame extends ConversorFrame {
	private List<MonedaLocal> listaMonedas = new ArrayList<>();
	private MonedaLocal monedaLocal;
	private MonedaExtranjera monedaExtranjera;
	private float cantidadIntecambio;

	public ConversorMonedaFrame() {
		CargarMonedas();
	}

	private void CargarMonedas() {
		this.listaMonedas.add(new MonedaLocal("Pesos Argentinos", "ARS", "Argentina",
				ObtenerMonedasExtranjeasPorNombreMonedaLocal("Pesos Argentinos")));
		this.listaMonedas.add(new MonedaLocal("Dolares", "USD", "Estados Unidos",
				ObtenerMonedasExtranjeasPorNombreMonedaLocal("Dolares")));
	}

	public void IniciarConversorMoneda() {
		this.cantidadIntecambio = MostrarMensajeInputConvertir();
		EstablecerMonedasParaIntercambio(ElegirTipoCambio());
		MostrarMensaje(PrepararMensaje(ConvertirMoneda()));
	}

	private String PrepararMensaje(float numeroConvertido) {
		return "Tienes $" + numeroConvertido + " " +  this.monedaExtranjera.getNombreMoneda();
	}

	private float ConvertirMoneda() {
		return monedaLocal.ConvertirMoneda(cantidadIntecambio, monedaExtranjera);
	}

	private void EstablecerMonedasParaIntercambio(String comparacion) {
		this.listaMonedas.forEach(monedaLocal -> {
			monedaLocal.getMonedasExtranjeras().forEach(monedaExtranjera -> {
				if (comparacion
						.equals("De " + monedaLocal.getNombreMoneda() + " a " + monedaExtranjera.getNombreMoneda())) {
					this.monedaLocal = monedaLocal;
					this.monedaExtranjera = monedaExtranjera;
				}
			});
		});

	}

	public Float MostrarMensajeInputConvertir() {
		Float valorIngresado = null;
		while (valorIngresado == null) {
			try {
				valorIngresado = MostrarMensajeInputConvertir("Ingresa la cantida de dinero que deseas convertir",
						"Conversor de Monedas");
			} catch (NumberFormatException e) {
				MostrarMensaje("Valor no Válido");
			}
		}
		return valorIngresado;
	}

	public String ElegirTipoCambio() {
		Object[] options = EnlistarConversion().toArray();
		return ElegirTipoCambio(options, "Seleccione una opción de conversión", "Conversor de Monedas");
	}

	/**
	 * 
	 * Devuelve una lista para de todos los Intercambio por moneda que puede hacer
	 * la moneda.
	 */
	public List<String> EnlistarConversion() {
		List<String> lista = new ArrayList<String>();
		this.listaMonedas.forEach(monedaLocal -> {
			monedaLocal.getMonedasExtranjeras().forEach(monedaExtranjera -> {
				lista.add("De " + monedaExtranjera.getNombreMonedaLocal() + " a " + monedaExtranjera.getNombreMoneda());
			});
		});
		return lista;
	}

	// Simulacion Obteniendo Monedas de base de datos
	private List<MonedaExtranjera> ObtenerMonedasExtranjeasPorNombreMonedaLocal(String nombreMoneda) {
		List<MonedaExtranjera> monedasExtranjeras = new ArrayList<MonedaExtranjera>();
		monedasExtranjeras.add(new MonedaExtranjera("Dolares", "USD", "Pesos Argentinos", 0.0082f));
		monedasExtranjeras.add(new MonedaExtranjera("Euros", "EUR", "Pesos Argentinos", 0.0078f));
		monedasExtranjeras.add(new MonedaExtranjera("Libras", "GBP", "Pesos Argentinos", 0.0067f));
		monedasExtranjeras.add(new MonedaExtranjera("Yens", "JPY", "Pesos Argentinos", 1.07f));
		monedasExtranjeras.add(new MonedaExtranjera("Wons Surcoreanos", "KRW", "Pesos Argentinos", 10.62f));
		
		monedasExtranjeras.add(new MonedaExtranjera("Pesos Argentinos", "ARS", "Dolares", 120.19f));
		monedasExtranjeras.add(new MonedaExtranjera("Euros", "EUR", "Dolares", 0.93f));
		monedasExtranjeras.add(new MonedaExtranjera("Libras", "GBP", "Dolares", 0.0067f));
		monedasExtranjeras.add(new MonedaExtranjera("Yens", "JPY", "Dolares", 0.79f));
		monedasExtranjeras.add(new MonedaExtranjera("Wons Surcoreanos", "KRW", "Dolares", 1242.74f));

		return monedasExtranjeras.stream().filter(moneda -> moneda.getNombreMonedaLocal().equals(nombreMoneda))
				.collect(Collectors.toUnmodifiableList());
	}
}
