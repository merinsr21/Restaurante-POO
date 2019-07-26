package uiMain.funcionalidades;
import uiMain.*;

import java.util.Map;
import java.util.TreeMap;

import BaseDatos.Datos;
import gestorAplicacion.logic.Comida;

public class VerMenu extends OpcionDeMenu {
	
	public VerMenu(String pos) {
		super(pos);
	}
	public VerMenu() {
		
	}
	public void ejecutar() {
		System.out.println("                   "+"MENÚ\n");
		System.out.println("Código |           Nombre            |   Precio    |    Calorías   ");
		for(Map.Entry<String, Comida> co : Datos.menuComidas.entrySet()) {
			Comida c = co.getValue();
			System.out.println(c);
		}
	}
	
	public String toString() {
		return "Ver Menú de comidas";
	}
}
