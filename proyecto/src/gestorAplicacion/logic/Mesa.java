package gestorAplicacion.logic;
import java.util.*;

import BaseDatos.Datos;
import gestorAplicacion.users.*;

public class Mesa {
	
	private String codigo;
	private String numeroDeSillas;
	private String ocupada; //ocupada = true, no ocupada = false
	public ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private static ArrayList<Mesa> mesasM = new ArrayList<Mesa>();
	
	public Mesa() {

	}
	public Mesa(String codigo, String numeroDeSillas, String ocupada) {      
		this.codigo = codigo;
		this.numeroDeSillas = numeroDeSillas;
		this.ocupada = ocupada;
	}
	
	public static void crearMesa(String codigo, String numeroDeSillas, String ocupada) {
		Mesa mesam = new Mesa(codigo,numeroDeSillas,ocupada);               
		mesasM.add(mesam);  
		Datos.mesas.put(codigo, mesam);
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
	public  static ArrayList<Mesa> getMesasM(){
		return mesasM;
	}
	public static void setMesasM(Mesa mesa){
		mesasM.add(mesa);
	}
	
	public HashMap<String, Mesa> getMesasD(){
		return Datos.mesas;
	}
	
	public String toString() {
		return "Mesa número "+getCodigo()+", con "+" "+getNumeroDeSillas()+" "+"sillas";
	}
	
	
	public static String ocuparMesa(String codigo, String numeroSillas, String nombreUsuario) {              //A una mesa solo se le puede asignar un usuario. REVISAR!
		String print = "La mesa que desea ocupar no existe";
		for(Mesa buscador : mesasM) {
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
		for(Mesa buscador: mesasM) {
			if(buscador.codigo.equals(codigo)) {
				usuarios.get(0).setMesa(null);
				mesaOb.usuarios = null;
			}
		}
	}
}