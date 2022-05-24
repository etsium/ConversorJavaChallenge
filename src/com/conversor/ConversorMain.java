package com.conversor;

import com.conversor.modelo.Conversor;
import com.conversor.view.ConversorMonedaFrame;
import com.conversor.view.ConversorTemperaturaFrame;
import com.conversor.view.MainFrame;

public class ConversorMain {
	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		
		do {
			switch (((Conversor) mainFrame.ElegirConversor()).getId()) {
			case 1:
				ConversorMonedaFrame conversorMonedaFrame = new ConversorMonedaFrame();
				conversorMonedaFrame.IniciarConversorMoneda();
				break;

			case 2:
				ConversorTemperaturaFrame conversorTemperaturaFrame = new ConversorTemperaturaFrame();
				conversorTemperaturaFrame.IniciarConversorTemperatura();
				break;
		
			default:
				MainFrame.TerminarPrograma();
				break;
			}	
		} while (mainFrame.PreguntarContinuar());
		mainFrame.TerminarPrograma();
	}
}
