package uiMain.funcionalidades;

import uiMain.*;
import gestorAplicacion.logic.*;
import java.util.*;

public class OrdenarMenu extends OpcionDeMenu{
	
	public OrdenarMenu(String pos) {
		super(pos);
	}
	
	public void ejecutar() {
		Collections.sort(Comida.getMenuC());
		for(Comida r: Comida.getMenuC()) {
			System.out.println(r);
		}
	}
	
	public String toString() {
		return "Ordenar el menú de acuerdo al precio y mostrarlo";
	}
}
