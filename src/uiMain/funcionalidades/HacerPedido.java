package uiMain.funcionalidades;

import uiMain.*; 
import java.util.*;

import BaseDatos.Datos;
import gestorAplicacion.logic.*;
import gestorAplicacion.users.Usuario;

public class HacerPedido extends OpcionDeMenu {
	
	public HacerPedido(String pos) {
		super(pos);
	}
	
	public void ejecutar() {                                         //Hacer un pedido/ crea un objeto tipo pedido y se agrega en la lista de pedidos de usuario,lo mismo con factura, con el for se crean n objetos de tipo detallePedido que se almacenan en la lista del objeto pedido anteriormente creado.
		
		Scanner entrada = new Scanner(System.in);
		System.out.print("Ingrese su nombre de usuario: ");
		String nombreUsuario = entrada.next();
		if(Usuario.getUsuarioConNombreUsuario(nombreUsuario).getMesa() != null) {
			System.out.print("Ingrese la fecha actual:");
			String fecha = entrada.next();
			Pedido pedido = new Pedido(Usuario.getUsuarioConNombreUsuario(nombreUsuario));
			Factura factura = new Factura(Usuario.getUsuarioConNombreUsuario(nombreUsuario),pedido,fecha);
			Usuario.getUsuarioConNombreUsuario(nombreUsuario).setPedidosU(pedido);
			Datos.pedidos.put(nombreUsuario,pedido);
			Usuario.getUsuarioConNombreUsuario(nombreUsuario).setFacturasU(factura);
			Datos.facturas.put(nombreUsuario,factura);
			factura.setPedido(pedido);
			pedido.setFactura(factura);
			System.out.print("Ingrese la cantidad de platos que desee pedir:");
			int ciclo = entrada.nextInt();
			for (int i = 1; i <= ciclo; i++) {
				System.out.print("Ingrese el código del plato que desea ordenar: ");
				int codigo = entrada.nextInt();
				System.out.print("Ingrese la cantidad de unidades de este plato que desea ordenar: ");
				String cantidad = entrada.next();
				pedido.setPedidosP(DetallePedido.crearDetallePedido(codigo,cantidad));
			}
		}
		else {
			System.out.println("Debes ocupar una mesa para realizar un pedido.");
		}
	}
	
	public String toString() {
		return "Hacer un pedido";
	}
}
