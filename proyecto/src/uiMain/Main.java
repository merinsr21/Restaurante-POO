package uiMain;

import gestorAplicacion.users.Usuario;
import uiMain.funcionalidades.*;


import java.util.*;

import BaseDatos.Datos;

public class Main {

	public static Usuario usuario;
	
	public static MenuDeConsola menuInvitado;
	
	public static void main(String[] args) {
		Main.iniciarConfiguracion();
		while(true) {
			
			try {
				if(Main.usuario != null){
					Main.usuario.getMenu().lanzarMenu();
				}else {
					Main.menuInvitado.lanzarMenu();
				}
			
			}
			catch(Exception e){
				//Si ocurre una excepcion al ejecutar el programa, lo terminara.
				
				//Al terminar el programa ejecutara el guardado
				Datos.guardarDatos();
				
				System.out.println("Adiós");
				System.exit(0);
			}
		}
	}
	
	public static void iniciarConfiguracion() {
		//Cargar las opciones del programa primero
		
		//Operaciones administrativas
		Datos.funcionalidades.put("1", new VerOpcion("1"));
		Datos.funcionalidades.put("2", new AñadirOpcion("2"));
		Datos.funcionalidades.put("3", new EliminarOpcion("3"));
		Datos.funcionalidades.put("4", new NuevoAdmin("4"));
		Datos.funcionalidades.put("5", new AgregarComida("5"));
		Datos.funcionalidades.put("6", new BorrarComida("6"));
		Datos.funcionalidades.put("7", new OrdenarMenu("7"));
		
		//Operaciones de mis usuarios
		Datos.funcionalidades.put("8", new VerMesasDisponibles("8"));
		Datos.funcionalidades.put("9", new VerMenu("9"));
		Datos.funcionalidades.put("10", new Calificar("10"));
		Datos.funcionalidades.put("11", new CerrarSesion("11"));
		
		//Cargar los datos
		Datos.cargarDatos();
		
		
		//Usuario invitado o menu invitado(por defecto)
		
		//Operaciones de mi usuario por defecto
		@SuppressWarnings("serial")
		ArrayList<OpcionDeMenu> opcionesInvitado = new ArrayList<OpcionDeMenu>(){
			{
				add(new IniciarSesion());
				add(new Registrarse());
				add(new VerMenu());
			}
		};
		
		Main.menuInvitado = new MenuDeConsola(opcionesInvitado);
		
	}

}
