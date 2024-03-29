package modelo.gestorAplicacion.logic;
import java.util.*;

import modelo.BaseDatos.*;


public class Comida  {
	
	private String codigoComida;
	private String nombreComida;
	private String precioComida;
	private String calorias;
	private String disponible = "true";                //Identificar que comidas se pueden ver en el menu del usuario.
	private DetallePedido detallePedidoComida;
	public static HashMap<String, Comida> menuComidas = new HashMap<String, Comida>(); //String  = C�digo de la comida
	private ArrayList<Calificacion> calificacionesComida = new ArrayList<Calificacion>();
	
	public Comida() {
		
	}
	
	public Comida(String codigoComida, String nombreComida, String precioComida, String calorias) {
		this.codigoComida = codigoComida;
		this.nombreComida = nombreComida;
		this.precioComida = precioComida;
		this.calorias = calorias;	
	}

	public static void agregarComida(String codigoComida, String nombreComida, String precioComida, String calorias) {
		Comida comida = new Comida(codigoComida,nombreComida,precioComida,calorias);
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
		String print = "La comida que desea borrar no se encuentra en el men�.";
		for(Map.Entry<String, Comida> comida : Comida.menuComidas.entrySet()) {
			String comidaLlave = comida.getKey();
			Comida comidaValor = comida.getValue();
				if(comidaLlave.equals(codigoComida)) {
					print = comidaValor.getNombreComida()+" "+"ha sido eliminada del men�.";
					Comida.menuComidas.remove(comidaLlave);
					break;
				}						
		}
		return print;
	}
	
	// Verifica que los datos ingresados por el admin sean validos para agregar una comida.
	public static String ValidacionComida(String codigoComida, String nombreComida, String precioComida, String calorias) {
			if(!Comida.menuComidas.containsKey(codigoComida)) {
				Comida.agregarComida(codigoComida, nombreComida,precioComida,calorias);
				return "La comida se ha agregado en el men�.";
	
			}else {
				return "Este c�digo ya se encuenta en el men�. La comida no ha sido agregada al men�.";
			}		
	}
	
	// Retorna todas las comidas existentes
	public HashMap<String,Comida> getMenuComida(){
		return menuComidas;
	}
	
	// Retorna las comidas disponibles para ser ordenadas por el usuario
	public static ArrayList<Comida> obtenerComidasDisponibles(){
		ArrayList<Comida> comidasDisponibles = new ArrayList<Comida>();
		for(Map.Entry<String, Comida> c : Comida.menuComidas.entrySet()) {
			Comida comida = c.getValue();
			if(comida.getDisponible().equals("true")) {
				comidasDisponibles.add(comida);
			}
		}
		return comidasDisponibles;
	}
}
