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
		System.out.print("Ingrese su correo electrónico: ");
		String correo = entrada.next();
		System.out.print("Ingrese su contraseña: ");
		String contraseña = entrada.next();
		Chef.nuevoChef(nombre, nombreUsuario, correo, contraseña);
		System.out.println("Chef creado.");
	}
	
	public String toString() {
		return "Crear nuevo chef";
	}
}
