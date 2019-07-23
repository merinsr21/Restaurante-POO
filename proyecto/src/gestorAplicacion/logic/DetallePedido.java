package gestorAplicacion.logic;
import java.util.*;

import BaseDatos.Datos;

public class DetallePedido {
	

	private String codigoD;
	private String cantidad;
	private Comida comida;
	private Pedido pedido;
	private String precioTotal;
	private ArrayList<DetallePedido> detallesD = new ArrayList<DetallePedido>();
	
	public DetallePedido(String cantidad, Comida comida) { 
		this.cantidad = cantidad;
		this.comida = comida;
	}
	public DetallePedido() {
		
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
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
	
	public String getPrecioTotal() {
		return precioTotal;
	}
	
	public void setPrecioTotal(String precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	
	public static DetallePedido crearDetallePedido(int codigo, String cantidad) {
		DetallePedido t = null;
		for(Map.Entry<String, Comida> menu : Datos.menuComidas.entrySet()) {
			Comida comidaOb = menu.getValue();
			if(comidaOb.getCodigo().equals(codigo)) {
				DetallePedido detallePedido = new DetallePedido(cantidad,comidaOb);
				t = detallePedido;
				int gp = Integer.parseInt(comidaOb.getPrecio());
				int c = Integer.parseInt(cantidad);
				String gpc = Integer.toString(gp*c);
				detallePedido.setPrecioTotal(gpc);
				break;
			}
		}
		return t;
	}
	
	public String toString() {
		return "Código: "+comida.getCodigo()+"| Nombre: "+comida.getNombre()+"| Cantidad: "+cantidad+"| Precio: "+comida.getPrecio()+"| Precio Total: "+precioTotal; 
	}
	
	
}
