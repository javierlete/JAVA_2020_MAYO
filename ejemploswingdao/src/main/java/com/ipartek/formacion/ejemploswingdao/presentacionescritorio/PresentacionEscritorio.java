package com.ipartek.formacion.ejemploswingdao.presentacionescritorio;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.ipartek.formacion.ejemploswingdao.accesodatos.MuebleDAO;
import com.ipartek.formacion.ejemploswingdao.modelos.Mueble;
import java.awt.Color;

public class PresentacionEscritorio {

	private JFrame frame;
	private JTable tabla;
	private JLabel lblId;
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtLargo;
	private JTextField txtAncho;
	private JTextField txtAlto;

	private DefaultTableModel modelo; // Modelo utilizado para la tabla
	private JButton btnModificar;
	private JButton btnBorrar;
	private JLabel lblErrorLargo;
	private JLabel lblErrorAncho;
	private JLabel lblErrorAlto;
	private JLabel lblErrorNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PresentacionEscritorio window = new PresentacionEscritorio();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PresentacionEscritorio() {
		// Necesario hacerlo antes de que se monte la pantalla
		Object[] columnas = { "Id", "Nombre", "Largo", "Ancho", "Alto" };

		modelo = new DefaultTableModel(columnas, 0);

		initialize(); // Introducido por el WindowBuilder

		// Esto lo haremos después de que ya se haya creado la pantalla
		cargarListado();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 452, 617);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 450, 269);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		lblId = new JLabel("Id");
		lblId.setHorizontalAlignment(SwingConstants.TRAILING);
		lblId.setBounds(22, 12, 67, 25);
		panel.add(lblId);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(97, 10, 53, 30);
		panel.add(txtId);
		txtId.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNombre.setBounds(22, 50, 67, 25);
		panel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(97, 48, 341, 30);
		panel.add(txtNombre);

		JLabel lblLargo = new JLabel("Largo");
		lblLargo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLargo.setBounds(22, 102, 67, 25);
		panel.add(lblLargo);

		txtLargo = new JTextField();
		txtLargo.setColumns(10);
		txtLargo.setBounds(97, 100, 341, 30);
		panel.add(txtLargo);

		JLabel lblAncho = new JLabel("Ancho");
		lblAncho.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAncho.setBounds(22, 154, 67, 25);
		panel.add(lblAncho);

		txtAncho = new JTextField();
		txtAncho.setColumns(10);
		txtAncho.setBounds(97, 152, 341, 30);
		panel.add(txtAncho);

		JLabel lblAlto = new JLabel("Alto");
		lblAlto.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAlto.setBounds(22, 206, 67, 25);
		panel.add(lblAlto);

		txtAlto = new JTextField();
		txtAlto.setColumns(10);
		txtAlto.setBounds(97, 204, 341, 30);
		panel.add(txtAlto);

		JButton btnAceptar = new JButton("Insertar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertarFila();
			}
		});
		btnAceptar.setBounds(347, 12, 91, 25);
		panel.add(btnAceptar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarFila();
			}
		});
		btnModificar.setBounds(250, 12, 99, 25);
		panel.add(btnModificar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrar();
			}
		});
		btnBorrar.setBounds(174, 12, 79, 25);
		panel.add(btnBorrar);

		lblErrorLargo = new JLabel("");
		lblErrorLargo.setForeground(Color.RED);
		lblErrorLargo.setBounds(97, 129, 341, 24);
		panel.add(lblErrorLargo);

		lblErrorAncho = new JLabel("");
		lblErrorAncho.setForeground(Color.RED);
		lblErrorAncho.setBounds(97, 181, 341, 24);
		panel.add(lblErrorAncho);

		lblErrorAlto = new JLabel("");
		lblErrorAlto.setForeground(Color.RED);
		lblErrorAlto.setBounds(97, 233, 341, 24);
		panel.add(lblErrorAlto);

		lblErrorNombre = new JLabel("");
		lblErrorNombre.setForeground(Color.RED);
		lblErrorNombre.setBounds(97, 77, 341, 24);
		panel.add(lblErrorNombre);

		tabla = new JTable(modelo); // Hacemos referencia al modelo de la tabla en el constructor de la tabla
		tabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				filaARegistro(e);
			}
		});

		JScrollPane scrollPane = new JScrollPane(tabla); // Al ScrollPane le pasamos en el constructor el contenido que
															// queremos que tenga
		scrollPane.setBounds(10, 281, 430, 294);
		frame.getContentPane().add(scrollPane);

	}

	protected void filaARegistro(MouseEvent me) {
		try {
			int fila = tabla.rowAtPoint(me.getPoint()); // Coge la fila que se ha pulsado en base a las coordenadas del
														// ratón

			if (fila > -1) {
				Long id = (Long) modelo.getValueAt(fila, 0); // Sacamos el id de la fila correspondiente (pulsada)

				Mueble mueble = MuebleDAO.obtenerPorId(id);

				objetoARegistro(mueble);
			}

			cargarListado();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}

	private void objetoARegistro(Mueble mueble) {
		txtId.setText(mueble.getId() != null ? mueble.getId().toString() : "");
		txtNombre.setText(mueble.getNombre());
		txtLargo.setText(mueble.getLargo() != null ? mueble.getLargo().toString() : "");
		txtAncho.setText(mueble.getAncho() != null ? mueble.getAncho().toString() : "");
		txtAlto.setText(mueble.getAlto() != null ? mueble.getAlto().toString() : "");

		lblErrorNombre.setText(mueble.getErrorNombre());
		lblErrorLargo.setText(mueble.getErrorLargo());
		lblErrorAncho.setText(mueble.getErrorAncho());
		lblErrorAlto.setText(mueble.getErrorAlto());
	}

	protected void insertarFila() {
		try {
			Mueble mueble = registroAObjeto();

			if (mueble.isCorrecto()) {
				MuebleDAO.insertar(mueble);
				vaciarRegistro();
			}

			cargarListado();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	private Mueble registroAObjeto() {
		Mueble mueble = new Mueble(txtId.getText(), txtNombre.getText(), txtLargo.getText(), txtAncho.getText(),
				txtAlto.getText());

		objetoARegistro(mueble);

		return mueble;
	}

	protected void modificarFila() {
		try {
			Mueble mueble = registroAObjeto();

			if (mueble.isCorrecto()) {
				MuebleDAO.modificar(mueble);
			}

			cargarListado();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}

	protected void borrar() {
		try {
			Mueble mueble = new Mueble();

			mueble.setId(txtId.getText());

			if (mueble.getId() != null) {
				MuebleDAO.borrar(mueble.getId());
			} else {
				throw new Exception("Selecciona una fila para borrar");
			}

			cargarListado();

			vaciarRegistro();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}

	private void vaciarRegistro() {
		txtId.setText("");
		txtNombre.setText("");
		txtLargo.setText("");
		txtAncho.setText("");
		txtAlto.setText("");

		limpiarErrores();
	}

	private void limpiarErrores() {
		lblErrorNombre.setText("");
		lblErrorLargo.setText("");
		lblErrorAncho.setText("");
		lblErrorAlto.setText("");
	}

	private void cargarListado() {
		modelo.setRowCount(0);

		Object[] fila;

		for (Mueble mueble : MuebleDAO.obtenerTodos()) {
			fila = new Object[] { mueble.getId(), mueble.getNombre(), mueble.getLargo(), mueble.getAncho(),
					mueble.getAlto() };
			modelo.addRow(fila); // Añade una fila al final
		}
	}
}
