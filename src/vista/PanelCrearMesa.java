package vista;

import java.awt.*;
import javax.swing.*;

import controlador.ControlCrearMesa;

public class PanelCrearMesa extends JPanel{
	JPanel panelGeneral, panelNombre, panelDescripcion, panelDatosExterior, panelDatos, panelBotonAceptar, panelBotonBorrar;
	JLabel nombreFuncionalidad, codigoMesa, cantidadSillas;
	JTextField codigo, cantidad;
	JButton aceptar, borrar;
	
	public PanelCrearMesa() {
		panelGeneral = new JPanel();
		panelGeneral.setLayout(new BorderLayout());
		
		panelNombre = new JPanel();
		nombreFuncionalidad = new JLabel("Crear Mesas");
		panelNombre.add(nombreFuncionalidad);
		panelGeneral.add(panelNombre, BorderLayout.NORTH);
		
		panelDescripcion = new JPanel();
		TextArea descripcion = new TextArea("En esta funcionalidad se le solicitan al Administrador ciertos parámetros "
				+ "para crear una mesa y se añada al inventario del restaurante.");
		panelDescripcion.add(descripcion);
		panelGeneral.add(panelDescripcion, BorderLayout.CENTER);
		
		panelDatosExterior = new JPanel();
		panelDatosExterior.setLayout(new BorderLayout());
		
		panelDatos = new JPanel();
		panelDatos.setLayout(new GridLayout(3,3));
		codigoMesa = new JLabel("Código de la mesa");
		cantidadSillas = new JLabel("Cantidad de sillas");
		codigo = new JTextField();
		cantidad = new JTextField();
		panelDatos.add(codigoMesa);
		panelDatos.add(codigo);
		panelDatos.add(cantidadSillas);
		panelDatos.add(cantidad);
		panelDatosExterior.add(panelDatos, BorderLayout.SOUTH);
		
		//botones
		aceptar = new JButton("Aceptar");
		aceptar.addActionListener(new ControlCrearMesa());
		borrar = new JButton("Borrar");
		borrar.addActionListener(new ControlCrearMesa());
		
		panelBotonAceptar = new JPanel();
		panelBotonAceptar.setLayout(null);
		aceptar.setBounds(150, 150, 50, 30);
		panelBotonAceptar.add(aceptar);
		panelDatos.add(panelBotonAceptar);
		
		panelBotonBorrar = new JPanel();
		panelBotonBorrar.setLayout(null);
		borrar.setBounds(150, 150, 50, 30);
		panelBotonBorrar.add(borrar);
		panelDatos.add(panelBotonBorrar);

		
		
	
		
	
		
	}
	
	

}
