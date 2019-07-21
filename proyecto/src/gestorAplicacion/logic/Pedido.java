package gestorAplicacion.logic;
import java.util.*;
import gestorAplicacion.users.*;

public class Pedido {
	
	private int codigo;
	private int precioTotal;
	private Boolean preparado;   
	private Chef chef;
	private Factura factura;
	private Usuario usuario;
	private Mesa mesa;
	private  ArrayList<DetallePedido> detalles = new ArrayList<DetallePedido>();
	
	public Pedido() {
		
	}
	public Pedido(Usuario usuario) {
		this.usuario = usuario;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	public Mesa getMesa() {
		return mesa;
	}
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	public Boolean getPreparado() {
		return preparado;
	}
	public void setPreparado(Boolean preparado) {
		this.preparado = preparado;
	}
	public ArrayList<DetallePedido> getDetalles() {
		return detalles;
	}
	public void setPedidosP(DetallePedido detalle) {
		detalles.add(detalle);
	}
	public Chef getChef() {
		return chef;
	}
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public int getPrecioTotal() {
		return precioTotal;
	}
	
	public void setPrecioTotal(int precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	public int CalcularPrecioTotal(Pedido pedido) {
		int sumatoria = 0;
		for(DetallePedido r: pedido.getDetalles()) {
			sumatoria += r.getPrecioTotal();
		}
		pedido.setPrecioTotal(sumatoria);
		return sumatoria;
	}
}
