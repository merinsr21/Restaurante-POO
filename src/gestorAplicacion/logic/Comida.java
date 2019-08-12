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
	
	// LAURA (REVSAR)
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
	
	// Elimina la comida cuyo codigo corresponda por el ingresado por el admin.
	public static String borrarComida(String codigoComida) {
		String print = "La comida que desea borrar no se encuentra en el menú.";
		for(Map.Entry<String, Comida> comida : Datos.menuComidas.entrySet()) {
			String comidaLlave = comida.getKey();
			Comida comidaValor = comida.getValue();
				if(comidaLlave.equals(codigoComida)) {
					print = comidaValor.getNombreComida()+" "+"ha sido eliminada del menú.";
					Comida.getMenuComida().remove(comidaValor);  
					Datos.menuComidas.remove(comidaLlave);
					break;
				}						
		}
		return print;
	}
	
	// Verifica que los datos ingresados por el admin sean validos para agregar una comida.
	public static String ValidacionComida(String codigoComida, String nombreComida, String precioComida, String calorias) {
		if(Integer.parseInt(codigoComida) >= 100 && Integer.parseInt(codigoComida) <= 199) {
			if(!Datos.menuComidas.containsKey(codigoComida)) {
				Comida.agregarComida(codigoComida, nombreComida, precioComida, calorias);
				return "La comida se ha agregado en el menú.";
	
			}else {
				return "Este código ya se encuenta en el menú. La comida no ha sido agregada al menú.";
			}
		}
		else {
			return "El código no se encuentra en el intervalo exigido, 100-199";
		}
	}
}
