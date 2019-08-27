package main;

import vista.InterfazVista;
import vista.VentanaPrincipal;
import vista.VentanaUsuario;

public class Principal {
	
	public static InterfazVista ventana = new VentanaPrincipal();

	public static void main(String[] args) {
		ventana.arranca();
	}
}
