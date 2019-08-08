package uiMain.funcionalidades;

import uiMain.*; 
import java.util.*;

import BaseDatos.Datos;
import gestorAplicacion.logic.*;
import gestorAplicacion.users.*;;

public class HacerPedido extends OpcionDeMenu {
	
	public HacerPedido(String pos) {
		super(pos);
	}
	
	public void ejecutar() {              //Hacer un pedido/ crea un objeto tipo pedido y se agrega en la lista de pedidos de usuario,lo mismo con factura, con el for se crean n objetos de tipo detallePedido que se almacenan en la lista del objeto pedido anteriormente creado.
		
		Scanner entrada = new Scanner(System.in);
		System.out.print("Ingrese su nombre de usuario: ");
		String nombreUsuario = entrada.next();
		
		//Meter todo esto en un metodo
		if(Usuario.getUsuarioConNombreUsuario(nombreUsuario).getMesa() != null) {
			System.out.print("Ingrese la fecha actual(día/mes/año): ");
			String fecha = entrada.next();
			String code = Pedido.generarCodigoP();
			String codef = Factura.generarCodigoF();
			
			Pedido pedido = new Pedido(code,null,Usuario.getUsuarioConNombreUsuario(nombreUsuario));
			Factura factura = new Factura(codef,fecha,null);
			
			
			pedido.setFactura(factura);
			factura.setPedidoF(pedido);
			
			Usuario.getUsuarioConNombreUsuario(nombreUsuario).setPedidosU(pedido);
			
			Datos.pedidos.put(code,pedido);
			Datos.facturas.put(codef,factura);
			
			
			System.out.print("Ingrese la cantidad de platos que desee pedir: ");
			int ciclo = entrada.nextInt();
			for (int i = 1; i <= ciclo; i++) {
				System.out.print("Ingrese el código del plato que desea ordenar: ");
				String codigo = entrada.next();
				System.out.print("Ingrese la cantidad de unidades de este plato que desea ordenar: ");
				String cantidad = entrada.next();
				pedido.setDetallesP(DetallePedido.crearDetallePedido(coded, cantidad,codigo,pedido));			
			}
			System.out.println("Su pedido ha sido creado.");
		}
		else {
			System.out.println("Debes ocupar una mesa para realizar un pedido.");
		}
	}
	
	public String toString() {
		return "Hacer un pedido";
	}
}
