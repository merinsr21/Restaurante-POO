package uiMain.funcionalidades;

import java.util.Scanner;

import modelo.BaseDatos.Datos;
import modelo.gestorAplicacion.users.Usuario;
import uiMain.OpcionDeMenu;

public class Registrarse extends OpcionDeMenu {
	@Override
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
		Usuario.nuevoUsuario(nombre, nombreUsuario, correo, contraseña);
	}

	@Override
	public String toString() {
		return "Registrarse";
	}

}
