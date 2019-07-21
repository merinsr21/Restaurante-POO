package uiMain;

import java.util.Map;

import BaseDatos.Datos;

public abstract class OpcionDeMenu {
	
	private String pos;
	
	
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
		for (Map.Entry<String, OpcionDeMenu> opcionDeMenu : Datos.funcionalidades.entrySet()) {   //mostrar funcionalidades de la opción de menú.
			System.out.println(i + " "+opcionDeMenu.getValue());
			i++;
		}
	}
}
