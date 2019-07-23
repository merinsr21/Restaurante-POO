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
	private static ArrayList<Mesa> mesas = new ArrayList<Mesa>();
	
	public Mesa() {

	}
	public Mesa(String codigo, String numeroDeSillas, String ocupada) {      
		this.codigo = codigo;
		this.numeroDeSillas = numeroDeSillas;
		this.ocupada = ocupada;
		Datos.mesas.put(codigo, this);
	}
	
	public static void crearMesa(String codigo, String numeroDeSillas, String ocupada) {
		Mesa mesa = new Mesa(codigo,numeroDeSillas,ocupada);               
		mesas.add(mesa);  
		Datos.mesas.put(codigo, mesa);
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
		return mesas;
	}
	
	public HashMap<String, Mesa> getMesasD(){
		return Datos.mesas;
	}
	
	public String toString() {
		return "Mesa número "+getCodigo()+", con "+" "+getNumeroDeSillas()+" "+"sillas";
	}
	
	
	public static String ocuparMesa(String codigo, String numeroSillas, String nombreUsuario) {              //A una mesa solo se le puede asignar un usuario. REVISAR!
		String print = "La mesa que desea ocupar no existe";
		for(Mesa buscador : mesas) {
			if(buscador.codigo.equals(codigo)) {
				String bs = buscador.getNumeroDeSillas();
				int bs1 = Integer.parseInt(bs);
				int bs2 = Integer.parseInt(buscador.getNumeroDeSillas());
				int bs3 = Integer.parseInt(numeroSillas);
				if((bs2 >= bs3) && bs1 > 0) {
					if(buscador.ocupada.equals("true")) {
						print = "La mesa ya se encuentra ocupada.";
						break;
					}
					else {
						buscador.setOcupada("true");
						Usuario.getUsuarioConNombreUsuario(nombreUsuario).setMesa(buscador);
						buscador.usuarios.add(Usuario.getUsuarioConNombreUsuario(nombreUsuario));
						print = "La mesa"+" "+buscador.getCodigo()+" "+"ha sido ocupada.";
						break;
					}
				}
				return "La mesa seleccionada no cuenta con la cantidad de sillas deseada";
			}
		}
		return print;
	}
	
	public void liberarMesa(String codigo) {
		for(Mesa buscador: mesas) {
			if(buscador.codigo.equals(codigo)) {
				usuarios.get(0).setMesa(null);
				buscador.usuarios = null;
			}
		}
	}
}