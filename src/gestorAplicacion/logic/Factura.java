package gestorAplicacion.logic;
import java.util.*;
import gestorAplicacion.users.*;
import BaseDatos.*;

public class Factura {
	
	private static int cont = 300;    //para generar el código
	private String codigoF;  
	private String fecha;
	private Pedido pedidoF;
	private  static ArrayList<Factura> facturasF = new ArrayList<Factura>();

	
	public Factura(String codigo, String fecha) {
		this.codigoF = codigo;
		this.fecha = fecha;
	}
	public Factura(String codigo, String fecha, Pedido pedido) {
		this.codigoF = codigo;
		this.fecha = fecha;
		this.pedidoF = pedido;
	}
	public static String generarCodigoF() {
		int cont1 = cont;
		cont++;
		String conts = Integer.toString(cont1);
		return conts;	
	}
	public Factura() {
		
	}
	public String getCodigoF() {
		return codigoF;
	}
	public void setCodigoF(String codigo) {
		this.codigoF = codigo;
	}
	public Pedido getPedidoF() {
		return pedidoF;
	}
	public void setPedidoF(Pedido pedido) {
		this.pedidoF = pedido;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public static void setFacturasF(Factura factura) {
		facturasF.add(factura);
	} 
	public static Factura getFacturaConCodigo(String codigof){
		return Datos.facturas.get(codigof);	
	}

}
