package modelo.gestorAplicacion.logic;
import java.util.*;

import modelo.BaseDatos.Datos;

public class DetallePedido {
	
	private static int consecutivoDetalle = 500;
	private String codigoDetalle;
	private String cantidad;
	private Comida comida;
	private Pedido pedidoDetalle;
	private int precioUnitario;
	private String precioTotal;
	public static HashMap<String, DetallePedido> detallesPedido = new HashMap<String, DetallePedido>(); //String = codigo de el detalle                          
	private static ArrayList<DetallePedido> detallesDetalle = new ArrayList<DetallePedido>();
	
	public DetallePedido(Comida comida, String cantidad) { 
		this.cantidad = cantidad;
		this.comida = comida;
	}
	public DetallePedido(String codigoD, Comida comida, String cantidad, Pedido pedidoD) { 
		this.codigoDetalle = codigoD;
		this.cantidad = cantidad;
		this.comida = comida;
		this.pedidoDetalle = pedidoD;
	}
	
	public DetallePedido(String codigoD, Comida comida, String cantidad, String precioTotal, Pedido pedidoD) { 
		this.codigoDetalle = codigoD;
		this.cantidad = cantidad;
		this.comida = comida;
		this.precioTotal = precioTotal;
		this.pedidoDetalle = pedidoD;
	}
	public DetallePedido(String codigoD, Comida comida, String cantidad, String precioTotal) { 
		this.codigoDetalle = codigoD;
		this.cantidad = cantidad;
		this.comida = comida;
		this.precioTotal = precioTotal;
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
	public ArrayList<DetallePedido> getDetallesDetalle() {
		return detallesDetalle;
	}
	public static void setDetallesDetalle(DetallePedido detallePedido) {
		 detallesDetalle.add(detallePedido);
	}
	
	public String getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(String precioTotal) {
		this.precioTotal = precioTotal;
	}
	public int precioUnitario(int precioUnitario) {
		this.precioUnitario = comida.getPrecioComida();
		return this.precioUnitario;
	}
	public static DetallePedido getDetalleConCodigo(String codigoDet) {
		return DetallePedido.detallesPedido.get(codigoDet);
	}
	
	public static DetallePedido crearDetallePedido(String codigoDetalle, String codigoComida, String cantidad, Pedido pedido) {  //BIEN
		DetallePedido detallito = null;
		for(Map.Entry<String, Comida> menu : Comida.menuComidas.entrySet()) {    //Es necesario hacer que el detallePedido este asociado a una comida existente.
			Comida comidaBuscador = menu.getValue();
			if(comidaBuscador.getCodigoComida().equals(codigoComida)) {
				DetallePedido detallePedido = new DetallePedido(codigoDetalle,comidaBuscador,cantidad,pedido);
				detallito = detallePedido;
				int precioComida = Integer.parseInt(comidaBuscador.getPrecioComida().trim());
				int cantidadComida = Integer.parseInt(cantidad);
				String precioTotalComida = Integer.toString(precioComida*cantidadComida);
				detallePedido.setPrecioTotal(precioTotalComida);
				DetallePedido.detallesPedido.put(codigoDetalle,detallePedido);
				break;
			}
		}
		return detallito;
	}
	
	public String toString() {
		return "Código: "+comida.getCodigoComida()+"| Nombre: "+comida.getNombreComida()+"| Cantidad: "+cantidad+"| Precio: "+comida.getPrecioComida()+"| Precio Total: "+precioTotal; 
	}
	
	
	
	
}
