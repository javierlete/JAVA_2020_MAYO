package com.ipartek.formacion.ejemplomvc.escritorio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import com.ipartek.formacion.ejemplomvc.accesodatos.Dao;
import com.ipartek.formacion.ejemplomvc.accesodatos.DaoFabrica;
import com.ipartek.formacion.ejemplomvc.modelos.Usuario;

public class Escritorio {

	private JFrame frame;
	private JTextField tfEmail;
	private JTextField tfPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Escritorio window = new Escritorio();
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
	public Escritorio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(22, 35, 70, 15);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(22, 78, 70, 15);
		frame.getContentPane().add(lblPassword);
		
		JButton btnNewButton = new JButton("Cargar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dao<Usuario> dao = DaoFabrica.getInstancia().getDaoUsuario();
				
				Usuario primero = dao.obtenerPorId(1L);
				
				tfEmail.setText(primero.getEmail());
				tfPassword.setText(primero.getPassword());
			}
		});
		btnNewButton.setBounds(22, 105, 117, 25);
		frame.getContentPane().add(btnNewButton);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(128, 33, 114, 19);
		frame.getContentPane().add(tfEmail);
		tfEmail.setColumns(10);
		
		tfPassword = new JTextField();
		tfPassword.setBounds(128, 76, 114, 19);
		frame.getContentPane().add(tfPassword);
		tfPassword.setColumns(10);
	}
}
