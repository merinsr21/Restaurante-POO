package uiMain.funcionalidades;

import java.util.Scanner;

import modelo.BaseDatos.Datos;
import modelo.gestorAplicacion.users.Administrador;
import modelo.gestorAplicacion.users.Usuario;
import uiMain.OpcionDeMenu;

public class NuevoAdmin extends OpcionDeMenu {
	
	public NuevoAdmin(String pos){
		super(pos);
	}
	
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
		Administrador.nuevoAdministrador(nombre, nombreUsuario, correo, contraseña);
		System.out.println("Administrador creado.");
	}

	@Override
	public String toString() {
		return "Crear nuevo usuario administrador";
	}

}
