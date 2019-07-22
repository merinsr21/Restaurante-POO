package uiMain;

import java.util.ArrayList;
import java.util.Scanner;

import BaseDatos.Datos;
import gestorAplicacion.users.Usuario;

public class MenuDeConsola {
	
	private Usuario usuario;
	private ArrayList<OpcionDeMenu> opciones = new ArrayList<OpcionDeMenu> ();
	
	public MenuDeConsola(ArrayList<OpcionDeMenu> opciones){
		this.opciones = opciones;
	}
	
	public MenuDeConsola(Usuario usuario, ArrayList<OpcionDeMenu> opciones){
		this.usuario = usuario;
		this.opciones = opciones;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUser(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public ArrayList<OpcionDeMenu> getOptions() {
		return opciones;
	}

	public void setOptions(ArrayList<OpcionDeMenu> opciones) {
		this.opciones = opciones;
	}
	
	public String[] getFuncionalidades() {
		String [] options = new String[opciones.size()];
		int i = 0;
		for (OpcionDeMenu opcionDeMenu : opciones) {
			options[i] = opcionDeMenu.getPos();
			i++;
		}
		return options;
	}

	public void lanzarMenu(){
		Scanner entrada = new Scanner(System.in);
		
		System.out.println();
		int i = 1;
		for (OpcionDeMenu option : opciones) {
			
			System.out.println(i+" "+option);
			i++;
		}
		//Opcion para terminar el programa, hecho con un try catch.
		System.out.println(i+" Terminar programa");
		
		System.out.print("Ingrese una opción: ");
		int opt = entrada.nextInt();
		opciones.get((opt-1)).ejecutar();
		
	}
	
	public static void nuevoMenu(Usuario usuario, String [] funcionalidades) {
		ArrayList<OpcionDeMenu> funcionalidadesMenu = new ArrayList<OpcionDeMenu>();
		for (String op : funcionalidades) {
			funcionalidadesMenu.add(Datos.funcionalidades.get(op));
		}
		MenuDeConsola menu = new MenuDeConsola(usuario, funcionalidadesMenu);
		usuario.setMenu(menu);
		Datos.menus.put(usuario.getNombreUsuario(), menu);
	}
	
	public void verOpcion() {
		int i = 1;
		for (OpcionDeMenu opcionDeMenu : opciones) {
			System.out.println(i + " "+opcionDeMenu);
			i++;
		}
	}
	
	public void eliminarOpcion(int i) {
		opciones.remove(i-1);
	}
	
	public void añadirOpcion(String optn) {
		opciones.add(Datos.funcionalidades.get(optn));
	}
}
