package modelo.Excepciones;

import javax.swing.JOptionPane;

public class ErrorCamposIncompletos extends Exception {
	
	
	public ErrorCamposIncompletos() {
		super("Campos incompletos, por favor llenarlos para continuar.");
	}
}
