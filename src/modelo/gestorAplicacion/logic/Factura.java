package modelo.gestorAplicacion.logic;
import java.util.Date;
import java.util.*;

import modelo.BaseDatos.*;
import modelo.gestorAplicacion.users.*;

public class Factura {
	
	private static int consecutivoFactura = 0; 
	private String codigoFactura;  
	private String fecha;
	private Pedido pedidoFactura;
	public static HashMap<String, Factura> facturas = new HashMap<String, Factura>(); //String = código de la factura

	public Factura() {
		
	}
	
	public Factura(String codigo, String fecha, Pedido pedido) {
		this.codigoFactura = generarCodigoFactura();
		this.fecha = fecha;
		this.pedidoFactura = pedido;
	}
	
	public Factura(Pedido pedido) {
		this.pedidoFactura = pedido;
	}
	
	public static String generarCodigoFactura() {
		String  codigoFactura = Integer.toString(consecutivoFactura);
		consecutivoFactura++;
		return codigoFactura;	
	}
	
	public static Factura crearFactura(Pedido pedido) {
		Factura factura = new Factura(pedido);
		String fecha = factura.obtenerFechaActual();
		String codigoFactura = factura.generarCodigoFactura();
		
		factura.setFecha(fecha);
		factura.setCodigoFactura(codigoFactura);
		
		Factura.facturas.put(codigoFactura, factura);
		
		return factura;
	}
	
	// Devuelve la fecha actual
	public String obtenerFechaActual() {
		Date fechaActual = new Date();
		return fechaActual.toString();
	}
	
	public static int asignacionConsecutivoFactura() {
		int mayor = 0;
		for(Map.Entry<String, Factura> p : Factura.facturas.entrySet()) {
			String c = p.getKey();
			int codigo =Integer.parseInt(c);
			if(codigo > mayor) {
				mayor = codigo;
			}
		}
		return mayor;
	}
	
	public String getCodigoFactura() {
		return codigoFactura;
	}
	public void setCodigoFactura(String codigo) {
		this.codigoFactura = codigo;
	}
	public Pedido getPedidoFactura() {
		return pedidoFactura;
	}
	public void setPedidoFactura(Pedido pedido) {
		this.pedidoFactura = pedido;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public static Factura getFacturaConCodigo(String codigoFactura){
		return Factura.facturas.get(codigoFactura);	
	}
	
	public static int getConsecutivoFactura() {
		return consecutivoFactura;
	}
	
	public static void setConsecutivoFactura(int consecutivoFactura) {
		Factura.consecutivoFactura = consecutivoFactura;
	}

}
