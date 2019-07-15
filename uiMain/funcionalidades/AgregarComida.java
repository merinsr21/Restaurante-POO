package uiMain.funcionalidades;

import java.util.*;
import gestorAplicacion.logic.Comida;
import uiMain.*;

public class AgregarComida extends OpcionDeMenu {
	
	public AgregarComida(int pos) {
		super(pos);
	}
	
	public void ejecutar() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Ingrese el codigo, nombre y precio de la comida que desea agregar en el menu");	
		int c = entrada.nextInt();
		String n = entrada.next();
		int p = entrada.nextInt();
		Comida.agregarComida(c, n, p);
	}
	
	public String toString() {
		return "Agrega una comida al menu para que esta pueda ser pedida por un usuario";
	}
}
