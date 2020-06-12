package com.ipartek.formacion.ejemplopoo.escritorio.componentes;

import javax.swing.JPanel;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LabelText extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel label;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public LabelText() {
		setLayout(new GridLayout(1, 2));
		
		label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setText("Introduce un texto");
		add(label);
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);

	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

}
