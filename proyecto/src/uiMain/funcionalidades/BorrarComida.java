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
		String print = "La comida que desea borrar no se encuentra en el menú.";;
		for(Comida r :  Comida.getMenuC()) {
			if(r.getCodigo().equals(n)) {
				print = r.getNombre()+" "+"ha sido eliminada del menú.";
				Comida.getMenuC().remove(r);
				Comida gc = Datos.menuComidas.get(r.getCodigo());
				Datos.menuComidas.remove(gc);
				break;
			}
		}
		System.out.println(print);
	}
	
	
	public String toString() {
		return "Borrar comida del menú";
	}
}
