package uiMain.funcionalidades;

import java.util.Scanner;
import gestorAplicacion.users.*;
import uiMain.*;

public class NuevoChef extends OpcionDeMenu {

	public NuevoChef(String pos) {
		super(pos);
	}
	
	public void ejecutar() {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Ingrese su nombre: ");
		String nombre = entrada.next();
		System.out.print("Ingrese su nombre de usuario: ");
		String nombreUsuario = entrada.next();
		System.out.print("Ingrese su correo electr�nico: ");
		String correo = entrada.next();
		System.out.print("Ingrese su contrase�a: ");
		String contrase�a = entrada.next();
		Chef.nuevoChef(nombre, nombreUsuario, correo, contrase�a);
		System.out.println("Chef creado.");
	}
	
	public String toString() {
		return "Crear nuevo chef";
	}
}
