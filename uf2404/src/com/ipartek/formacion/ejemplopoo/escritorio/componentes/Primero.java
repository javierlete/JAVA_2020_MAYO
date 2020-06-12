package com.ipartek.formacion.ejemplopoo.escritorio.componentes;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

public class Primero extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton btnSiguiente;
	
	/**
	 * Create the panel.
	 */
	public Primero() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pAsistente = new JPanel();
		add(pAsistente, BorderLayout.SOUTH);
		pAsistente.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblPrimerPaso = new JLabel("Primer paso");
		pAsistente.add(lblPrimerPaso);
		
		btnSiguiente = new JButton("Siguiente");
		pAsistente.add(btnSiguiente);
		
		JPanel pFormulario = new JPanel();
		add(pFormulario, BorderLayout.NORTH);
		pFormulario.setLayout(new GridLayout(0, 1, 0, 0));
		
		LabelText ltNombre = new LabelText();
		ltNombre.getLabel().setText("Nombre");
		pFormulario.add(ltNombre);
		
		LabelText ltApellido1 = new LabelText();
		ltApellido1.getLabel().setText("Primer apellido");
		pFormulario.add(ltApellido1);
		
		LabelText ltApellido2 = new LabelText();
		ltApellido2.getLabel().setText("Segundo apellido");
		pFormulario.add(ltApellido2);

	}

	public JButton getBtnSiguiente() {
		return btnSiguiente;
	}

	public void setBtnSiguiente(JButton btnSiguiente) {
		this.btnSiguiente = btnSiguiente;
	}

}
