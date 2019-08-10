package uiMain.funcionalidades;

import uiMain.*;
import gestorAplicacion.logic.*;
import java.util.*;

public class OrdenarMenu extends OpcionDeMenu{
	
	public OrdenarMenu(String pos) {
		super(pos);
	}
	
	public void ejecutar() {
		Collections.sort(Comida.getMenuComida());
		for(Comida comida: Comida.getMenuComida()) {
			System.out.println(comida);
		}
	}
	
	public String toString() {
		return "Ordenar el menú de acuerdo al precio y mostrarlo";
	}
}
