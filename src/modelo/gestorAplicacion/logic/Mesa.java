package modelo.gestorAplicacion.logic;
import java.util.*;
import uiMain.Main;
import modelo.BaseDatos.Datos;
import modelo.gestorAplicacion.users.*;

public class Mesa {
	
	private String codigoMesa;
	private String numeroDeSillas;
	private Usuario usuario;
	public static HashMap<String, Mesa> mesas = new HashMap<String, Mesa>();   //String= Código de la mesa

	public Mesa() {

	}
	public Mesa(String codigoMesa, String numeroDeSillas, Usuario usuario) {      
		this.codigoMesa = codigoMesa;
		this.numeroDeSillas = numeroDeSillas;
		this.usuario = usuario;
	}
	public Mesa(String codigoMesa, String numeroDeSillas) {
		this.codigoMesa = codigoMesa;
		this.numeroDeSillas = numeroDeSillas;
	}
	
	// el codigo de la mesa lo ingresa el admin al momento de crearla.
	public static void crearMesa(String codigoMesa, String numeroDeSillas) {
		Mesa mesa = new Mesa(codigoMesa,numeroDeSillas);               
		Mesa.mesas.put(codigoMesa, mesa);
	}
	
	public String getCodigoMesa() {
		return codigoMesa;
	}
	
	public String getNumeroDeSillas() {
		return numeroDeSillas;
	}	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String toString() {
		return "Mesa número "+getCodigoMesa();
	}
	
	// Le asigna a un usuario una mesa, en caso de que esta este disponible.
	public static String ocuparMesa(String codigoMesa) {             
		String print = "La mesa que desea ocupar no existe";
		for(Map.Entry<String, Mesa> mesa : Mesa.mesas.entrySet()) {
			Mesa buscador = mesa.getValue();
			if(buscador.getCodigoMesa().equals(codigoMesa)) {
				if(buscador.getUsuario() != null) {
					print = "La mesa ya se encuentra ocupada.";
					break;
				}
				else {
					Main.usuario.setMesa(buscador);
					buscador.setUsuario(Main.usuario);
					print = "La mesa con código "+buscador.getCodigoMesa()+" ha sido ocupada.";
					break;
				}
			}
		}
		return print;
	}
	
	// Al cerrar sesion se desocupa la mesa correspondiente a ese usuario y esta queda disponible para ser ocupada por otro usuario.
	public static void liberarMesa(String codigoMesa) {
		for(Map.Entry<String, Mesa> mesa : Mesa.mesas.entrySet()) {
			Mesa mesaOb = mesa.getValue();
			if(mesaOb.getCodigoMesa().equals(codigoMesa)) {
				mesaOb.getUsuario().setMesa(null);
				mesaOb.setUsuario(null);
			}
		}
	}
	
	// Crea una mesa en caso de que no se encuentre una ya existente con el mismo codigo
	public static String validacionMesa(String codigoMesa, String numeroDeSillas) {
		if(!Mesa.mesas.containsKey(codigoMesa)) {
			Mesa.crearMesa(codigoMesa,numeroDeSillas);
			return "La mesa ha sido creada con éxito.";
		}
		else {
			return "Ya existe una mesa con ese código.";
		}
	}
	
	// Elimina una mesa con base al codigo.
	public static void eliminarMesa(String codigoMesa) {
		for(Map.Entry<String, Mesa> mesa : Mesa.mesas.entrySet()) {
			if(mesa.getKey().equals(codigoMesa)){
				Mesa.mesas.remove(codigoMesa);
				break;
			}
		}
	}
	
	// Retorna las mesas disponibles
	public ArrayList<Mesa> mostrarMesasDisponibles() {
		ArrayList<Mesa> disponibles = new ArrayList<Mesa>();
		for(Map.Entry<String, Mesa> m : Mesa.mesas.entrySet()) {
			Mesa mesa = m.getValue();
			if(mesa.getUsuario() == null) {
				disponibles.add(mesa);
			}
		}
		return disponibles;
	}
	
	
}