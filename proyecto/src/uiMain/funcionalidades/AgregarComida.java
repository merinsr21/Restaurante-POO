package uiMain.funcionalidades;

import java.util.*;

import BaseDatos.Datos;
import gestorAplicacion.logic.Comida;
import uiMain.*;

public class AgregarComida extends OpcionDeMenu {
	
	public AgregarComida(String pos) {
		super(pos);
	}
	
	public void ejecutar() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingrese el c�digo, nombre, precio y calorias de la comida que desea agregar en el men�:");	
		String c = entrada.next();
		String n = entrada.next();
		String p = entrada.next();
		String ca = entrada.next();
		if(!Datos.menuComidas.containsKey(c)) {
			Comida.agregarComida(c, n, p, ca);
			System.out.println("La comida se ha agregado en el men�.");

		}else {
			System.out.println("Este c�digo ya se encuenta en el men�. La comida no ha sido agregada al men�.");
		}
	}
	
	public String toString() {
		return "Agregar comida al men�";
	}
}
