package modelo.gestorAplicacion.logic;
import java.util.*;

import modelo.BaseDatos.Datos;
import modelo.gestorAplicacion.users.*;
import uiMain.OpcionDeMenu;

public class Pedido {
	
	private static int consecutivoPedido = 0;
	private int consecutivoDetalle = 0;
	private String codigoPedido;
	private Factura factura;
	private Usuario usuario;
	public static HashMap<String, Pedido> pedidos = new HashMap<String, Pedido>();//String= Códigodel pedido	
	private ArrayList<DetallePedido> detallesPedido1 = new ArrayList<DetallePedido>();
	private static ArrayList<Pedido> pedidosPedido = new ArrayList<Pedido>();

	
	public Pedido() {
		this.codigoPedido = generarCodigoPedido();
	}

	public static void crearPedido(Usuario usuario) {
		Pedido pedido = new Pedido();
		pedido.setUsuario(Usuario.usuario);
		//Se debe crear el pedido primero y luego crear cada uno de los detalles y setterarselos a los detalles
		for (int i = 0; i < detalles.length; i +=2) {                                                         //codigoComida  /cantidadDeEsaComida
			DetallePedido detalleDelPedido = DetallePedido.crearDetallePedido(pedido.generarCodigoDetalle(), detalles[i], detalles[i+1], pedido);
		}	
		
		Pedido.pedidos.put(codigoPedido, pedido);
		pedidosPedido.add(pedido);
		Pedido.calcularPrecioTotal(pedido);		
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
	public ArrayList<DetallePedido> getDetallesPedido() {
		return detallesPedido1;
	}
	public void setDetallesPedido(DetallePedido detalle) {
		detallesPedido1.add(detalle);
	}
	public static String getNombreArreglo(String noSeUsa) {
		return "pedidosP";
	}
	public static String getNombreArreglo() {
		return "pedidosP";
	}
	public static ArrayList<Pedido> getPedidosPedido(String nombre){
		return pedidosPedido;
	}
	public static void setPedidosPedido(Pedido pedido){
		pedidosPedido.add(pedido);
	}
	public int calcularPrecioTotal(Pedido pedido) {
		int sumatoria = 0;
		String sumaAString = null;
		for(DetallePedido buscador: pedido.getDetallesPedido()) {
			if(buscador != null) {
				int precioTotal = Integer.parseInt(buscador.getPrecioTotal());
				sumatoria += precioTotal;
				sumaAString = Integer.toString(sumatoria);
			}
        }
		pedido.setPrecioTotal(sumaAString);
		return sumatoria;
	}
	
	public static void Pedidopedido(Pedido pedido1, String [] detalles) {
		for (String detalle : detalles) {
			
			//no sé por que pasa esto
			detallesPedido1.add(DetallePedido.getDetalleConCodigo(detalle));
			DetallePedido.getDetalleConCodigo(detalle).setPedidoDetalle(pedido1);
			DetallePedido pointer = DetallePedido.getDetalleConCodigo(detalle);
			DetallePedido detdet = new DetallePedido(pointer.getCodigoDetalle(), pointer.getComida(), pointer.getCantidad(), pointer.getPrecioTotal(), pointer.getPedidoDetalle());
		}
	}
}
