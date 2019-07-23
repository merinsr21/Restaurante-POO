package gestorAplicacion.logic;
import java.util.*;

import BaseDatos.*;


public class Comida implements Comparable<Comida> {
	
	private String codigo;
	private String nombre;
	private String precio;
	private String calorias;
	private ArrayList<DetallePedido> pedidos = new ArrayList<DetallePedido>();
	private ArrayList<Calificacion> calificaciones = new ArrayList<Calificacion>();
	private static ArrayList<Comida> menuC = new ArrayList<Comida>();
	
	public Comida() {
		
	}
	
	public Comida(String codigo, String nombre, String calorias, String precio) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.calorias = calorias;
		Datos.menuComidas.put(codigo, this);      // necesario ? REVISAR!
	}
	
	public static void agregarComida(String codigo, String nombre, String precio, String calorias) {
		Comida comida = new Comida(codigo,nombre,precio,calorias);
		getMenuC().add(comida);
		Datos.menuComidas.put(codigo, comida);
	}
	
	public String toString() {
		return "   "+codigo+"      "+nombre+"         "+precio;
	}
	
	public static ArrayList<Comida> getMenuC() {
		return menuC;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getPrecio() {
		return precio;
	}
	
	public String getCalorias() {
		return calorias;
	}
	
	public void setCalorias(String calorias) {
		this.calorias = calorias;
	}
	
	public int compareTo(Comida c) {  
		int precio1 = Integer.parseInt(precio);
		int precio2 = Integer.parseInt(c.precio);
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

}
