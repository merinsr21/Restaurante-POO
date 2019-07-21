package uiMain.funcionalidades;

import gestorAplicacion.logic.Comida;
import uiMain.*;
import java.util.*;

public class OrdenarMenu extends OpcionDeMenu {
	
	public OrdenarMenu (String pos) {
		super(pos);
	}
	
	public void ejecutar() {
		Collections.sort(Comida.getMenu());
		for(Comida r : Comida.getMenu()) {
			System.out.println(r);
		}
	}
	
	public String toString() {
		return "Ordenar el men� de comidas y mostrarlo";
	}
}
