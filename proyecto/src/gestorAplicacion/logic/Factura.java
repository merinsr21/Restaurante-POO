package gestorAplicacion.logic;
import java.util.*;

import BaseDatos.Datos;
import gestorAplicacion.users.*;
import BaseDatos.*;

public class Factura {
	
	private String codigo;  //concatenar nombreUsuario+fecha
	private String fecha;
	private Usuario usuario;
	private Pedido pedido;
	private  static ArrayList<Factura> facturasF = new ArrayList<Factura>();

	
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
	
	public static Factura getFacturaConCodigo(String codigof){
		return Datos.facturas.get(codigof);	
	}
	

}
