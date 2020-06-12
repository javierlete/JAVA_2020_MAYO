package com.ipartek.formacion.ejemplopoo.escritorio.componentes;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class Principal {

	private JFrame frame;
	
	private Primero primero;
	private Segundo segundo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
		
		primero.getBtnSiguiente().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				primero.setVisible(false);
				frame.getContentPane().add(segundo, BorderLayout.CENTER);
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 575, 519);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblAplicacinSuperMega = new JLabel("Aplicación super mega güachi");
		frame.getContentPane().add(lblAplicacinSuperMega, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Copyright 2020 Javier Lete");
		frame.getContentPane().add(lblNewLabel, BorderLayout.SOUTH);
		
		primero = new Primero();
		frame.getContentPane().add(primero, BorderLayout.CENTER);
		
		segundo = new Segundo();
		frame.getContentPane().add(segundo, BorderLayout.EAST);
	}

}
