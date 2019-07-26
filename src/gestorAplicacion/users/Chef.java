package gestorAplicacion.users;
import java.util.ArrayList;

import BaseDatos.Datos;
import gestorAplicacion.logic.*;
import uiMain.MenuDeConsola;

public class Chef extends Usuario{
	
	public Chef() {
		
	}
	
	protected Chef(String nombreUsuario, MenuDeConsola menu) {
		super(nombreUsuario,menu);
		Datos.usuarios.put(nombreUsuario, this);
	}

	public Chef(String nombre, String nombreUsuario, String correo, String contraseña) {
		super(nombre, nombreUsuario, correo, contraseña);
		Datos.usuarios.put(nombreUsuario, this);
	}
	
	public static String nuevoChef(String nombre, String nombreUsuario, String correo, String contraseña){
		Chef chef = new Chef();
		//Validaciones de cada parámetro porque son private en la clase
		chef.setNombre(nombre);
		chef.setNombreUsuario(nombreUsuario);
		chef.setCorreo(correo);
		chef.setContraseña(contraseña);
		
		//Menu por defecto al crear un nuevo chef
		String [] funcionalidades = {"18","8","12"};
		MenuDeConsola.nuevoMenu(chef, funcionalidades);
		Datos.usuarios.put(nombreUsuario,chef);
		return "Ha sido creado";
	}
	
	public static void calcularCalorias(Pedido pedido) {
		int sum = 0;
		for(DetallePedido r: pedido.getDetallesP()) {
			String z1 = r.getComida().getCalorias();
			int z = Integer.parseInt(z1);
			sum += z;
			System.out.println("La cantidad de calorias en "+r.getComida().getNombre()+" es: "+r.getComida().getCalorias());
		}
		System.out.println("La cantidad total de calorias en el pedido es :"+sum);
	}
}
