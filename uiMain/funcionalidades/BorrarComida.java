package uiMain.funcionalidades;

import java.util.*;
import gestorAplicacion.logic.*;
import uiMain.*;

public class BorrarComida extends OpcionDeMenu {
	
	public BorrarComida(int pos) {
		super(pos);
	}
	
	public void ejecutar() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingrese el codigo de la comida que desea borrar.");
		int n = entrada.nextInt();
		String print = "La comida que desea borrar no se encuentra en el menu.";;
		for(Comida r :  Comida.getMenu()) {
			if(r.getCodigo() == n) {
				print = r.getNombre()+" "+"ha sido eliminada del menu.";
				Comida.getMenu().remove(r);
				break;
			}
		}
		System.out.println(print);
	}
	
	
	public String toString() {
		return "Borra una comida del menu para que esta ya no pueda ser pedida por un usuario";
	}
}
