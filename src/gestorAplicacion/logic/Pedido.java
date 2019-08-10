package gestorAplicacion.logic;
import java.util.*;

import BaseDatos.Datos;
import gestorAplicacion.users.*;
import uiMain.OpcionDeMenu;

public class Pedido {
	
	private static int consecutivo = 0;
	private static int consecutivoDetalle = 0;
	private String codigoPedido;
	private Factura factura;
	private Usuario usuario;
	private String precioTotal; //es necesario para mostrar la factura, pero debe ir en Pedido
	private ArrayList<DetallePedido> detallesPedido1 = new ArrayList<DetallePedido>();
	private static ArrayList<Pedido> pedidosPedido = new ArrayList<Pedido>();

	
	public Pedido() {
		
	}

	public Pedido(String codigoPedido, Factura factura, Usuario usuario ) {
		this.codigoPedido = codigoPedido;
		this.factura = factura;
		this.usuario = usuario;
	}
	public Pedido(String codigoPedido, Usuario usuario ) {
		this.codigoPedido = codigoPedido;
		this.usuario = usuario;	
	}
	public static void crearPedido(Usuario usuario, String detalles []) {
		String codigo = generarCodigoPedido();
		Pedido pedido = new Pedido(codigo, usuario);
		//Se debe crear el pedido primero y luego crear cada uno de los detalles y setterarselos a los detalles
		for (int i = 0; i < detalles.length; i +=2) {                                                         //codigoComida  /cantidadDeEsaComida
			DetallePedido detalleDelPedido = DetallePedido.crearDetallePedido(codigo+"-"+generarCodigoDetalle(), detalles[i], detalles[i+1], pedido);
		
		}	
		
		Datos.pedidos.put(codigo,pedido);
		pedidosPedido.add(pedido);
		Pedido.calcularPrecioTotal(pedido);		
	}
	
	private static String generarCodigoPedido() {
		String  codigo = Integer.toString(consecutivo);
		consecutivo++;
		return codigo;		
	}
	
	private static String generarCodigoDetalle() {
		String  codigo = Integer.toString(consecutivoDetalle);
		consecutivoDetalle++;
		return codigo;	
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
	public String getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(String precioTotal) {
		this.precioTotal = precioTotal;
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
	public static int calcularPrecioTotal(Pedido pedido) {
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
