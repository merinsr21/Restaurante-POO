package gestorAplicacion.logic;
import java.util.*;
import gestorAplicacion.users.*;

public class Pedido {
	
	private int codigo;
	private Boolean preparado;   //inicializa en false
	private Chef chef;
	private Factura factura;
	private Usuario usuario;
	private Mesa mesa;
	private  ArrayList<DetallePedido> pedidosP = new ArrayList<DetallePedido>();
	
	public Pedido() {
		
	}
	public Pedido(int codigo) {
		this.codigo = codigo;
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
		return pedidosP;
	}
	public void setPedidosP(DetallePedido detalle) {
		pedidosP.add(detalle);
	}
	public Chef getChef() {
		return chef;
	}
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	public void hacerPedido() {
		
	}
	public void crearDetallePedido(int cantidad, int codigo) {                          //funcionaldad de hacer pedido
		DetallePedido detalle = new DetallePedido(cantidad, codigo, codigo+1);
		Pedido pedido = new Pedido(codigo+2);
		Usuario usuaio = new Usuario();
		pedido.setPedidosP(detalle);
		usuario.setPedidosU(pedido);
	}
	public int precioTotal() {
		int sum = 0;
		for(DetallePedido t : pedidosP) {
			int codigo = t.getComida().getPrecio();
			int cantidad = t.getCantidad();
			for(Comida x : Comida.getMenu()) {
				if(x.getCodigo() == codigo) {
					sum += x.getPrecio();
				}
			}
		}
	
	}
	
	
	
}
