package uiMain;

import gestorAplicacion.users.Usuario;
import uiMain.funcionalidades.*;


import java.util.*;

import BaseDatos.Datos;

public class Main {

	public static Usuario usuario;
	
	public static MenuDeConsola menuInvitado;
	
	public static void main(String[] args) {
		Main.iniciarConfiguracion();    //Cargar las opciones del programa primero
		while(true) {
			
			try {
				if(Main.usuario != null){
					System.out.println("\n");
					Main.usuario.getMenu().lanzarMenu();
				}else {
					System.out.println("\n");
					Main.menuInvitado.lanzarMenu();
				}
			
			}
			catch(Exception e){            //Si ocurre una excepcion al ejecutar el programa, lo terminara.
				
				Datos.guardarDatos();     //Al terminar el programa ejecutara el guardad
				
				System.out.println("Adiós");
				System.exit(0);
			}
		}
	}
	
	public static void iniciarConfiguracion() {   // para Cargar las opciones del programa primero
		
		//Operaciones de los usuarios
		Datos.funcionalidades.put("1", new VerMesasDisponibles("1"));
		Datos.funcionalidades.put("2", new OcuparMesa("2"));
		Datos.funcionalidades.put("3", new VerMenu("3"));
		Datos.funcionalidades.put("4", new HacerPedido("4"));
		Datos.funcionalidades.put("5", new Calificar("5"));
		Datos.funcionalidades.put("6", new VerFactura("6"));

			
		//Operaciones administrativas
		Datos.funcionalidades.put("7", new NuevoAdmin("7"));
		Datos.funcionalidades.put("8", new AgregarComida("8"));
		Datos.funcionalidades.put("9", new BorrarComida("9"));
		Datos.funcionalidades.put("10", new AñadirOpcion("10"));
		Datos.funcionalidades.put("11", new EliminarOpcion("11"));
		Datos.funcionalidades.put("12", new CerrarSesion("12"));
		Datos.funcionalidades.put("13", new VerFuncionalidades("13"));
		Datos.funcionalidades.put("14", new NuevoChef("14"));
		
		//Cargar los datos
		Datos.cargarDatos();
		
		//Operaciones del usuario por defecto
		@SuppressWarnings("serial")                                                      //creación de objetos dentro de otro objeto, para que nosalga una advertencia
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
