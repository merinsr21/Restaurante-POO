package uiMain;

import uiMain.funcionalidades.*;



import java.util.*;

import modelo.BaseDatos.Datos;
import modelo.gestorAplicacion.users.Usuario;

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
					System.out.println("\n");
				}else {
					Main.menuInvitado.lanzarMenu();
					System.out.println("\n");
				}
			
			}
			catch(IndexOutOfBoundsException e){            //Si ocurre una excepcion al ejecutar el programa, lo terminara.
				
				Datos.guardarDatos();     //Al terminar el programa ejecutara el guardado
				
				System.out.println("Adiós");
				System.exit(0);
			}
		}
	}
	
	public static void iniciarConfiguracion() {   // para Cargar las opciones del programa primero
		
		//Operaciones de los usuarios
		OpcionDeMenu.funcionalidades.put("1", new VerMesasDisponibles("1"));
		OpcionDeMenu.funcionalidades.put("2", new OcuparMesa("2"));
		OpcionDeMenu.funcionalidades.put("3", new VerMenu("3"));
		OpcionDeMenu.funcionalidades.put("4", new HacerPedido("4"));
		OpcionDeMenu.funcionalidades.put("5", new Calificar("5"));
		OpcionDeMenu.funcionalidades.put("6", new VerFactura("6"));

			
		//Operaciones administrativas
		OpcionDeMenu.funcionalidades.put("7", new NuevoAdmin("7"));
		OpcionDeMenu.funcionalidades.put("8", new AgregarComida("8"));
		OpcionDeMenu.funcionalidades.put("9", new BorrarComida("9"));
		OpcionDeMenu.funcionalidades.put("10", new AñadirOpcion("10"));
		OpcionDeMenu.funcionalidades.put("11", new EliminarOpcion("11"));
		OpcionDeMenu.funcionalidades.put("12", new CerrarSesion("12"));
		OpcionDeMenu.funcionalidades.put("13", new VerFuncionalidades("13"));
		OpcionDeMenu.funcionalidades.put("14", new NuevoChef("14"));
		OpcionDeMenu.funcionalidades.put("15", new EditarUsuario("15"));
		OpcionDeMenu.funcionalidades.put("16", new EliminarUsuario("16"));
		OpcionDeMenu.funcionalidades.put("17", new OrdenarMenu("17"));
		OpcionDeMenu.funcionalidades.put("18", new CalcularCalorias("18"));
		OpcionDeMenu.funcionalidades.put("19", new VerCalificacion("19"));
		OpcionDeMenu.funcionalidades.put("20", new VerComentarios("20"));


		
		
		//Cargar los datos
		Datos datos = new Datos();
		datos.cargarDatos();
		
		//Operaciones del usuario por defecto
		@SuppressWarnings("serial")                                                      //creación de objetos dentro de otro objeto, para que no salga una advertencia
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
