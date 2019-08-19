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
	public Mesa(String codigoMesa) {      
		this.codigoMesa = codigoMesa;
	}
	
	// el codigo de la mesa lo ingresa el admin al momento de crearla.
	public static void crearMesa(String codigoMesa) {
		Mesa mesaOb = new Mesa(codigoMesa);               
		Mesa.mesas.put(codigoMesa, mesaOb);
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
	public static String ocuparMesa(String codigo) {             
		String print = "La mesa que desea ocupar no existe";
		for(Map.Entry<String, Mesa> mesa : Mesa.mesas.entrySet()) {
			Mesa buscador = mesa.getValue();
			if(buscador.getCodigoMesa().equals(codigo)) {
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
	public static void liberarMesa(String codigo) {
		for(Map.Entry<String, Mesa> mesa : Mesa.mesas.entrySet()) {
			Mesa mesaOb = mesa.getValue();
			if(mesaOb.getCodigoMesa().equals(codigo)) {
				mesaOb.getUsuario().setMesa(null);
				mesaOb.setUsuario(null);
			}
		}
	}
	
	// Verifica que no se encuentre una mesa con el mismo codigo.
	public static String ValidacionMesa(String codigo) {
		if(!Mesa.mesas.containsKey(codigo)) {
			Mesa.crearMesa(codigo);
			return "La mesa ha sido creada con éxito.";
		}
		else {
			return "Ya existe una mesa con ese código.";
		}
	}
}