package gestorAplicacion.logic;
import java.util.*;

public class DetallePedido {
	
	private int cantidad;
	private Comida comida;
	private Pedido pedido;
	private int precioTotal;
	private ArrayList<DetallePedido> detallesD = new ArrayList<DetallePedido>();
	
	public DetallePedido(int cantidad, Comida comida) { 
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
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
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
	
	public int getPrecioTotal() {
		return precioTotal;
	}
	
	public void setPrecioTotal(int precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	
	public static DetallePedido crearDetallePedido(int codigo, int cantidad) {
		DetallePedido t = null;
		for(Comida r: Comida.getMenu()) {
			if(r.getCodigo() == codigo) {
				DetallePedido detallePedido = new DetallePedido(cantidad,r);
				t = detallePedido;
				detallePedido.setPrecioTotal(r.getPrecio()*cantidad);
				break;
			}
		}
		return t;
	}
	
	public String toString() {
		return comida.getCodigo()+" "+comida.getNombre()+" "+cantidad+" "+comida.getPrecio()+" "+precioTotal; 
	}
	
	
}
