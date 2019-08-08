package uiMain.funcionalidades;

import uiMain.*;
import java.util.*;
import gestorAplicacion.*;
import gestorAplicacion.logic.DetallePedido;
import gestorAplicacion.logic.Pedido;
import gestorAplicacion.users.Usuario;

public class VerFactura extends OpcionDeMenu {
	
	public VerFactura (String pos) {
		super(pos);
	}
	
	public void ejecutar() {                             //el usuario solo puede hacer un pedido por dia.
		Scanner entrada = new Scanner(System.in);
		System.out.print("Ingrese su nombre de usuario: ");
		String nombreUsuario = entrada.next();
		System.out.print("Ingrese la fecha de su factura(día/mes/año): ");
		Pedido p = null;
		String fecha = entrada.next();
		//cambiar solo algunas cosas, organizar lo del null
		for(Pedido r: Usuario.getUsuarioConNombreUsuario(nombreUsuario).getPedidosU()) {
			if(r.getFactura().getFecha().equals(fecha)) {
				System.out.println("Factura:");
				for(DetallePedido t : r.getDetallesP()) {
					if(t !=null) {
						System.out.println(t);
					}
					
				}
				System.out.println("Precio total: " + Pedido.calcularPrecioTotal(r));
				break;
			}
		}
	}
	
	public String toString() {
		return "Ver factura de acuerdo a la fecha";
	}

}
