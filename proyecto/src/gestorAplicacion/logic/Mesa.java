package gestorAplicacion.logic;
import java.util.*;

import BaseDatos.Datos;
import gestorAplicacion.users.*;

public class Mesa {
	
	private String codigo;
	private String numeroDeSillas;
	private String ocupada; //ocupada = true, no ocupada = false
	public ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	private static ArrayList<Mesa> mesasM = new ArrayList<Mesa>();

	
	public Mesa() {

	}
	public Mesa(String codigo, String numeroDeSillas, String ocupada) {      
		this.codigo = codigo;
		this.numeroDeSillas = numeroDeSillas;
		this.ocupada = ocupada;
		Datos.mesas.put(codigo, this);
	}
	
	public  void crearMesa(String codigo, String numeroDeSillas, String ocupada) {
		Mesa mesa = new Mesa(codigo,numeroDeSillas,ocupada);               // este metodo debe ser estatico..
		mesas.add(mesa);  
		Datos.mesas.put(codigo, this);
	}
	
	public String getCodigo() {
		return codigo;
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
	public ArrayList<Mesa> getMesasM(){
		return mesasM;
	}
	
	public HashMap<String, Mesa> getMesasD(){
		return Datos.mesas;
	}
	
	public HashMap<String, Mesa> getMesasD(){
		return Datos.mesas;
	}
	
	public String toString() {
		return "Mesa número "+getCodigo()+", con "+" "+getNumeroDeSillas()+" "+"sillas";
	}
	
	
	public static String ocuparMesa(String codigo, String numeroSillas, String nombreUsuario) {              //A una mesa solo se le puede asignar un usuario. REVISAR!
		String print = "La mesa que desea ocupar no existe";
		for(Map.Entry<String, Mesa> mesa : Datos.mesas.entrySet()) {
			Mesa mesaOb = mesa.getValue();
			if(mesaOb.getCodigo().equals(codigo)) {
				int bs1 = Integer.parseInt(mesaOb.getNumeroDeSillas());
				int bs2 = Integer.parseInt(numeroSillas);
				if((bs1 >= bs2) && bs1 > 0) {
					if(mesaOb.getOcupada().equals("true")) {
						print = "La mesa ya se encuentra ocupada.";
						break;
					}
					else {
						mesaOb.setOcupada("true");
						Usuario.getUsuarioConNombreUsuario(nombreUsuario).setMesa(mesaOb);
						mesaOb.usuarios.add(Usuario.getUsuarioConNombreUsuario(nombreUsuario));
						print = "La mesa"+" "+mesaOb.getCodigo()+" "+"ha sido ocupada.";
						break;
					}
				}
				return "La mesa seleccionada no cuenta con la cantidad de sillas deseada";
			}
		}
		return print;
	}
	
	public void liberarMesa(String codigo) {
		for(Map.Entry<String, Mesa> mesa : Datos.mesas.entrySet()) {
			Mesa mesaOb = mesa.getValue();
			if(mesaOb.codigo.equals(codigo)) {
				usuarios.get(0).setMesa(null);
				mesaOb.usuarios = null;
			}
		}
	}
}