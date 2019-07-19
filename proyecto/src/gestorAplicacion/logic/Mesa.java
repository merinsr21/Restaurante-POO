package gestorAplicacion.logic;
import java.util.*;
import gestorAplicacion.users.*;

public class Mesa {
	
	private int codigo;
	private int numeroDeSillas;
	private Boolean ocupada;
	public ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	private static ArrayList<Mesa> mesas = new ArrayList<Mesa>();
	
	
	public Mesa() {

	}
	
	public Mesa(int codigo, int numeroDeSillas, boolean ocupada) {
		this.codigo = codigo;
		this.numeroDeSillas = numeroDeSillas;
		this.ocupada = ocupada;
	}
	
	public static void crearMesa(int codigo, int numeroDeSillas, boolean ocupada) {
		Mesa mesa = new Mesa(codigo,numeroDeSillas,ocupada);
		mesas.add(mesa);
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public int getNumeroDeSillas() {
		return numeroDeSillas;
	}
	
	public Boolean getOcupada() {
		return ocupada;
	}
	
	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}
	
	public static ArrayList<Mesa> getMesas() {
		return mesas;
	}
	
	public String toString() {
		return "Mesa número "+getCodigo()+", con "+" "+getNumeroDeSillas()+" "+"sillas";
	}
	
	
	public static String ocuparMesa(int codigo, int numeroSillas, String nombreUsuario) {              //A una mesa solo se le puede asignar un usuario. REVISAR!
		String print = "La mesa que desea ocupar no existe";
		for(Mesa buscador : mesas) {
			if(buscador.codigo == codigo) {
				if(buscador.getNumeroDeSillas() >= numeroSillas && buscador.getNumeroDeSillas() > 0) {
					if(buscador.ocupada == true) {
						print = "La mesa ya se encuentra ocupada.";
						break;
					}
					else {
						buscador.setOcupada(true);
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
	
	public void liberarMesa(int codigo) {
		for(Mesa buscador: mesas) {
			if(buscador.codigo == codigo) {
				usuarios.get(0).setMesa(null);
				buscador.usuarios = null;
			}
		}
	}
}