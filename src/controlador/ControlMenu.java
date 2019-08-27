package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.Principal;
import vista.VentanaMenuComida;
import vista.VentanaPrincipal;

public class ControlMenu implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String menuAccionado = e.getActionCommand();
		if(menuAccionado.equals("Salir")) {
			Principal.ventana.cerrar();
			Principal.ventana = new VentanaPrincipal();
			Principal.ventana.arranca();
		}else if(menuAccionado.equals("Ver Menú de Comidas")) {
			VentanaPrincipal.contenedor.add(new VentanaMenuComida());
		}
	}

}
