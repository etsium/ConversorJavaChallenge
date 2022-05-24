package com.conversor.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.conversor.modelo.Conversor;

public class MainFrame {
	private List<Conversor> listaConversores = new ArrayList<>();	
	
	public MainFrame() {
		this.listaConversores.add(new Conversor("Conversor de Moneda"));
		this.listaConversores.add(new Conversor("Conversor de Temeperatura"));
	}

	public Object ElegirConversor() {
		// TODO Auto-generated method stub
		Object[] options = this.listaConversores.toArray();		
		JOptionPane conversorFrame = new JOptionPane();	
		
		Object seleccion = JOptionPane.showInputDialog(
					conversorFrame,
				   "Seleccione una opción de conversión",
				   "Menu",
				   JOptionPane.QUESTION_MESSAGE,
				   null,  // null para icono defecto
				   options,
				   null
				   );	
		if (seleccion == null) {
			 TerminarPrograma();
		 }
		
		return seleccion;
	}	
	
	public static void TerminarPrograma() {
        JOptionPane.showMessageDialog(null, "Programa Terminado");
        System.exit(1);
	}
	
	
	public boolean PreguntarContinuar() {
		int confirmado = JOptionPane.showConfirmDialog(
				   new JOptionPane(),
				   "¿Deseas Continuar?");

		if (JOptionPane.OK_OPTION == confirmado)
		   return true;
		else
		   return false;
	}
}
