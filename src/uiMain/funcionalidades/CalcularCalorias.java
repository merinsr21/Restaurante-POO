package uiMain.funcionalidades;

import java.util.Scanner;
import gestorAplicacion.logic.*;
import gestorAplicacion.users.*;
import uiMain.*;

public class CalcularCalorias extends OpcionDeMenu {

	public CalcularCalorias(String pos) {
		super(pos);
	}
	
	public void ejecutar() {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Ingrese el nombre del usuario al cual le desea revisar su pedido: ");
		String nombreUsuario = entrada.next();
		System.out.println("Ingrese la fecha del pedido(día/mes/año): ");
		String fecha = entrada.next();
		Usuario usuario = Usuario.getUsuarioConNombreUsuario(nombreUsuario);
		Pedido pedido = null;
		for(Pedido buscadorPedido: usuario.getPedidosUsuario()) {
			if(buscadorPedido.getFactura().getFecha().equals(fecha)) {
				pedido = buscadorPedido;
			}
		}
		Chef.calcularCalorias(pedido);
	}
	
	public String toString() {
		return "Calcular la cantidad de calorías en un determinado pedido";
	}
}
