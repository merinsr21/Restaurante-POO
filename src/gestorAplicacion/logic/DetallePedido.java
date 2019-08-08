package gestorAplicacion.logic;
import java.util.*;

import BaseDatos.Datos;

public class DetallePedido {
	
	private static int cont = 500;
	private String codigoD;
	private String cantidad;
	private Comida comida;
	private Pedido pedidoD;
	private String precioTotal;
	private static ArrayList<DetallePedido> detallesD = new ArrayList<DetallePedido>();
	
	public DetallePedido(String cantidad, Comida comida) { 
		this.cantidad = cantidad;
		this.comida = comida;
	}
	public DetallePedido(String codigoD, String cantidad, Comida comida, Pedido pedidoD) { 
		this.codigoD = codigoD;
		this.cantidad = cantidad;
		this.comida = comida;
		this.pedidoD = pedidoD;
	}
	
	public DetallePedido(String codigoD, String cantidad, Comida comida, String precioTotal, Pedido pedidoD) { 
		this.codigoD = codigoD;
		this.cantidad = cantidad;
		this.comida = comida;
		this.precioTotal = precioTotal;
		this.pedidoD = pedidoD;
	}
	public DetallePedido(String codigoD, String cantidad, Comida comida, String precioTotal) { 
		this.codigoD = codigoD;
		this.cantidad = cantidad;
		this.comida = comida;
		this.precioTotal = precioTotal;
	}
	
	public static String generarCodigoD() {
		int cont1 = cont;
		cont++;
		String conts = Integer.toString(cont1);
		return conts;	
	}
	public DetallePedido() {
		
	}
	public String getCodigoD() {
		return codigoD;
	}
	public Pedido getPedidoD() {
		return pedidoD;
	}
	public void setPedido(Pedido pedido) {
		this.pedidoD = pedido;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public Comida getComida() {
		return comida;
	}
	public void setComida(Comida comida) {
		this.comida = comida;
	}
	public ArrayList<DetallePedido> getDetallesD() {
		return detallesD;
	}
	public static void setDetallesD(DetallePedido detP) {
		 detallesD.add(detP);
	}
	
	public String getPrecioTotal() {
		return precioTotal;
	}
	
	public void setPrecioTotal(String precioTotal) {
		this.precioTotal = precioTotal;
	}
	public static DetallePedido getDetalleConCodigo(String codigoDet) {
		return Datos.detallesPedido.get(codigoDet);
	}
	
	public static DetallePedido crearDetallePedido(String codigoD, String cantidad, String codigo, Pedido pedido) {  //BIEN
		
		DetallePedido t = null;
		for(Map.Entry<String, Comida> menu : Datos.menuComidas.entrySet()) {       //Es necesario hacer que el detallePedido este asociado a una comida existente.
			Comida comidaOb = menu.getValue();
			if(comidaOb.getCodigo().equals(codigo)) {
				DetallePedido detallePedido = new DetallePedido(codigoD,cantidad,comidaOb,pedido);
				t = detallePedido;
				int gp = Integer.parseInt(comidaOb.getPrecio().trim());
				int cant = Integer.parseInt(cantidad);
				String gpc = Integer.toString(gp*cant);
				detallePedido.setPrecioTotal(gpc);
				Datos.detallesPedido.put(codigoD,detallePedido);
				break;
			}
		}
		return t;
	}
	
	public String toString() {
		return "Código: "+comida.getCodigo()+"| Nombre: "+comida.getNombre()+"| Cantidad: "+cantidad+"| Precio: "+comida.getPrecio()+"| Precio Total: "+precioTotal; 
	}
	
	
}
