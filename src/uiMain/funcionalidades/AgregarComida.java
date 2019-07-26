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
		System.out.println("Ingrese el código(100-199), nombre, precio y calorias de la comida que desea agregar en el menú: ");	
		String c = entrada.next();
		String n = entrada.next();
		String p = entrada.next();
		String ca = entrada.next();
		String print = "El código no se encuentra en el intervalo exigido, 100-199";
		if(Integer.parseInt(c) >= 100 && Integer.parseInt(c) <= 199) {
			if(!Datos.menuComidas.containsKey(c)) {
				Comida.agregarComida(c, n, p, ca);
				print = "La comida se ha agregado en el menú.";
	
			}else {
				print = "Este código ya se encuenta en el menú. La comida no ha sido agregada al menú.";
			}
		}
		System.out.print(print);
	}
	
	public String toString() {
		return "Agregar comida al menú";
	}
}
