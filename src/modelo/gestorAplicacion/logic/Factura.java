package modelo.gestorAplicacion.logic;
import java.util.*;

import modelo.BaseDatos.*;
import modelo.gestorAplicacion.users.*;

public class Factura {
	
	private static int consecutivoFactura = 0;    //para generar el código
	private String codigoFactura;  
	private String fecha;
	private Pedido pedidoFactura;
	public static HashMap<String, Factura> facturas = new HashMap<String, Factura>(); //String = código de la factura
	private  static ArrayList<Factura> facturasFactura = new ArrayList<Factura>();

	
	public Factura(String codigo, String fecha) {
		this.codigoFactura = codigo;
		this.fecha = fecha;
	}
	public Factura(String codigo, String fecha, Pedido pedido) {
		this.codigoFactura = codigo;
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
	public static void setFacturasFactura(Factura factura) {
		facturasFactura.add(factura);
	} 
	public static Factura getFacturaConCodigo(String codigoFactura){
		return Factura.facturas.get(codigoFactura);	
	}

}
