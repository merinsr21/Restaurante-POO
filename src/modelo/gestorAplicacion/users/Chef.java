package modelo.gestorAplicacion.users;
import modelo.gestorAplicacion.logic.*;
import uiMain.MenuDeConsola;

public class Chef extends Usuario{
	
	public Chef() {
		
	}
	
	protected Chef(String nombreUsuario, MenuDeConsola menu) {
		super(nombreUsuario,menu);
		Usuario.usuarios.put(nombreUsuario, this);
	}

	public Chef(String nombre, String nombreUsuario, String correo, String contraseña) {
		//organizar lo del carrito
		super(nombre, nombreUsuario, correo, contraseña);
		Usuario.usuarios.put(nombreUsuario, this);
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
		Usuario.usuarios.put(nombreUsuario,chef);
		return "Ha sido creado";
	}
	
	public static void calcularCalorias(Pedido pedido) {
		int sumaCalorias = 0;
		for(DetallePedido buscador: pedido.getDetallesPedidoDeCadaPedido()) {
			int calorias = buscador.getComida().getCalorias();
			sumaCalorias += calorias;
			System.out.println("La cantidad de calorias en "+buscador.getComida().getNombreComida()+" es: "+buscador.getComida().getCalorias());
		}
		System.out.println("La cantidad total de calorias en el pedido es :"+sumaCalorias);
	}
}
