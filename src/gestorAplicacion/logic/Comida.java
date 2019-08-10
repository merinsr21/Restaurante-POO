package gestorAplicacion.logic;
import java.util.*;

import BaseDatos.*;


public class Comida implements Comparable<Comida> {
	
	private String codigoComida;
	private String nombreComida;
	private String precioComida;
	private String calorias;
	private DetallePedido detallePedidoComida;
	private ArrayList<Calificacion> calificaciones = new ArrayList<Calificacion>();
	private static ArrayList<Comida> menuComida = new ArrayList<Comida>();
	
	public Comida() {
		
	}
	
	public Comida(String codigo, String nombre, String calorias, String precio) {
		this.codigoComida = codigo;
		this.nombreComida = nombre;
		this.precioComida = precio;
		this.calorias = calorias;
	}
	
	public static void agregarComida(String codigoComida, String nombre, String precio, String calorias) {
		Comida comida = new Comida(codigoComida,nombre,precio,calorias);
		setMenuComida(comida);
		Datos.menuComidas.put(codigoComida, comida);
	}
	
	public String toString() {
		return "   "+codigoComida+"      "+nombreComida+"            "+precioComida+"         " + calorias;
	}
	
	public static ArrayList<Comida> getMenuComida() {
		return menuComida;
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
	
	public DetallePedido getDetallePedidoComida() {
		return detallePedidoComida;
	}

	public void setDetallePedidoComida(DetallePedido detallePedido) {
		this.detallePedidoComida = detallePedido;
	}

	public static void setMenuComida(Comida comida) {
		Comida.menuComida.add(comida);
	}

	public void setCalorias(String calorias) {
		this.calorias = calorias;
	}
	
	public int compareTo(Comida c) {  
		int precio1 = Integer.parseInt(precioComida);
		int precio2 = Integer.parseInt(c.precioComida);
		if(precio1 < precio2) {
			return -1;
		}
		if(precio1 > precio2) {
			return 1;
		}
		else {
			return 0;
		}
		
	}
	public int compareTo1(Comida c) {      
		int codigo1 = Integer.parseInt(codigoComida);
		int codigo2 = Integer.parseInt(c.codigoComida);
		if(codigo1 < codigo2) {
			return -1;
		}
		if(codigo1 > codigo2) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public static Comida getComidaConCodigo(String codigoComida) {
		return Datos.menuComidas.get(codigoComida);
	}
	
	public static String borrarComida(String codigoComida) {
		String print = "La comida que desea borrar no se encuentra en el menú.";
		for(Map.Entry<String, Comida> comida : Datos.menuComidas.entrySet()) {
			String comida1 = comida.getKey();
			Comida comida12 = comida.getValue();
				if(comida1.equals(codigoComida)) {
					print = comida12.getNombreComida()+" "+"ha sido eliminada del menú.";
					Comida.getMenuComida().remove(comida12);  
					Datos.menuComidas.remove(comida1);
					break;
				}						
		}
		return print;
	}

}
