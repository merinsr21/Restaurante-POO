package modelo.gestorAplicacion.logic;
import java.util.*;

import modelo.BaseDatos.*;


public class Comida implements Comparable<Comida> {
	
	private String codigoComida;
	private String nombreComida;
	private int precioComida;
	private int calorias;
	private DetallePedido detallePedidoComida;
	public static HashMap<String, Comida> menuComidas = new HashMap<String, Comida>(); //String= Código de la comida
	private ArrayList<Calificacion> calificaciones = new ArrayList<Calificacion>();
	//private static ArrayList<Comida> menuComida = new ArrayList<Comida>();
	
	public Comida() {
		
	}
	
	public Comida(String codigo, String nombre, int calorias, int precio) {
		this.codigoComida = codigo;
		this.nombreComida = nombre;
		this.precioComida = precio;
		this.calorias = calorias;
	}

	public static void agregarComida(String codigoComida, String nombre, int calorias, int precio) {
		Comida comida = new Comida(codigoComida,nombre,calorias,precio);
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
	
	public int getPrecioComida() {
		return precioComida;
	}
	
	public int getCalorias() {
		return calorias;
	}
	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	
	public DetallePedido getDetallePedidoComida() {
		return detallePedidoComida;
	}

	public void setDetallePedidoComida(DetallePedido detallePedido) {
		this.detallePedidoComida = detallePedido;
	}
	
	public int compareTo(Comida c) {  
		if(precioComida < c.precioComida) {
			return -1;
		}
		if(precioComida > c.precioComida) {
			return 1;
		}
		else {
			return 0;
		}
		
	}
	
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
	public static String ValidacionComida(String codigoComida, String nombreComida, int precioComida, int calorias) {
			if(!Comida.menuComidas.containsKey(codigoComida)) {
				Comida.agregarComida(codigoComida, nombreComida, calorias, precioComida);
				return "La comida se ha agregado en el menú.";
	
			}else {
				return "Este código ya se encuenta en el menú. La comida no ha sido agregada al menú.";
			}		
	}
}
