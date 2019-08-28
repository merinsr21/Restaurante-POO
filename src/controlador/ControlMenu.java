package controlador;

import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;

import main.Principal;
import vista.*;
import uiMain.Main;

public class ControlMenu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JFrame ventana = (JFrame) Principal.ventana;
		
		String menuAccionado = e.getActionCommand();
		
		Container contenedor = ventana.getContentPane();
		contenedor.removeAll();

		if(menuAccionado.equals("Salir")) {
			Principal.ventana.cerrar();
			Principal.ventana = new VentanaPrincipal();
			Principal.ventana.arranca();
			Main.datos.guardarDatos();
		}else if(menuAccionado.equals("Ver Menú de Comidas")) {
			contenedor.add(new PanelMenuComida());
		}else if(menuAccionado.equals("Acerca de..")) {
			JOptionPane.showMessageDialog(null, "Autores: Laura Bustamante Hurtado\n"+"Felipe Merino Toro\n"+ "Cristian Rojas Mazo"+"\n"+"Alejandro Gómez Serna");
		}else if(menuAccionado.equals("Crear mesas")) {
			contenedor.add(new PanelCrearMesa());
		}else if(menuAccionado.equals("Ver mesas disponibles")) {
			
		}else if(menuAccionado.equals("Ver Ganancias del día")) {
			
		}
		ventana.pack();
	}

}
