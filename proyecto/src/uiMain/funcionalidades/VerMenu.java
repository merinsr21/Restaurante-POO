package uiMain.funcionalidades;
import uiMain.*;
import gestorAplicacion.logic.Comida;

public class VerMenu extends OpcionDeMenu {
	
	public VerMenu(String pos) {
		super(pos);
	}
	public VerMenu() {
		
	}
	public void ejecutar() {
		System.out.println("     "+"MENÚ");
		System.out.println("Código | Nombre | Precio");
		for(Comida r : Comida.getMenu()) {
			System.out.println(r);
		}
	}
	
	public String toString() {
		return "Ver Menú de comidas";
	}
}
