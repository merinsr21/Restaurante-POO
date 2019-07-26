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
		System.out.println("                   "+"MEN�\n");
		System.out.println("C�digo |           Nombre            |   Precio    |    Calor�as   ");
		for(Map.Entry<String, Comida> co : Datos.menuComidas.entrySet()) {
			Comida c = co.getValue();
			System.out.println(c);
		}
	}
	
	public String toString() {
		return "Ver Men� de comidas";
	}
}
