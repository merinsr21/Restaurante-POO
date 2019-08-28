package controlador;

import java.awt.event.*;

import javax.swing.JOptionPane;

import modelo.gestorAplicacion.logic.*;
import modelo.gestorAplicacion.users.Usuario;
import uiMain.Main;

public class ControlMenuComida implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String evento = e.getActionCommand();
		String codigo = "";
		int cantidad = 0;
		if(evento.equals("Añadir al carrito")) {
			codigo = JOptionPane.showInputDialog(null, 
	               "Ingrese el código de la comida que desee agregar al carrito");
			cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, 
		               "Ingrese la cantidad de la comida que desee agregar al carrito"));
		}
		Comida comida = Comida.getComidaConCodigo(codigo);
		Usuario usuario = Main.usuario;
		Carrito miCarrito = usuario.getMiCarrito();
		miCarrito.añadirComida(comida, cantidad);
	}
	
	
	
	public static String arreglo() {
		String texto = "";
		for(Comida comida : Comida.obtenerComidasDisponibles()) {
			texto += "/n"+comida.toString();
		}
		return texto;
	}
}
