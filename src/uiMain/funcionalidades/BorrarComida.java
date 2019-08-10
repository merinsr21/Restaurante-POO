package uiMain.funcionalidades;

import java.util.*;

import BaseDatos.Datos;
import gestorAplicacion.logic.*;
import uiMain.*;

public class BorrarComida extends OpcionDeMenu {
	
	public BorrarComida(String pos) {
		super(pos);
	}
	
	public void ejecutar() {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Ingrese el código de la comida que desea borrar:");
		String codigoComida = entrada.next();
		Comida.borrarComida(codigoComida);
	}
	
	
	public String toString() {
		return "Borrar comida del menú";
	}
}
