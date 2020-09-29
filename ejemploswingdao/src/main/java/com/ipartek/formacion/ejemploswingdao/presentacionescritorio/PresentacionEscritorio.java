package com.ipartek.formacion.ejemploswingdao.presentacionescritorio;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.ipartek.formacion.ejemploswingdao.accesodatos.MuebleDAO;
import com.ipartek.formacion.ejemploswingdao.modelos.Mueble;

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
		panel.setBounds(0, 0, 450, 219);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		lblId = new JLabel("Id");
		lblId.setHorizontalAlignment(SwingConstants.TRAILING);
		lblId.setBounds(12, 12, 67, 25);
		panel.add(lblId);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(97, 10, 53, 30);
		panel.add(txtId);
		txtId.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNombre.setBounds(12, 57, 67, 25);
		panel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(97, 55, 341, 30);
		panel.add(txtNombre);

		JLabel lblLargo = new JLabel("Largo");
		lblLargo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLargo.setBounds(12, 96, 67, 25);
		panel.add(lblLargo);

		txtLargo = new JTextField();
		txtLargo.setColumns(10);
		txtLargo.setBounds(97, 94, 341, 30);
		panel.add(txtLargo);

		JLabel lblAncho = new JLabel("Ancho");
		lblAncho.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAncho.setBounds(12, 135, 67, 25);
		panel.add(lblAncho);

		txtAncho = new JTextField();
		txtAncho.setColumns(10);
		txtAncho.setBounds(97, 133, 341, 30);
		panel.add(txtAncho);

		JLabel lblAlto = new JLabel("Alto");
		lblAlto.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAlto.setBounds(12, 174, 67, 25);
		panel.add(lblAlto);

		txtAlto = new JTextField();
		txtAlto.setColumns(10);
		txtAlto.setBounds(97, 172, 341, 30);
		panel.add(txtAlto);

		JButton btnAceptar = new JButton("Insertar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertarFila();
			}
		});
		btnAceptar.setBounds(321, 12, 117, 25);
		panel.add(btnAceptar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarFila();
			}
		});
		btnModificar.setBounds(202, 12, 117, 25);
		panel.add(btnModificar);

		tabla = new JTable(modelo); // Hacemos referencia al modelo de la tabla en el constructor de la tabla
		tabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				filaARegistro(e);
			}
		});

		JScrollPane scrollPane = new JScrollPane(tabla); // Al ScrollPane le pasamos en el constructor el contenido que
															// queremos que tenga
		scrollPane.setBounds(10, 223, 430, 352);
		frame.getContentPane().add(scrollPane);

	}

	protected void filaARegistro(MouseEvent e) {
		int fila = tabla.rowAtPoint(e.getPoint());

		if (fila > -1) {
			Mueble mueble = MuebleDAO.obtenerPorId((Long)modelo.getValueAt(fila, 0));
			
			txtId.setText(mueble.getId().toString());
			txtNombre.setText(mueble.getNombre().toString());
			txtLargo.setText(mueble.getLargo().toString());
			txtAncho.setText(mueble.getAncho().toString());
			txtAlto.setText(mueble.getAlto().toString());
			
//			txtId.setText(modelo.getValueAt(fila, 0).toString());
//			txtNombre.setText(modelo.getValueAt(fila, 1).toString());
//			txtLargo.setText(modelo.getValueAt(fila, 2).toString());
//			txtAncho.setText(modelo.getValueAt(fila, 3).toString());
//			txtAlto.setText(modelo.getValueAt(fila, 4).toString());
		}
	}

	protected void insertarFila() {
		Mueble mueble = registroAObjeto();
		
		MuebleDAO.insertar(mueble);

		cargarListado();
		
		vaciarRegistro();
		
//		Object[] fila;
//		fila = new Object[] { txtId.getText(), txtNombre.getText(), txtLargo.getText(), txtAncho.getText(),
//				txtAlto.getText() };
//
//		modelo.addRow(fila); // Añade una fila al final
		// modelo.setValueAt ("nuevo valor", 0, 1); // Cambia el valor de la fila 1,
		// columna 2.
	}

	private Mueble registroAObjeto() {
		Mueble mueble = new Mueble(txtId.getText().trim().length() != 0 ? Long.parseLong(txtId.getText()) : null, txtNombre.getText(), Double.parseDouble(txtLargo.getText()),
				Double.parseDouble(txtAncho.getText()), Double.parseDouble(txtAlto.getText()));
		return mueble;
	}
	
	protected void modificarFila() {
		Mueble mueble = registroAObjeto();
		
		MuebleDAO.modificar(mueble);

		cargarListado();
	}
	
	private void vaciarRegistro() {
		txtId.setText("");
		txtNombre.setText("");
		txtLargo.setText("");
		txtAncho.setText("");
		txtAlto.setText("");
		
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
