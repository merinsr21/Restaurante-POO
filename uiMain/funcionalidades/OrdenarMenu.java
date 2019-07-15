package uiMain.funcionalidades;

import gestorAplicacion.logic.Comida;
import uiMain.*;
import java.util.*;

public class OrdenarMenu extends OpcionDeMenu {
	
	public OrdenarMenu (int pos) {
		super(pos);
	}
	
	public void ejecutar() {
		System.out.println("Ingrese el parametro con el cual quiere ordenar el menu(1 = codigo,  2 = nombre, 3 = precio)");
		Collections.sort(Comida.getMenu());
		for(Comida r : Comida.getMenu()) {
			System.out.println(r);
		}
	}
	
	public String toString() {
		return "Ordena el menu con base a un parametro (codigo, nombre, precio) y lo muestra";
	}
}
