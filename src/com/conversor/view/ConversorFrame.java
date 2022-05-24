package com.conversor.view;

import javax.swing.JOptionPane;

public abstract class ConversorFrame {

	public Integer MostrarMensajeInputConvertir(String mensaje, String titulo) {
		String m = JOptionPane.showInputDialog(
				new JOptionPane(), 
				mensaje,
				titulo, 
				JOptionPane.QUESTION_MESSAGE);
		if (m == null) {
			MainFrame.TerminarPrograma();
		}

		return Integer.valueOf(m.toString());
	};

	public String ElegirTipoCambio(Object[] options, String mensaje, String titulo){
		JOptionPane conversorFrame = new JOptionPane();			
		Object seleccion = JOptionPane.showInputDialog(
					conversorFrame,
				   mensaje,
				   titulo,
				   JOptionPane.QUESTION_MESSAGE,
				   null,  // null para icono defecto
				   options,
				   null
				   );
		if (seleccion == null) {
			MainFrame.TerminarPrograma();
		}

		return seleccion.toString();
	}

	public void MostrarMensaje(String m) {
        JOptionPane.showMessageDialog(new JOptionPane(), m);
	}


}
