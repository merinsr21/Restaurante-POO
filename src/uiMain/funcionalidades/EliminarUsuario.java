package uiMain.funcionalidades;

import java.util.*;

import gestorAplicacion.users.*;
import uiMain.OpcionDeMenu;

public class EliminarUsuario extends OpcionDeMenu{
	
	public EliminarUsuario(String pos) {
		super(pos);
	}
	
	public void ejecutar() {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Ingrese el nombre de usuario:");
		String nombre = entrada.next();
		System.out.print("¿Está seguro de esa decisión? (Ingrese "+"si"+" si su respuesta es afirmativa o "+"no"+"en caso contrario):");
		String d = entrada.next();
		if(d.equals("si")) {
			Usuario.eliminarUsuario(nombre);
			System.out.println("El usuario se ha eliminado.");
		}else {
			System.out.println("El usuario no se ha eliminado.");
		}
		
	}
	
	public String toString() {
		return "Eliminar un usuario";
	}

}
