package gestorAplicacion.logic;
import java.util.*;

import BaseDatos.Datos;
import gestorAplicacion.users.*;

public class Factura {
	
	private String codigo;
	private String fecha;
	private Usuario usuario;
	private Pedido pedido;
	private ArrayList<Calificacion> calificaciones = new ArrayList<Calificacion>();
	
	public Factura(Usuario usuario, Pedido pedido, String fecha) {
		this.usuario = usuario;
		this.pedido = pedido;
		this.fecha = fecha;
	}
	public Factura() {
		
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
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
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public ArrayList<Calificacion> getCalificaciones() {
		return calificaciones;
	}
	public void setCalificaciones(Calificacion calificacion) {
		calificaciones.add(calificacion);
	}
	public static Factura getFacturaConCodigo(String codigo) {
		return Datos.facturas.get(codigo);
	}
	

}
