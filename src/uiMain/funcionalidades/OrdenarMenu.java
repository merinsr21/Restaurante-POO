package uiMain.funcionalidades;

import uiMain.*;

import java.util.*;

import modelo.gestorAplicacion.logic.*;

public class OrdenarMenu extends OpcionDeMenu{
	
	public OrdenarMenu(String pos) {
		super(pos);
	}
	
	public void ejecutar() {
		//ver que se puede hacer con esto, porque esos son metodos del arreglo que habia en Comida y se necesita usar solo la hash
		Collections.sort(Comida.getMenuComida());
		for(Comida comida: Comida.getMenuComida()) {
			System.out.println(comida);
		}
	}
	
	public String toString() {
		return "Ordenar el menú de acuerdo al precio y mostrarlo";
	}
}
