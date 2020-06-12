package com.ipartek.formacion.ejemplopoo.escritorio.componentes;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Segundo extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Segundo() {
		
		JLabel lblPrimerPaso = new JLabel("Segundo paso");
		add(lblPrimerPaso);
		
		JButton btnSiguiente = new JButton("Anterior");
		add(btnSiguiente);

	}

}
