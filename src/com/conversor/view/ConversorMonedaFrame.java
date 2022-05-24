package com.conversor.view;
import java.util.ArrayList;
import java.util.List;

import com.conversor.modelo.Divisa;
import com.conversor.modelo.Moneda;
import com.conversor.modelo.MonedaARS;
import com.conversor.modelo.MonedaUSD;


public class ConversorMonedaFrame extends ConversorFrame{
	private List<Moneda> listaMonedas = new ArrayList<>();	
	private Moneda monedaLocal;
	private Divisa monedaCambio;
	private float cantidadIntecambio;
	
	public ConversorMonedaFrame() {
		CargarMonedas();
	}

	private void CargarMonedas() {		
		this.listaMonedas.add(new MonedaARS("Argentina", "Pesos Argentinos", "ARS"));
		this.listaMonedas.add(new MonedaUSD("Estados Unidos", "Dolares", "USD"));
	}

	public void IniciarConversorMoneda() {
		this.cantidadIntecambio = MostrarMensajeInputConvertir();
		EstablecerMonedasParaIntercambio(ElegirTipoCambio());
		MostrarMensaje(PreparaMesnaje(ConvertirMoneda()));
	}
	
	private String PreparaMesnaje(float numeroConvertido) {
		return "Tienes $"+numeroConvertido+this.monedaCambio.getNombreMoneda();
	}

	private float ConvertirMoneda() {
		return monedaLocal.ConvertirMoneda(this.monedaCambio.getDivisa(), cantidadIntecambio);
	}

	
	private void EstablecerMonedasParaIntercambio(String comparacion) {
		this.listaMonedas.forEach(monedaLocal -> {
				monedaLocal.getDivisas().forEach(divisa -> {	
					if(comparacion.equals("De " + monedaLocal.getNombreMoneda() + " a " + divisa.getNombreMoneda())) {
						this.monedaLocal = monedaLocal;
						this.monedaCambio = divisa;
					}
				});						
		});
		
	}

	public Integer MostrarMensajeInputConvertir() {
		Integer valorIngresado = null;
		while (valorIngresado == null) {
			try {
				valorIngresado = MostrarMensajeInputConvertir("Ingresa la cantida de dinero que deseas convertir", "Conversor de Monedas");
			} catch (NumberFormatException e) {
				MostrarMensaje("Valor no Válido");
			}	
		}
		return valorIngresado;
	}

	
	public String ElegirTipoCambio() {
		Object[] options = EnlistarConversion().toArray();
		return ElegirTipoCambio(options, "Seleccione una opción de conversión","Conversor de Monedas");
	}
	
	
	/**
	 * 
	 * Devuelve una lista para de todos los Intercambio por moneda que puede hacer la moneda.
	 */
	public List<String> EnlistarConversion() {
		List<String> lista = new ArrayList<String>();
		this.listaMonedas.forEach(monedaLocal -> {
			monedaLocal.getDivisas().forEach(divisa -> {
				lista.add("De " + monedaLocal.getNombreMoneda() + " a " + divisa);
			});				
		});		
		return lista;
	}
}
