package modelo.gestorAplicacion.logic;
import java.util.*;
import uiMain.Main;
import modelo.BaseDatos.Datos;
import modelo.gestorAplicacion.users.*;

public class Mesa {
	
	private String codigoMesa;
	private String numeroDeSillas;
	private String ocupada; //ocupada = true, no ocupada = false
	private Usuario usuario;
	public static HashMap<String, Mesa> mesas = new HashMap<String, Mesa>();   //String= Código de la mesa

	public Mesa() {

	}
	public Mesa(String codigoMesa, String numeroDeSillas, String ocupada) {      
		this.codigoMesa = codigoMesa;
		this.numeroDeSillas = numeroDeSillas;
		this.ocupada = ocupada;
	}
	
	// el codigo de la mesa lo ingresa el admin al momento de crearla.
	public static void crearMesa(String codigoMesa, String numeroDeSillas, String ocupada) {
		Mesa mesam = new Mesa(codigoMesa,numeroDeSillas,ocupada);               
		Mesa.mesas.put(codigoMesa, mesam);
	}
	
	public String getCodigoMesa() {
		return codigoMesa;
	}
	
	public String getNumeroDeSillas() {
		return numeroDeSillas;
	}
	
	public String getOcupada() {
		return ocupada;
	}
	
	public void setOcupada(String ocupada) {
		this.ocupada = ocupada;
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
	public static String ocuparMesa(String codigo, String numeroSillas) {             
		String print = "La mesa que desea ocupar no existe";
		for(Map.Entry<String, Mesa> m : Mesa.mesas.entrySet()) {
			Mesa buscador = m.getValue();
			if(buscador.getCodigoMesa().equals(codigo)) {
				String numeroDeSillas = buscador.getNumeroDeSillas();
				int sillasMesa = Integer.parseInt(numeroDeSillas);
				//int bs2 = Integer.parseInt(buscador.getNumeroDeSillas());   NO ES NECESARIO(VERIFICAR)
				int sillasUsuario = Integer.parseInt(numeroSillas);
				if((sillasMesa >= sillasUsuario) && sillasUsuario > 0) {
					if(buscador.ocupada.equals("true")) {
						print = "La mesa ya se encuentra ocupada.";
						break;
					}
					else {
						buscador.setOcupada("true");
						Main.usuario.setMesa(buscador);
						buscador.setUsuario(Main.usuario);
						print = "La mesa"+" "+buscador.getCodigoMesa()+" "+"ha sido ocupada.";
						break;
					}
				}
				return "La mesa seleccionada no cuenta con la cantidad de sillas deseada";
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
				mesa.setOcupada("false");
			}
		}
	}
	
	// Verifica que los datos ingresados por el admin sean validos para crear una mesa.
	public static String ValidacionMesa(String codigo, String numeroDeSillas) {
		if(Integer.parseInt(codigo) >= 0 && Integer.parseInt(codigo) <= 99) {
			if(!Mesa.mesas.containsKey(codigo)) {
				Mesa.crearMesa(codigo, numeroDeSillas, "false");
				return "La mesa ha sido creada con exito";
			}
			else {
				return "Ya existe una mesa con ese codigo";
			}
		}
		else {
			return "El código ingresado no se encuentra en el intervalo pedido(0-99)";
		}
	}
}