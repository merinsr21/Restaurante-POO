package vista;

import javax.swing.*;

import java.util.*;


import javax.swing.table.TableCellRenderer;

import controlador.tableButton.*;
import modelo.gestorAplicacion.logic.*;
import modelo.gestorAplicacion.users.Usuario;


public class PanelPedido extends JPanel{
	JTable table;
	public PanelPedido(){
		HashMap<Comida, Integer> carrito = Usuario.usuario.getMiCarrito().verCarrito();
		String nombreBoton = "Eliminar";
		String [] nombreColumnas = {"Código", "Nombre", "Precio","Cantidad","Subtotal", nombreBoton};
		Object [][] datos = new Object [carrito.size()][nombreColumnas.length];
		int contador = 0;
		for(Map.Entry<Comida, Integer> producto : carrito.entrySet()) {
			Comida objetoProducto = producto.getKey();
			int cantidad = producto.getValue();
			
			JButton boton = new JButton(nombreBoton);
			boton.setActionCommand(objetoProducto.getCodigoComida());
			boton.addActionListener(new ControlTableButtonPedidos());
			
			datos[contador][0]= objetoProducto.getCodigoComida();
			datos[contador][1]= objetoProducto.getNombreComida();
			datos[contador][2]= objetoProducto.getPrecioComida();
			datos[contador][3]= cantidad;
			datos[contador][4]= objetoProducto.precioTotalComida();
			datos[contador][5]= boton;
			contador++;
		}
		
		table = new JTable(new TablaModelo(nombreColumnas,datos)); 
		table.setFillsViewportHeight(true);
		TableCellRenderer buttonRenderer = new JTableButtonRenderer();
	    table.getColumn(nombreBoton).setCellRenderer(buttonRenderer);
	    table.addMouseListener(new TablaMouseListener(table));
	    
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);

	}
}
