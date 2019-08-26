package modelo.gestorAplicacion.logic;
import java.util.*;

import modelo.BaseDatos.Datos;

public class DetallePedido {
	
	private String codigoDetalle;
	private String cantidad;
	private Comida comida;
	private Pedido pedidoDetalle;
	private String precioUnitario;
	public static HashMap<String, DetallePedido> detallesPedido = new HashMap<String, DetallePedido>(); //String = codigo de el detalle                          
	
	public DetallePedido(String codigoDetalle, String cantidad, Comida comida,Pedido pedidoDetalle) {
		this.codigoDetalle = codigoDetalle;
		this.cantidad = cantidad;
		this.comida = comida;
		this.pedidoDetalle = pedidoDetalle;
		this.precioUnitario = obtenerPrecioUnitario();
	}
	
	public DetallePedido() {
		
	}
	public String getCodigoDetalle() {
		return codigoDetalle;
	}
	public Pedido getPedidoDetalle() {
		return pedidoDetalle;
	}
	public void setPedidoDetalle(Pedido pedido) {
		this.pedidoDetalle = pedido;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public Comida getComida() {
		return comida;
	}
	public void setComida(Comida comida) {
		this.comida = comida;
	}
	
	public String getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(String precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public String  obtenerPrecioUnitario() {
		return comida.getPrecioComida();
	}
	
	public static DetallePedido getDetalleConCodigo(String codigoDet) {
		return DetallePedido.detallesPedido.get(codigoDet);
	}
	
	public static DetallePedido crearDetallePedido(String codigoDetalle, String cantidadComida, Comida comida, Pedido pedido) {  
		DetallePedido detalle = new DetallePedido(codigoDetalle, cantidadComida, comida, pedido);
		return detalle;
	}
	
	public int precioTotalComida() {
		int precioUnitario = Integer.parseInt(this.precioUnitario);
		int cantidad = Integer.parseInt(this.cantidad);
		return precioUnitario*cantidad;
	}
	
	public String toString() {
		return "Código: "+comida.getCodigoComida()+"| Nombre: "+comida.getNombreComida()+"| Cantidad: "+cantidad+"| Precio: "+comida.getPrecioComida()+"| Precio Total: "+precioTotalComida(); 
	}
	
	// Dveuelve la comida mas pedida
	public String verComidaMasPedida() {
		HashMap<Comida, Integer> comidas = new HashMap<Comida, Integer>();
		for(Map.Entry<String, DetallePedido> Dpedido : DetallePedido.detallesPedido.entrySet()) {
			DetallePedido detalle = Dpedido.getValue();
			int cantidad = Integer.parseInt(detalle.getCantidad());
			Comida comida = detalle.getComida();
			if(!comidas.containsKey(comida)) {
				comidas.put(comida,cantidad);
			}
			else {
				int cantidadActual = comidas.get(comida);
				comidas.put(comida,cantidadActual+cantidad);
			}
		}
		int  contador = 0;
		Comida comida = null;
		for(Map.Entry<Comida, Integer> p : comidas.entrySet()) {
			int cantidad = p.getValue();
			if(cantidad > contador) {
				contador = cantidad;
				comida = p.getKey();
			}
		}
		return "La comida mas pedida es "+comida.getNombreComida()+" y ha sido pedida "+contador+" veces";
	}
	
}
