package uiMain.funcionalidades;

import uiMain.*;
import java.util.*;
import gestorAplicacion.*;
import modelo.gestorAplicacion.logic.DetallePedido;
import modelo.gestorAplicacion.logic.Pedido;
import modelo.gestorAplicacion.users.Usuario;

public class VerFactura extends OpcionDeMenu {
	
	public VerFactura (String pos) {
		super(pos);
	}
	
	public void ejecutar() {                             //el usuario solo puede hacer un pedido por dia.
		Scanner entrada = new Scanner(System.in);
		System.out.print("Ingrese la fecha de su factura(día/mes/año): ");
		String fecha = entrada.next();
		
		//esa variable no se está usando ¿es necesaria?
		Pedido pedido1 = null;
		
		
		//cambiar solo lo del null
		for(Pedido pedido: Main.usuario.getPedidosUsuario()) {
			if(pedido.getFactura().getFecha().equals(fecha)) {
				System.out.println("Factura:");
				for(DetallePedido detalle : pedido.getDetallesPedido()) {
					if(detalle !=null) {
						System.out.println(detalle);
					}
					
				}
				System.out.println("Precio total: " + Pedido.calcularPrecioTotal(pedido));
				break;
			}
		}
	}
	
	public String toString() {
		return "Ver factura de acuerdo a la fecha";
	}

}
