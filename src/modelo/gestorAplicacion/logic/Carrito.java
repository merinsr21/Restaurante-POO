package modelo.gestorAplicacion.logic;

import modelo.gestorAplicacion.users.*;
import java.util.*;

public class Carrito {
	private Usuario usuario;
	private HashMap<Comida, Integer> carrito = new HashMap<Comida,Integer>();   // key = comida, value = cantidad
	
	//Añadir comida al carrito
	public void añadirComida(Comida comida, int cantidad) {
		carrito.put(comida, cantidad);
	}
	
	//Borrar comida del carrito
	public void borrarComida(Comida comida) {
		carrito.remove(comida);
	}
	
	//ver carrito
	public HashMap<Comida, Integer> verCarrito(){
		return carrito;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
