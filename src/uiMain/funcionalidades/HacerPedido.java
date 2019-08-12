package uiMain.funcionalidades;

import uiMain.*; 
import java.util.*;

import BaseDatos.Datos;
import gestorAplicacion.logic.*;
import gestorAplicacion.users.*;;

public class HacerPedido extends OpcionDeMenu {
	
	// Solo se puede realizar un pedido por dia      // un usuario no puede tener varios pedidos con la misma fecha.
	public HacerPedido(String pos) {
		super(pos);
	}
	
	public void ejecutar() {     //Hacer un pedido/ crea un objeto tipo pedido y se agrega en la lista de pedidos de usuario,lo mismo con factura, con el for se crean n objetos de tipo detallePedido que se almacenan en la lista del objeto pedido anteriormente creado.
		
		Scanner entrada = new Scanner(System.in);
		
		//Meter todo esto en un metodo
		if(Main.usuario.getMesa() != null) {
			System.out.print("Ingrese la fecha actual(día/mes/año): ");
			String fecha = entrada.next();
			//String code = Pedido.generarCodigoPedido();         no son necesarios porque al crear el pedido el codigo ya se genera
			//String codef = Factura.generarCodigoFactura();
			
			//pero como arreglar esto con lo del codigo?
			Pedido pedido = new Pedido(codigoPedido,null,Main.usuario);
			Factura factura = new Factura(codigoFactura,fecha,null);
			
			
			pedido.setFactura(factura);
			factura.setPedidoFactura(pedido);
			
			Main.usuario.setPedidosUsuario(pedido);
			
			Datos.pedidos.put(codigoPedido,pedido);
			Datos.facturas.put(codigoFactura,factura);
			
			
			System.out.print("Ingrese la cantidad de platos que desee pedir: ");
			int ciclo = entrada.nextInt();
			for (int i = 1; i <= ciclo; i++) {
				System.out.print("Ingrese el código del plato que desea ordenar: ");
				String codigo = entrada.next();
				System.out.print("Ingrese la cantidad de unidades de este plato que desea ordenar: ");
				String cantidad = entrada.next();
			//organizar esto del codigo del detalle, debería ser con esto: codigo+"-"+generarCodigoDetalle() ¿no? pero ese metdo es privado, asi que no
				pedido.setDetallesPedido(DetallePedido.crearDetallePedido(codigoDetalle,codigo,cantidad,pedido));			
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
