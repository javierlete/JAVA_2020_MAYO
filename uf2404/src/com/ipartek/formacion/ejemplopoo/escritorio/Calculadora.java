package com.ipartek.formacion.ejemplopoo.escritorio;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculadora {

	private JFrame frame;
	private JTextField txtResultado;
	private JPanel pBotoneraNumerica;
	private double operando1;
	private char operador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora window = new Calculadora();
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
	public Calculadora() {
		initialize();
		
		String[] numeros = { "7", "8", "9", "4", "5", "6", "1", "2", "3", "0" };
		
		JButton boton;
		
		// Código escrito a mano
		for(int i = 0; i < 10; i++) {
			boton = new JButton(numeros[i]);
			boton.addActionListener(e -> { 
				JButton botonPulsado = (JButton) e.getSource();
				txtResultado.setText(txtResultado.getText() + botonPulsado.getText()); 
			});
			
			pBotoneraNumerica.add(boton);
		}
	}

	/** 
				JButton botonPulsado = (JButton) e.getSource();
				txtResultado.setText(txtResultado.getText() + botonPulsado.getText()); 
			
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 387, 417);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtResultado = new JTextField();
		frame.getContentPane().add(txtResultado, BorderLayout.NORTH);
		txtResultado.setColumns(10);
		
		JPanel pBotonera = new JPanel();
		frame.getContentPane().add(pBotonera, BorderLayout.CENTER);
		pBotonera.setLayout(new BorderLayout(10, 10));
		
		pBotoneraNumerica = new JPanel();
		pBotonera.add(pBotoneraNumerica, BorderLayout.CENTER);
		pBotoneraNumerica.setLayout(new GridLayout(0, 3, 10, 10));
		
		JPanel pBotoneraOperaciones = new JPanel();
		pBotonera.add(pBotoneraOperaciones, BorderLayout.EAST);
		pBotoneraOperaciones.setLayout(new GridLayout(0, 1, 10, 10));
		
		JButton btnSumar = new JButton("+");
		btnSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				operando1 = Double.parseDouble(txtResultado.getText());
				operador = '+';
				txtResultado.setText("");
			}
		});
		pBotoneraOperaciones.add(btnSumar);
		
		JButton btnRestar = new JButton("-");
		pBotoneraOperaciones.add(btnRestar);
		
		JButton btnMultiplicar = new JButton("x");
		pBotoneraOperaciones.add(btnMultiplicar);
		
		JButton btnDividir = new JButton("/");
		pBotoneraOperaciones.add(btnDividir);
		
		JButton btnIgual = new JButton("=");
		btnIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double total;
				double operando2 = Double.parseDouble(txtResultado.getText());
				
				switch(operador) {
				case '+':
					total = operando1 + operando2;
					break;
				default:
					txtResultado.setText("No está implementada");
					return;
				}
				
				txtResultado.setText(String.valueOf(total));
			}
		});
		pBotoneraOperaciones.add(btnIgual);
	}

}
