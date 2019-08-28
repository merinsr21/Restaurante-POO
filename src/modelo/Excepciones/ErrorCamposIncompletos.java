package modelo.Excepciones;

import javax.swing.JOptionPane;

public class ErrorCamposIncompletos extends Exception {
	
	
	public ErrorCamposIncompletos() {
		super("Por favor llene los campos vacíos para continuar.");
	}
}
