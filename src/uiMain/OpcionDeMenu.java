package uiMain;

import java.util.HashMap;
import java.util.Map;

import modelo.BaseDatos.Datos;

public abstract class OpcionDeMenu {
	
	private String pos;
	public static HashMap<String, OpcionDeMenu> funcionalidades = new HashMap<String, OpcionDeMenu>();

	
	public OpcionDeMenu() {
		
	}
	
	public OpcionDeMenu(String pos) {
		this.pos = pos;
	}
	
	public String getPos() {
		return pos;
	}
	
	public void setPos(String pos) {
		this.pos = pos;
	}
	
	public abstract void ejecutar();
	
	public abstract String toString();
	
	public static void mostrarFuncionalidades() {
		int i = 1;
		for (Map.Entry<String, OpcionDeMenu> opcionDeMenu : OpcionDeMenu.funcionalidades.entrySet()) {   //mostrar funcionalidades de la opci�n de men�.
			System.out.println(i + " "+opcionDeMenu.getValue());
			i++;
		}
	}
}
