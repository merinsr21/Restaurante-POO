package uiMain.funcionalidades;

import java.util.*;
import gestorAplicacion.logic.Comida;
import uiMain.*;

public class AgregarComida extends OpcionDeMenu {
	
	public AgregarComida(String pos) {
		super(pos);
	}
	
	public void ejecutar() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingrese el código, nombre, precio y calorias de la comida que desea agregar en el menú:");	
		String c = entrada.next();
		String n = entrada.next();
		String p = entrada.next();
		String ca = entrada.next();
		Comida.agregarComida(c, n, p, ca);
	}
	
	public String toString() {
		return "Agregar comida al menú";
	}
}
