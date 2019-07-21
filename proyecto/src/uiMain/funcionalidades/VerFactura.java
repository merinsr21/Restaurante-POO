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
		System.out.println("Ingrese la fecha :");
		Pedido p = null;
		String fecha = entrada.next();
		for(Pedido r: Usuario.getUsuarioConNombreUsuario(nombreUsuario).getPedidosU()) {
			if(r.getFactura().getFecha() == fecha) {
				p = r;
				break;
			}
		}
	
		System.out.println("Factura");
		for(DetallePedido t: p.getDetalles()) {
			System.out.println(t);
		}
		System.out.println("Precio total: ");
	}
	
	public String toString() {
		return "Muestra la factura";
	}

}
