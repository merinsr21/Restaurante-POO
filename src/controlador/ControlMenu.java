package controlador;

import java.awt.event.*;
import javax.swing.*;

import main.Principal;
import vista.*;
import uiMain.Main;

public class ControlMenu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String menuAccionado = e.getActionCommand();
		if(Principal.ventana instanceof VentanaAdministrador) {
			VentanaAdministrador.contenedor.removeAll();
		}else if(Principal.ventana instanceof VentanaUsuario) {
			VentanaUsuario.contenedor.removeAll();
		}else {
			VentanaChef.contenedor.removeAll();
		}

		if(menuAccionado.equals("Salir")) {
			Principal.ventana.cerrar();
			Principal.ventana = new VentanaPrincipal();
			Principal.ventana.arranca();
			Main.datos.guardarDatos();
		}else if(menuAccionado.equals("Ver Menú de Comidas")) {
			VentanaUsuario.contenedor.add(new PanelMenuComida());
		}else if(menuAccionado.equals("Acerca de..")) {
			JOptionPane.showMessageDialog(null, "Autores: Laura Bustamante Hurtado\n"+"Felipe Merino Toro\n"+ "Cristian Rojas Mazo"+"\n"+"Alejandro Gómez Serna");
		}else if(menuAccionado.equals("Crear mesas")) {
			VentanaAdministrador.contenedor.add(new PanelCrearMesa());
		}else if(menuAccionado.equals("Ver mesas disponibles")) {
			
		}else if(menuAccionado.equals("Ver Ganancias del día")) {
			
		}
		VentanaPrincipal.ventana.pack();
	}

}
