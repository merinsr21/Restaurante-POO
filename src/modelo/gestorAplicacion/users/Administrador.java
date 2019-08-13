package modelo.gestorAplicacion.users;

import modelo.BaseDatos.Datos;
import uiMain.MenuDeConsola;


public class Administrador extends Usuario{
	
	Administrador(){
		super();
	}
	
	public Administrador(String nombre, String nombreUsuario, String correo, String contrase�a) {
		//pober lo del carrito
		super(nombre, nombreUsuario, correo, contrase�a);
		Usuario.usuarios.put(nombreUsuario, this);
	}
	
	public static String nuevoAdministrador(String nombre, String nombreUsuario, String correo, String contrase�a){
		Administrador usuario = new Administrador();
		//Validaciones de cada par�metro al ser private
		usuario.setNombre(nombre);
		usuario.setNombreUsuario(nombreUsuario);
		usuario.setCorreo(correo);
		usuario.setContrase�a(contrase�a);
		
		//Men� por defecto al crear un nuevo usuario administrador
		String [] funcionalidades = {"1","3","7","14","9","10","11","13","15","16","17","19","20","12"};   //admin;1;3;7;14;8;9;10;11;13;15;16;17;12
		MenuDeConsola.nuevoMenu(usuario, funcionalidades);
		
		
			Usuario.usuarios.put(nombreUsuario, usuario);
			return "Ha sido creado";
		
	}
}