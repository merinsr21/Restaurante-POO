package uiMain.funcionalidades;

import java.util.Scanner;

import gestorAplicacion.users.Usuario;
import uiMain.OpcionDeMenu;

public class A�adirOpcion extends OpcionDeMenu{
	
	public A�adirOpcion(String pos){
		super(pos);
	}
	
	@Override
	public void ejecutar() {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Ingrese el nombre de usuario al cual le quiere a�adir la funcionalidad: ");
		String nombreUsuario = entrada.next();
		Usuario usuario = Usuario.getUsuarioConNombreUsuario(nombreUsuario);
		OpcionDeMenu.mostrarFuncionalidades();
		System.out.print("Ingrese el n�mero de la funcionalidad a a�adir: ");
		String op = entrada.next();
		usuario.getMenu().a�adirOpcion(op);
		System.out.println("La funcionalidad ha sido a�adida al usuario.");
	}

	@Override
	public String toString() {
		return "A�adir funcionalidades a un usuario";
	}

}
