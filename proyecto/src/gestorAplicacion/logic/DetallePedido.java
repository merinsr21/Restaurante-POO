package gestorAplicacion.logic;
import java.util.*;

public class DetallePedido {
	
	private int cantidad;
	private Comida comida;
	private Pedido pedido;
	private String precioTotal;
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
	
	public String getPrecioTotal() {
		return precioTotal;
	}
	
	public void setPrecioTotal(String precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	
	public static DetallePedido crearDetallePedido(int codigo, int cantidad) {
		DetallePedido t = null;
		for(Comida r: Comida.getMenuC()) {
			if(r.getCodigo().equals(codigo)) {
				DetallePedido detallePedido = new DetallePedido(cantidad,r);
				t = detallePedido;
				int gp = Integer.parseInt(r.getPrecio());
				String gpc = Integer.toString(gp*cantidad);
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
