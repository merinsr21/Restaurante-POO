package gestorAplicacion.logic;
import java.util.*;

import BaseDatos.Datos;
import gestorAplicacion.users.*;
import uiMain.OpcionDeMenu;

public class Pedido {
	
	private static int cont = 400;
	private String codigoP;
	private String precioTotal;
	private Factura factura;
	private Usuario usuario;
	private static ArrayList<DetallePedido> detallesP = new ArrayList<DetallePedido>();
	private static ArrayList<Pedido> pedidosP = new ArrayList<Pedido>();

	
	public Pedido() {
		
	}

	public Pedido(String codigo, Factura factura, Usuario usuario ) {
		this.codigoP = codigo;
		this.factura = factura;
		this.usuario = usuario;
	}
	public Pedido(String codigo, Factura factura, String precio ) {
		this.codigoP = codigo;
		this.factura = factura;
		this.precioTotal = precio;
	}
	public static void crearPedido(String codigoP, Factura factura, Usuario usuario) {
		Pedido pedidop = new Pedido(codigoP, factura, usuario);
		Datos.pedidos.put(codigoP,pedidop);
		pedidosP.add(pedidop);
		Pedido.calcularPrecioTotal(pedidop);
		
	}
	public static String generarCodigoP() {
		int cont1 = cont;
		cont++;
		String conts = Integer.toString(cont1);
		return conts;
		
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
	public String getPrecioTotal() {
		return precioTotal;
	}
	
	public void setPrecioTotal(String precioTotal) {
		this.precioTotal = precioTotal;
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
			int pt = Integer.parseInt(r.getPrecioTotal());
			sumatoria += pt;
			s = Integer.toString(sumatoria);
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
