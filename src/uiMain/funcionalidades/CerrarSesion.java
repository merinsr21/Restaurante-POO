package uiMain.funcionalidades;

import uiMain.Main;
import uiMain.OpcionDeMenu;
import java.util.*;
import gestorAplicacion.logic.*;
import gestorAplicacion.users.Usuario;

public class CerrarSesion  extends OpcionDeMenu{
	
	public CerrarSesion(String pos){
		super(pos);
	}
	
	@Override
	public void ejecutar() {
		//no es necesario, poner nul al atributo usuario que hay en el main
		Scanner entrada = new Scanner(System.in);
		System.out.print("Ingrese su nombre de usuario: ");
		String nombreUsuario = entrada.next();
		Usuario usuario = Usuario.getUsuarioConNombreUsuario(nombreUsuario);
		//organizar tambien lo del null
		Mesa mesa = usuario.getMesa();
		if(mesa != null) {
			Mesa.liberarMesa(mesa.getCodigoM());
		}
		System.out.println("Adiós");
		Main.usuario = null;
		
		
	}

	@Override
	public String toString() {
		return "Cerrar Sesión";
	}

}
