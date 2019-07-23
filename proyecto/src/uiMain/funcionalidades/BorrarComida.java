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
		System.out.println("Ingrese el código de la comida que desea borrar:");
		int n = entrada.nextInt();
		String n1 = Integer.toString(n);
		String print = "La comida que desea borrar no se encuentra en el menú.";
		for(Map.Entry<String, Comida> comida : Datos.menuComidas.entrySet()) {
			String r = comida.getKey();
			Comida r2 = comida.getValue();
				if(r.equals(n1)) {
					print = r2.getNombre()+" "+"ha sido eliminada del menú.";
					Comida.getMenuC().remove(r2);
					Datos.menuComidas.remove(r);
					break;
				}						
		}
		System.out.println(print);
	}
	
	
	public String toString() {
		return "Borrar comida del menú";
	}
}
