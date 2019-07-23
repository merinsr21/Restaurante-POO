package uiMain.funcionalidades;
import uiMain.*;

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
		System.out.println("Código |         Nombre          |   Precio ");
		TreeMap<String, Comida> ordenado = new TreeMap<String, Comida>(Datos.menuComidas);
		for(Comida r : ordenado.values()) {
			System.out.println(r);
		}
	}
	
	public String toString() {
		return "Ver Menú de comidas";
	}
}
