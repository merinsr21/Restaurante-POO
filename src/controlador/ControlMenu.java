package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import main.Principal;
import vista.PanelMenuComida;
import vista.VentanaPrincipal;
import uiMain.Main;

public class ControlMenu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String menuAccionado = e.getActionCommand();
		if(menuAccionado.equals("Salir")) {
			Principal.ventana.cerrar();
			Principal.ventana = new VentanaPrincipal();
			Principal.ventana.arranca();
			Main.datos.guardarDatos();
		}else if(menuAccionado.equals("Ver Menú de Comidas")) {
			PanelMenuComida.panelMenu.setVisible(true);
		}else if(menuAccionado.equals("Acerca de..")) {
			JOptionPane.showMessageDialog(null, "Autores: Laura Bustamante Hurtado\n"+"Felipe Merino Toro\n"+ "Cristian Rojas Mazo"+"\n"+"Alejandro Gómez Serna");
		}
	}

}
