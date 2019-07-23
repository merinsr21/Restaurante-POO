package gestorAplicacion.logic;
import java.util.*;
import gestorAplicacion.users.*;

public class Pedido {
	
	private String codigoP;
	private String precioTotal;
	private Boolean preparado;   
	private Chef chef;
	private Factura factura;
	private Usuario usuario;
	private Mesa mesa;
	private  ArrayList<DetallePedido> detallesP = new ArrayList<DetallePedido>();
	
	
	public Pedido() {
		
	}
	public Pedido(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getCodigo() {
		return codigoP;
	}
	public void setCodigo(String codigo) {
		this.codigoP = codigo;
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
	public ArrayList<DetallePedido> getDetallesP() {
		return detallesP;
	}
	public void setDetallesP(DetallePedido detalle) {
		detallesP.add(detalle);
	}
	public Chef getChef() {
		return chef;
	}
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getPrecioTotal() {
		return precioTotal;
	}
	
	public void setPrecioTotal(String precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	public static int calcularPrecioTotal(Pedido pedido) {
		int sumatoria = 0;
		String s = null;
		for(DetallePedido r: pedido.getDetallesP()) {
			int pt = Integer.parseInt(r.getPrecioTotal());
			sumatoria += pt;
			s = Integer.toString(sumatoria);
                }
		pedido.setPrecioTotal(s);
		return sumatoria;
	}
}
