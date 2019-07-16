package uiMain.funcionalidades;

import java.util.Scanner;

import gestorAplicacion.users.Usuario;
import uiMain.OpcionDeMenu;

public class AñadirOpcion extends OpcionDeMenu{
	
	public AñadirOpcion(String pos){
		super(pos);
	}
	
	@Override
	public void ejecutar() {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Ingrese el nombre de usuario: ");
		String nombreUsuario = entrada.next();
		Usuario usuario = Usuario.getUsuarioConNombreUsuario(nombreUsuario);
		OpcionDeMenu.mostrarFuncionalidades();
		System.out.print("Ingrese el número de la funcionalidad a añadir: ");
		String op = entrada.next();
		usuario.getMenu().añadirOpcion(op);
	}

	@Override
	public String toString() {
		return "Añadir funcionalidades a un usuario";
	}

}
