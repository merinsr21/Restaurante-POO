package gestorAplicacion.logic;
import java.util.*;
import gestorAplicacion.users.*;

public class Pedido {
	
	int codigo;
	Factura factura;
	Usuario usuario;
	Mesa mesa;
	Boolean preparado;   //inicializa en false
	ArrayList<DetallePedido> detalles = new ArrayList<DetallePedido>();
	Chef chef;
	
	
}
