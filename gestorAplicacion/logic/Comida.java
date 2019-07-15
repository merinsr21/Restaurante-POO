package gestorAplicacion.logic;
import java.util.*;

public class Comida implements Comparable<Comida> {
	
	private int codigo;
	private String nombre;
	private int precio;
	private ArrayList<DetallePedido> pedidos = new ArrayList<DetallePedido>();
	private ArrayList<Calificacion> calificaciones = new ArrayList<Calificacion>();
	private static ArrayList<Comida> menu = new ArrayList<Comida>();
	
	public Comida() {
		
	}
	
	
	public Comida(int codigo, String nombre, int precio) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public static void agregarComida(int codigo, String nombre, int precio) {
		Comida comida = new Comida(codigo,nombre,precio);
		getMenu().add(comida);
	}
	
	public String toString() {
		return "    "+codigo+"     "+nombre+"     "+precio;
	}
	

	public static ArrayList<Comida> getMenu() {
		return menu;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int compareTo(Comida c) {                    // como hacer para que el collections.sort() entre el compareTo que yo quiera.
		if(codigo < c.codigo) {
			return -1;
		}
		if(codigo > c.codigo) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public int compareToByPrecio(Comida c) {                    // como hacer para que el collections.sort() entre el compareTo que yo quiera ?
		if(precio < c.precio) {
			return -1;
		}
		if(precio > c.precio) {
			return 1;
		}
		else {
			return 0;
		}
	}

}
