package modelo.gestorAplicacion.logic;
import java.util.*;

import modelo.BaseDatos.Datos;

public class DetallePedido {
	
	private String codigoDetalle;
	private int cantidad;
	private Comida comida;
	private Pedido pedidoDetalle;
	private int precioUnitario;
	private int precioTotalComida;
	public static HashMap<String, DetallePedido> detallesPedido = new HashMap<String, DetallePedido>(); //String = codigo de el detalle                          
	
	public DetallePedido(Comida comida, int cantidad) { 
		this.cantidad = cantidad;
		this.comida = comida;
	}
	public DetallePedido(String codigoDetalle, Comida comida, int cantidad, Pedido pedidoDetalle) { 
		this.codigoDetalle = codigoDetalle;
		this.cantidad = cantidad;
		this.comida = comida;
		this.pedidoDetalle = pedidoDetalle;
	}
	
	public DetallePedido(String codigoDetalle, Comida comida, int cantidad, String precioTotal, Pedido pedidoDetalle) { 
		this.codigoDetalle = codigoDetalle;
		this.cantidad = cantidad;
		this.comida = comida;
		this.pedidoDetalle = pedidoDetalle;
	}
	public DetallePedido(String codigoD, Comida comida, int cantidad) { 
		this.codigoDetalle = codigoD;
		this.cantidad = cantidad;
		this.comida = comida;
		this.precioTotalComida = precioTotalComida(comida.getPrecioComida(), cantidad);
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
	
	public int getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(int precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public int precioUnitario(int precioUnitario) {
		this.precioUnitario = comida.getPrecioComida();
		return this.precioUnitario;
	}
	public static DetallePedido getDetalleConCodigo(String codigoDet) {
		return DetallePedido.detallesPedido.get(codigoDet);
	}
	
	//¿tiene que ser static?
	public static DetallePedido crearDetallePedido(String codigoDetalle, String codigoComida, int cantidadComida, Pedido pedido) {  //BIEN
		DetallePedido detallito = null;
		for(Map.Entry<String, Comida> menu : Comida.menuComidas.entrySet()) {    //Es necesario hacer que el detallePedido este asociado a una comida existente.
			Comida comidaBuscador = menu.getValue();
			if(comidaBuscador.getCodigoComida().equals(codigoComida)) {
				DetallePedido detallePedido = new DetallePedido(codigoDetalle,comidaBuscador,cantidadComida,pedido);
				detallito = detallePedido;
				int precioComida = comidaBuscador.getPrecioComida(); //habia un .trim() no se que hace pero tiene que ver con String
				precioTotalComida(precioComida, cantidadComida);
				DetallePedido.detallesPedido.put(codigoDetalle,detallePedido);
				break;
			}
		}
		return detallito;
	}
	
	//simplemente hace la operacion de la cantidad de comida por el precio para obtener el precio toal del detalle (no se si sea de ayuda)
	public static int precioTotalComida(int precioComida, int cantidad) {
		return precioComida*cantidad;
	}
	
	public String toString() {
		return "Código: "+comida.getCodigoComida()+"| Nombre: "+comida.getNombreComida()+"| Cantidad: "+cantidad+"| Precio: "+comida.getPrecioComida()+"| Precio Total: "+precioTotalComida(comida.getPrecioComida(), cantidad); 
	}
	
	
	
	
}
