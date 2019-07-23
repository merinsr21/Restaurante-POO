package gestorAplicacion.users;
import java.util.ArrayList;
import gestorAplicacion.logic.Pedido;

public class Chef {
	private boolean estado;
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(Pedido pedido) {
		pedidos.add(pedido);
	}
	
	
	
}
