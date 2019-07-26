package uiMain.funcionalidades;
import java.util.*;
import gestorAplicacion.logic.Calificacion;
import gestorAplicacion.logic.Comida;
import gestorAplicacion.logic.DetallePedido;
import gestorAplicacion.logic.Pedido;
import gestorAplicacion.users.Usuario;
import uiMain.*;

public class Calificar extends OpcionDeMenu {
	
	public Calificar(String pos) {
		super(pos);
	}
	
	public void ejecutar() {
		Scanner entrada = new Scanner (System.in);
		System.out.println("Ingrese su nombre de usuario: ");
		String nombreUsuario = entrada.next();
		System.out.print("Ingrese la fecha de su factura(día/mes/año): ");
		String fecha = entrada.next();
		Usuario usuario = Usuario.getUsuarioConNombreUsuario(nombreUsuario);
		Pedido pedido = null;
		for(Pedido r: usuario.getPedidosU()) {
			if(r.getFactura().getFecha().equals(fecha)){
				pedido = r;
			}
		}
		System.out.print("Ingrese el código de la comida que desea calificar: ");
		String codigo = entrada.next();
		String print = "La comida que desea calificar debe estar en su pedido.";
		for(DetallePedido z: pedido.getDetallesP()) {
			if(z.getComida().getCodigo().equals(codigo)) {
				System.out.print("Ingrese la calificación de la comida: ");
				String puntaje = entrada.next();
				Calificacion ca = Calificacion.crearCalificacion(codigo, puntaje, usuario);
				print = "Gracias por calificar, vuelva pronto.";
				if(!print.equals("La comida que desea calificar debe estar en su pedido.")){
					System.out.print("¿Desea añadir un comentario a su calificación? Ingrese 1 = Si , 2 = No  : ");
					int n  = entrada.nextInt();
					if(n == 1) {
						System.out.println("Ingrese un breve comentario sobre la comida:");
						String comentario = entrada.next();
						ca.setComentario(comentario);
						System.out.println("Su cometario ha sido añadido.");
					}
					else {
						break;
					}
				}
			}
		}
		System.out.println(print);
		
	}
	
	//SE PUEDE CALIFICAR MAS DE UNA VEZ LA MISMA COMIDA  //REVISAR
	
	public String toString(){
		return "Calificar una comida";
	}
}
