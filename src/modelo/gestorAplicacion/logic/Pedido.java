package modelo.gestorAplicacion.logic;
import java.util.*;
import uiMain.*;

import modelo.BaseDatos.Datos;
import modelo.gestorAplicacion.users.*;
import uiMain.OpcionDeMenu;

public class Pedido {
	
	private static int consecutivoPedido = 0;
	private int consecutivoDetalle = 0;
	private String codigoPedido;
	private Factura factura;
	private Usuario usuario;
	public static HashMap<String, Pedido> pedidos = new HashMap<String, Pedido>();//String= Código del pedido	
	private ArrayList<DetallePedido> detallesPedidoDeCadaPedido = new ArrayList<DetallePedido>();

	
	public Pedido(String codigoPedido, Factura factura, Usuario usuario) {
		this.codigoPedido = codigoPedido;
		this.factura = factura;
		this.usuario = usuario;
	}

	public static void crearPedido(Usuario usuario) {
		Pedido pedido = new Pedido(generarCodigoPedido(),Factura. crearFactura(),Main.usuario); //creo el pedido. //crear metodo en Factura para crear Factura
		for(Map.Entry<Comida, Integer> comida : Main.usuario.getMiCarrito().verCarrito().entrySet()) {
			int cantidad = comida.getValue();
			DetallePedido.crearDetallePedido(pedido.generarCodigoDetalle(), comida.getKey(), cantidad, pedido);  //creo detalles y asociarlos al pedido.  
		}
	}
	
	private static String generarCodigoPedido() {
		String  codigoPedido = Integer.toString(consecutivoPedido);
		consecutivoPedido++;
		return codigoPedido;		
	}
	
	private String generarCodigoDetalle() {
		String  codigo = Integer.toString(consecutivoDetalle);
		consecutivoDetalle++;
		return this.codigoPedido+"-"+codigo ;	
	}
	
	public String getCodigoPedido() {
		return codigoPedido;
	}
	public void setCodigoPedido(String codigoPedido) {
		this.codigoPedido = codigoPedido;
	}
	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public ArrayList<DetallePedido> getDetallesPedidoDeCadaPedido() {
		return detallesPedidoDeCadaPedido;
	}
	public void setDetallesPedidoDeCadaPedido(DetallePedido detalle) {
		detallesPedidoDeCadaPedido.add(detalle);
	}
	 
	// Calcula el precio total del pedido
	public int calcularPrecioTotalPedido() {
		int sumatoria = 0;
		for(DetallePedido detalle: detallesPedidoDeCadaPedido) {
			sumatoria += detalle.precioTotalComida();    // crear este metodo en DetallePedido(PrecioUnitario*cantidad)
		}
		return sumatoria;
	}
	
}
