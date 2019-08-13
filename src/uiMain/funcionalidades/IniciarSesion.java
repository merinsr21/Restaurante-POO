package uiMain.funcionalidades;

import java.util.Scanner;

import modelo.gestorAplicacion.users.Usuario;
import uiMain.OpcionDeMenu;

public class IniciarSesion extends OpcionDeMenu{
	@Override
	public void ejecutar() {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Ingrese su usuario: ");
		String nombreUsuario = entrada.next();
		System.out.print("Ingrese su contraseña: ");
		String contraseña = entrada.next();
		
		System.out.println(Usuario.iniciarSesion(nombreUsuario, contraseña));
	}

	@Override
	public String toString() {
		return "Iniciar sesión";
	}

}