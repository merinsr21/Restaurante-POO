package gestorAplicacion.logic;
import java.util.*;

import BaseDatos.Datos;
import gestorAplicacion.users.*;
import uiMain.OpcionDeMenu;

public class Pedido {
	
	private static int consecutivo = 0;
	private int consecutivoDetalle = 0;
	private String codigoP;
	private Factura factura;
	private Usuario usuario;
	private ArrayList<DetallePedido> detallesP = new ArrayList<DetallePedido>();
	private static ArrayList<Pedido> pedidosP = new ArrayList<Pedido>();

	
	public Pedido() {
		
	}

	public Pedido(String codigo, Factura factura, Usuario usuario ) {
		this.codigoP = codigo;
		this.factura = factura;
		this.usuario = usuario;
	}
	public Pedido(String codigo, Usuario usuario ) {
		this.codigoP = codigo;
		this.usuario = usuario;
		
	}
	public static void crearPedido(Usuario usuario, String detalles []) {
		String codigo = generarCodigoPedido();
		Pedido pedido = new Pedido(codigo, usuario);
		//Se debe crear el pedido primero y luego crear cada uno de los detalles y setterarselos a los detalles
		for (int i = 0; i < detalles.length; i +=2) {
			DetallePedido detalleDelPedido = DetallePedido.crearDetallePedido(generarCodigoPedido(), detalles[i+1], detalles[i], pedido);
		
		}
		
		
		Datos.pedidos.put(codigo,pedido);
		pedidosP.add(pedido);
		Pedido.calcularPrecioTotal(pedido);
		
	}
	private static String generarCodigoPedido() {
		String  codigo = Integer.toString(consecutivo);
		consecutivo++;
		return codigo;
		
	}
	
	private String generarCodigoDetalle() {
		String  codigo = Integer.toString(consecutivoDetalle);
		consecutivoDetalle++;
		return codigo;
		
	}
	
	public String getCodigoP() {
		return codigoP;
	}
	public void setCodigoP(String codigo) {
		this.codigoP = codigo;
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
	public ArrayList<DetallePedido> getDetallesP() {
		return detallesP;
	}
	public void setDetallesP(DetallePedido detalle) {
		detallesP.add(detalle);
	}
	public static String getNombreArreglo(String noSeUsa) {
		return "pedidosP";
	}
	public static String getNombreArreglo() {
		return "pedidosP";
	}
	public static ArrayList<Pedido> getPedidosP(String nombre){
		return pedidosP;
	}
	public static void setPedidosP(Pedido p){
		pedidosP.add(p);
	}
	public static int calcularPrecioTotal(Pedido pedido) {
		int sumatoria = 0;
		String s = null;
		for(DetallePedido r: pedido.getDetallesP()) {
			if(r != null) {
				int pt = Integer.parseInt(r.getPrecioTotal());
				sumatoria += pt;
				s = Integer.toString(sumatoria);
			}
        }
		pedido.setPrecioTotal(s);
		return sumatoria;
	}
	
	public static void Pedidop(Pedido pedidop, String [] detalles) {
		for (String dp : detalles) {
			detallesP.add(DetallePedido.getDetalleConCodigo(dp));
			DetallePedido.getDetalleConCodigo(dp).setPedido(pedidop);
			DetallePedido pointer = DetallePedido.getDetalleConCodigo(dp);
			DetallePedido detdet = new DetallePedido(pointer.getCodigoD(),pointer.getCantidad(), pointer.getComida(), pointer.getPrecioTotal(), pointer.getPedidoD());
		}
	}
}
