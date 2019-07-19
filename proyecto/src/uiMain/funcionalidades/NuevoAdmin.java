package uiMain.funcionalidades;

import java.util.Scanner;

import BaseDatos.Datos;
import gestorAplicacion.users.Administrador;
import gestorAplicacion.users.Usuario;
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
		System.out.print("Ingrese su correo electr�nico: ");
		String correo = entrada.next();
		System.out.print("Ingrese su contrase�a: ");
		String contrase�a = entrada.next();
		Administrador.nuevoAdministrador(nombre, nombreUsuario, correo, contrase�a);
	}

	@Override
	public String toString() {
		return "Crear nuevo usuario administrador";
	}

}
