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

	public Pedido() {
	}
	
	public Pedido(String codigoPedido, Usuario usuario) {
		this.codigoPedido = codigoPedido;
		this.usuario = usuario;
	}

	public static void crearPedido(Usuario usuario) {
		Pedido pedido = new Pedido(generarCodigoPedido(),Main.usuario);
		Factura factura = Factura.crearFactura(pedido);
		pedido.setFactura(factura);
		for(Map.Entry<Comida, Integer> comida : Main.usuario.getMiCarrito().verCarrito().entrySet()) {
			String cantidad = String.valueOf(comida.getValue());
			DetallePedido detalle = DetallePedido.crearDetallePedido(pedido.generarCodigoDetalle(), cantidad, comida.getKey(), pedido);
			pedido.setDetallesPedidoDeCadaPedido(detalle);
		}
		Pedido.pedidos.put(pedido.getCodigoPedido(), pedido);
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
	public static int getConsecutivoPedido() {
		return consecutivoPedido;
	}
	public static void setConsecutivoPedido(int consecutivoPedido) {
		Pedido.consecutivoPedido = consecutivoPedido;
	}
	 
	// Calcula el precio total del pedido
	public int calcularPrecioTotalPedido() {
		int sumatoria = 0;
		for(DetallePedido detalle: detallesPedidoDeCadaPedido) {
			sumatoria += detalle.precioTotalComida();   
		}
		return sumatoria;
	}
	
	public static int asignacionConsecutivoPedido() {
		int mayor = 0;
		for(Map.Entry<String, Pedido> p : Pedido.pedidos.entrySet()) {
			String c = p.getKey();
			int codigo =Integer.parseInt(c);
			if(codigo > mayor) {
				mayor = codigo;
			}
		}
		return mayor;
	}
	
	public static Pedido getPedidoConCodigo(String codigoPedido){
        return Pedido.pedidos.get(codigoPedido);
    }
	
}
