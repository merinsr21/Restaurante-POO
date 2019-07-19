package gestorAplicacion.logic;
import java.util.*;

public class DetallePedido {
	
	private int cantidad;
	private int codigoDet;
	private Comida comida;
	private Pedido pedido;
	private ArrayList<DetallePedido> detalles = new ArrayList<DetallePedido>();
	
	public DetallePedido(int cantidad, int codigoCom,int codigoDet) { //constructor para inicializar comida con base a un código
		this.cantidad = cantidad;
		this.codigoDet = codigoDet;
		for(Comida r : Comida.getMenu()) {
			if(r.getCodigo() == codigoCom ) {
				comida = r;
				break;
			}
		}	
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
	
	
	
	
}
