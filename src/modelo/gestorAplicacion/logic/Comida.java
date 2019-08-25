package modelo.gestorAplicacion.logic;
import java.util.*;

import modelo.BaseDatos.*;


public class Comida  {
	
	private String codigoComida;
	private String nombreComida;
	private String precioComida;
	private String calorias;
	public String disponible = "true";                //Identificar que comidas se pueden ver en el menu del usuario.
	private DetallePedido detallePedidoComida;
	public static HashMap<String, Comida> menuComidas = new HashMap<String, Comida>(); //String  = Código de la comida
	private ArrayList<Calificacion> calificacionesComida = new ArrayList<Calificacion>();
	//private static ArrayList<Comida> menuComida = new ArrayList<Comida>();
	
	public Comida() {
		
	}
	
	public Comida(String codigoComida, String nombreComida, String precioComida, String calorias, String disponible) {
		this.codigoComida = codigoComida;
		this.nombreComida = nombreComida;
		this.precioComida = precioComida;
		this.calorias = calorias;
		this.disponible = disponible;		
	}

	public static void agregarComida(String codigoComida, String nombreComida, String precioComida, String calorias, String disponible ) {
		Comida comida = new Comida(codigoComida,nombreComida,precioComida,calorias,disponible);
		Comida.menuComidas.put(codigoComida, comida);
	}
	
	public String toString() {
		return "   "+codigoComida+"      "+nombreComida+"            "+precioComida+"         " + calorias;
	}
	
	
	
	public String getCodigoComida() {
		return codigoComida;
	}
	
	public String getNombreComida() {
		return nombreComida;
	}
	
	public String getPrecioComida() {
		return precioComida;
	}
	
	public String getCalorias() {
		return calorias;
	}
	public void setCalorias(String calorias) {
		this.calorias = calorias;
	}
	
	public DetallePedido getDetallePedidoComida() {
		return detallePedidoComida;
	}

	public void setDetallePedidoComida(DetallePedido detallePedido) {
		this.detallePedidoComida = detallePedido;
	}
	
	public String getDisponible() {
		return disponible;
	}
	
	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}
	
	public ArrayList<Calificacion> getCalificacionesComida() {
		return calificacionesComida;
	}
	
	public void setCalificacionesComida(Calificacion calificacion) {
		calificacionesComida.add(calificacion);
	}
	
	
	//      REVISAR
	/*public int compareTo(Comida c) {  
		if(precioComida < c.precioComida) {
			return -1;
		}
		if(precioComida > c.precioComida) {
			return 1;
		}
		else {
			return 0;
		}
		
	}*/
	
	public static Comida getComidaConCodigo(String codigoComida) {
		return Comida.menuComidas.get(codigoComida);
	}
	
	// Elimina la comida cuyo codigo corresponda por el ingresado por el admin.
	public static String borrarComida(String codigoComida) {
		String print = "La comida que desea borrar no se encuentra en el menú.";
		for(Map.Entry<String, Comida> comida : Comida.menuComidas.entrySet()) {
			String comidaLlave = comida.getKey();
			Comida comidaValor = comida.getValue();
				if(comidaLlave.equals(codigoComida)) {
					print = comidaValor.getNombreComida()+" "+"ha sido eliminada del menú.";
					Comida.menuComidas.remove(comidaLlave);
					break;
				}						
		}
		return print;
	}
	
	// Verifica que los datos ingresados por el admin sean validos para agregar una comida.
	public static String ValidacionComida(String codigoComida, String nombreComida, String precioComida, String calorias, String disponible) {
			if(!Comida.menuComidas.containsKey(codigoComida)) {
				Comida.agregarComida(codigoComida, nombreComida,precioComida,calorias,disponible);
				return "La comida se ha agregado en el menú.";
	
			}else {
				return "Este código ya se encuenta en el menú. La comida no ha sido agregada al menú.";
			}		
	}
}
