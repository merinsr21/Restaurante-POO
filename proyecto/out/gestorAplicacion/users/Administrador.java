package gestorAplicacion.users;

import BaseDatos.Datos;
import uiMain.MenuDeConsola;


public class Administrador extends Usuario{
	
	Administrador(){
		super();
	}
	
	public Administrador(String nombre, String nombreUsuario, String correo, String contrase�a) {
		super(nombre, nombreUsuario, correo, contrase�a);
		Datos.usuarios.put(nombreUsuario, this);
	}
	
	public static String nuevoAdministrador(String nombre, String nombreUsuario, String correo, String contrase�a){
		Administrador usuario = new Administrador();
		//Validaciones de cada parametro
		usuario.setNombre(nombre);
		usuario.setNombreUsuario(nombreUsuario);
		usuario.setCorreo(correo);
		usuario.setContrase�a(contrase�a);
		
		//Menu por defecto al crear un nuevo usuario administrador
		String [] funcionalidades = {"1","2","3","4","5","6","7"};
		MenuDeConsola.nuevoMenu(usuario, funcionalidades);
		if(true){
			Datos.usuarios.put(nombreUsuario, usuario);
			return "Ha sido creado";
		}else{
			return "No ha sido creado.";
		}
	}
}