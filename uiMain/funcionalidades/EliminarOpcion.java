package uiMain.funcionalidades;

import java.util.Scanner;

import gestorAplicacion.users.Usuario;
import uiMain.OpcionDeMenu;

public class EliminarOpcion extends OpcionDeMenu{
	
	public EliminarOpcion(String pos){
		super(pos);
	}
	
	@Override
	public void ejecutar() {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Ingrese el nombre de usuario: ");
		String nombreUsuario = entrada.next();
		Usuario usuario = Usuario.getUsuarioConNombreUsuario(nombreUsuario);
		usuario.getMenu().verOpcion();
		System.out.print("Ingrese el n�mero de la funcionalidad a remover: ");
		int i = entrada.nextInt();
		usuario.getMenu().eliminarOpcion(i);
	}

	@Override
	public String toString() {
		return "Quitar funcionalidades de un usuario";
	}

}
