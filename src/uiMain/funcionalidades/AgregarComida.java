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
		System.out.println("Ingrese el c�digo(100-199), nombre, precio y calorias de la comida que desea agregar en el men�: ");	
		String c = entrada.next();
		String n = entrada.next();
		String p = entrada.next();
		String ca = entrada.next();
		String print = "El c�digo no se encuentra en el intervalo exigido, 100-199";
		if(Integer.parseInt(c) >= 100 && Integer.parseInt(c) <= 199) {
			if(!Datos.menuComidas.containsKey(c)) {
				Comida.agregarComida(c, n, p, ca);
				print = "La comida se ha agregado en el men�.";
	
			}else {
				print = "Este c�digo ya se encuenta en el men�. La comida no ha sido agregada al men�.";
			}
		}
		System.out.print(print);
	}
	
	public String toString() {
		return "Agregar comida al men�";
	}
}
