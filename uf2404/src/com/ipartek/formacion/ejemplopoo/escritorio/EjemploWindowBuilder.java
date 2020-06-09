package com.ipartek.formacion.ejemplopoo.escritorio;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EjemploWindowBuilder {

	private JFrame frmEjemploWindowbuilder;
	private JTextField tfNombre;
	private JLabel lblResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploWindowBuilder window = new EjemploWindowBuilder();
					window.frmEjemploWindowbuilder.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EjemploWindowBuilder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEjemploWindowbuilder = new JFrame();
		frmEjemploWindowbuilder.setTitle("Ejemplo WindowBuilder");
		frmEjemploWindowbuilder.setBounds(100, 100, 625, 399);
		frmEjemploWindowbuilder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEjemploWindowbuilder.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelSuperior = new JPanel();
		FlowLayout fl_panelSuperior = (FlowLayout) panelSuperior.getLayout();
		fl_panelSuperior.setAlignment(FlowLayout.LEFT);
		frmEjemploWindowbuilder.getContentPane().add(panelSuperior);
		
		JLabel lblNombre = new JLabel("Nombre");
		panelSuperior.add(lblNombre);
		
		tfNombre = new JTextField();
		panelSuperior.add(tfNombre);
		tfNombre.setColumns(10);
		
		JButton btnSaludar = new JButton("Saludar");
		btnSaludar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblResultado.setText("Hola " + tfNombre.getText());
			}
		});
		panelSuperior.add(btnSaludar);
		
		JPanel panelInferior = new JPanel();
		FlowLayout fl_panelInferior = (FlowLayout) panelInferior.getLayout();
		fl_panelInferior.setAlignment(FlowLayout.LEFT);
		frmEjemploWindowbuilder.getContentPane().add(panelInferior);
		
		lblResultado = new JLabel("Introduce tu nombre");
		panelInferior.add(lblResultado);
	}

}
