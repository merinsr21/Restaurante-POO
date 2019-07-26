package uiMain.funcionalidades;

import java.util.*;

import gestorAplicacion.users.*;
import uiMain.OpcionDeMenu;

public class EditarUsuario extends OpcionDeMenu {
	
	public EditarUsuario(String pos) {
		super(pos);
	}
	
	public void ejecutar() {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Ingrese el nombre de usuario: ");
		String nombre = entrada.next();
		Usuario usuario = Usuario.getUsuarioConNombreUsuario(nombre);
		System.out.print("Ingrese 1 para cambiar el nombre o ingrese 2 para cambiar la contraseña: ");
		int opcion = entrada.nextInt();
		System.out.print("Ingrese el cambio que quiere generar de acuerdo a la opción escogida: ");
		String valor = entrada.next();
		Usuario.editarUsuario(usuario, opcion, valor);
		System.out.println("¡El usuario ha sido editado con éxito!");

	}
	
	public String toString() {
		return "Editar usuario";
	}

}
 
