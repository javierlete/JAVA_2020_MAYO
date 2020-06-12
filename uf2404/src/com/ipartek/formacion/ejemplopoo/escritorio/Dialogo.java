package com.ipartek.formacion.ejemplopoo.escritorio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Dialogo {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Ejemplo de diálogo");
		frame.setBounds(100,100,400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton boton = new JButton("Púlsame");
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "My Goodness, this is so concise");
			}
		});
		
		frame.add(boton);
		
		frame.setVisible(true);
		
		
		
		
	}

}
