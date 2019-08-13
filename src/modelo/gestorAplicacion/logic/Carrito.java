package modelo.gestorAplicacion.logic;

import modelo.gestorAplicacion.users.*;
import java.util.*;

public class Carrito {
	private Usuario usuario;
	private HashMap<Comida, Integer> carrito = new HashMap<Comida,Integer>();
	
	//A�adir comida al carrito
	public void A�adirComida(Comida comida, int cantidad) {
		carrito.put(comida, cantidad);
	}
	
	//Borrar comida del carrito
	public void BorrarComida(Comida comida) {
		carrito.remove(comida);
	}
	
	//ver carrito
	public HashMap<Comida, Integer> verCarrito(){
		return carrito;
	}
}
