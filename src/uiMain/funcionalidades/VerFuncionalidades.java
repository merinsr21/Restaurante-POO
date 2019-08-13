package uiMain.funcionalidades;

import java.util.Scanner;

import modelo.gestorAplicacion.users.Usuario;
import uiMain.OpcionDeMenu;

public class VerFuncionalidades extends OpcionDeMenu {
	
	public VerFuncionalidades(String pos){
		super(pos);
	}
	
	@Override
	public void ejecutar() {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Ingrese el nombre de usuario: ");
		String nombreUsuario = entrada.next();
		Usuario usuario = Usuario.getUsuarioConNombreUsuario(nombreUsuario);
		usuario.getMenu().verOpcion();
	}

	@Override
	public String toString() {
		return "Ver funcionalidades de un usuario";
	}

}
