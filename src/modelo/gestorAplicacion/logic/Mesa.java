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
	public Mesa(String codigoMesa, String numeroDeSillas) {      
		this.codigoMesa = codigoMesa;
		this.numeroDeSillas = numeroDeSillas;
	}
	
	// el codigo de la mesa lo ingresa el admin al momento de crearla.
	public static void crearMesa(String codigoMesa, String numeroDeSillas) {
		Mesa mesam = new Mesa(codigoMesa,numeroDeSillas);               
		Mesa.mesas.put(codigoMesa, mesam);
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
		return "Mesa número "+getCodigoMesa()+", con "+" "+getNumeroDeSillas()+" "+"sillas";
	}
	
	// Le asigna a un usuario una mesa, en caso de que esta este disponible.
	public static String ocuparMesa(String codigo) {             
		String print = "La mesa que desea ocupar no existe";
		for(Map.Entry<String, Mesa> m : Mesa.mesas.entrySet()) {
			Mesa buscador = m.getValue();
			if(buscador.getCodigoMesa().equals(codigo)) {
				if(buscador.getUsuario() != null) {
					print = "La mesa ya se encuentra ocupada.";
					break;
				}
				else {
					Main.usuario.setMesa(buscador);
					buscador.setUsuario(Main.usuario);
					print = "La mesa"+" "+buscador.getCodigoMesa()+" "+"ha sido ocupada.";
					break;
				}
			}
		}
		return print;
	}
	
	// Al cerrar sesion se desocupa la mesa correspondiente a ese usuario y esta queda disponible para ser ocupada por otro usuario.
	// Es necesario hacer el mismo proceso en mesasM ??
	public static void liberarMesa(String codigo) {
		for(Map.Entry<String, Mesa> m : Mesa.mesas.entrySet()) {
			Mesa mesa = m.getValue();
			if(mesa.getCodigoMesa().equals(codigo)) {
				mesa.getUsuario().setMesa(null);
				mesa.setUsuario(null);
			}
		}
	}
	
	// Verifica que no se encuentre una mesa con el mismo codigo.
	public static String ValidacionMesa(String codigo, String numeroDeSillas) {
		if(!Mesa.mesas.containsKey(codigo)) {
			Mesa.crearMesa(codigo, numeroDeSillas);
			return "La mesa ha sido creada con exito";
		}
		else {
			return "Ya existe una mesa con ese codigo";
		}
	}
}