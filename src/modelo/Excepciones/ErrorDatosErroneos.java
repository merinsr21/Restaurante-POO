package modelo.Excepciones;

public class ErrorDatosErroneos extends Exception {
	public ErrorDatosErroneos() {
		super("Los datos ingresados no han sido encontrados.");
	}
}
