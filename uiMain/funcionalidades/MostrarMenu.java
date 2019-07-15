package uiMain.funcionalidades;
import uiMain.*;
import gestorAplicacion.logic.Comida;

public class MostrarMenu extends OpcionDeMenu {
	
	public MostrarMenu(int pos) {
		super(pos);
	}
	
	public void ejecutar() {
		System.out.println("     "+"MENU");
		System.out.println("Codigo | Nombre | Precio");
		for(Comida r : Comida.getMenu()) {
			System.out.println(r);
		}
	}
	
	public String toString() {
		return "Muestra las comidas disponibles para pedir";
	}
}
