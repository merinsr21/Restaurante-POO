package uiMain.funcionalidades;

import gestorAplicacion.logic.Comida;
import uiMain.*;
import java.util.*;

public class OrdenarMenu extends OpcionDeMenu {
	
	public OrdenarMenu (String pos) {
		super(pos);
	}
	
	public void ejecutar() {
		System.out.println("Ingrese el parámetro con el cual quiere ordenar el menú(1 = código,  2 = nombre, 3 = precio)");
		Collections.sort(Comida.getMenu());
		for(Comida r : Comida.getMenu()) {
			System.out.println(r);
		}
	}
	
	public String toString() {
		return "Ordenar el menú";
	}
}
