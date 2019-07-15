package gestorAplicacion.logic;
import java.util.*;
import gestorAplicacion.users.*;

public class Pedido {
	
	private int codigo;
	private Factura factura;
	private Usuario usuario;
	private Mesa mesa;
	private Boolean preparado;   //inicializa en false
	private ArrayList<DetallePedido> detalles = new ArrayList<DetallePedido>();
	private Chef chef;
	
	
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
	public void setDetalles(ArrayList<DetallePedido> detalles) {
		this.detalles = detalles;
	}
	public Chef getChef() {
		return chef;
	}
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	
	
}
