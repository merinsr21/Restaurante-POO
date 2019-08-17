package uiMain.funcionalidades;
import java.util.*;
import modelo.gestorAplicacion.logic.*;
import modelo.gestorAplicacion.users.Usuario;
import uiMain.*;

public class Calificar extends OpcionDeMenu {
	
	public Calificar(String pos) {
		super(pos);
	}
	
	public void ejecutar() {
		Scanner entrada = new Scanner (System.in);
		System.out.print("Ingrese la fecha de su factura(d�a/mes/a�o): ");
		String fecha = entrada.next();
		Usuario usuario = Main.usuario;
		Pedido pedido = null;
		for(Pedido pedidox: usuario.getPedidosUsuario()) {
			if(pedidox.getFactura().getFecha().equals(fecha)){
				pedido = pedidox;
			}
		}
		//no se si esto con tantos prints y cosas que pide al usuario deber�a ir en un metodo de una clase
		System.out.print("Ingrese el c�digo de la comida que desea calificar: ");
		String codigoComida  = entrada.next();
		String print = "La comida que desea calificar debe estar en su pedido.";
		for(DetallePedido detalle: pedido.getDetallesPedido()) {
			if(detalle.getComida().getCodigoComida().equals(codigoComida)) {
				System.out.print("Ingrese la calificaci�n de la comida: ");
				String puntaje = entrada.next();
				Calificacion calificacion = Calificacion.crearCalificacion(//////, puntaje);
				print = "Gracias por calificar, vuelva pronto.";
				if(!print.equals("La comida que desea calificar debe estar en su pedido.")){
					System.out.print("�Desea a�adir un comentario a su calificaci�n? Ingrese 1 = Si , 2 = No  : ");
					int opcion  = entrada.nextInt();
					if(opcion == 1) {
						System.out.print("Ingrese un breve comentario sobre la comida: ");
						String comentario = entrada.next();
						calificacion.setComentario(comentario);
						System.out.print("Su cometario ha sido a�adido.");
					}
					else {
						break;
					}
				}
			}
		}
		System.out.println(print);
		
		
		//�SI DEBERIAMOS PONER QUE CUANDO CALIFIQUE SE CIERRE SU SESION O EL PROGRAMA MISMO?
		
		
	}
	
	//SE PUEDE CALIFICAR MAS DE UNA VEZ LA MISMA COMIDA  //REVISAR
	
	public String toString(){
		return "Calificar una comida";
	}
}
