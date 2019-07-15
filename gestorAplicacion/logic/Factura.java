package gestorAplicacion.logic;
import java.util.*;
import gestorAplicacion.users.*;

public class Factura {
	
	private int codigo;
	private Usuario usuario;
	private Pedido pedido;
	private ArrayList<Calificacion> calificaciones = new ArrayList<Calificacion>();
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public ArrayList<Calificacion> getCalificaciones() {
		return calificaciones;
	}
	public void setCalificaciones(ArrayList<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}
	
	
	
}
