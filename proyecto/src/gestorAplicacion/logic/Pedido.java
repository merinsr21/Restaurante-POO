package gestorAplicacion.logic;
import java.util.*;

import BaseDatos.Datos;
import gestorAplicacion.users.*;

public class Pedido {
	
	private String codigoP;
	private String precioTotal;
	private Chef chef;
	private Factura factura;
	private Usuario usuario;
	private  ArrayList<DetallePedido> detallesP = new ArrayList<DetallePedido>();
	private  static ArrayList<Pedido> pedidosP = new ArrayList<Pedido>();

	
	public Pedido() {
		
	}
	public Pedido(Usuario usuario) {
		this.usuario = usuario;
	}
	public Pedido(String codigo, Factura factura, String precio, Usuario usuario /*Chef chef*/) {
		this.codigoP = codigo;
		this.factura = factura;
		this.precioTotal = precio;
		this.usuario = usuario;
		//this.chef = chef;
	}
	public static void crearPedido(String codigo, Factura factura, String precio, Usuario usuario/*, Chef chef*/) {
		Pedido pedidop = new Pedido(codigo, factura, precio, usuario);
		Datos.pedidos.put(codigo,pedidop);
		pedidosP.add(pedidop);
		
	}
	public String getCodigo() {
		return codigoP;
	}
	public void setCodigo(String codigo) {
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
	public Chef getChef() {
		return chef;
	}
	public void setChef(Chef chef) {
		this.chef = chef;
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
	public static ArrayList<Pedido> getPedidosP(String nombre){
		return pedidosP;
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
}
