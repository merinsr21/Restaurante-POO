package modelo.gestorAplicacion.logic;
import java.util.*;

import modelo.BaseDatos.*;
import modelo.gestorAplicacion.users.*;

public class Factura {
	
	private static int consecutivoFactura = 0; 
	private String codigoFactura;  
	private String fecha;
	private Pedido pedidoFactura;
	public static HashMap<String, Factura> facturas = new HashMap<String, Factura>(); //String = código de la factura

	
	public Factura(String codigo, String fecha) {
		this.codigoFactura = generarCodigoFactura();
		this.fecha = fecha;
	}
	public Factura(String codigo, String fecha, Pedido pedido) {
		this.codigoFactura = generarCodigoFactura();
		this.fecha = fecha;
		this.pedidoFactura = pedido;
	}
	public static String generarCodigoFactura() {
		String  codigoFactura = Integer.toString(consecutivoFactura);
		consecutivoFactura++;
		return codigoFactura;	
	}
	public Factura() {
		
	}
	public static Factura crearFactura(Pedido pedido) {
		
	}

	/public  int AsignacionConsecutivo() {
		int mayor = 0;
		for(Map.Entry<String, Factura> factura : facturas.entrySet()) {
			Factura buscador = factura.getValue();
			
		}
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

}
