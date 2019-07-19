package gestorAplicacion.logic;
import java.util.*;
import gestorAplicacion.users.*;

public class Mesa {
	
	private int codigo;
	private int numeroDeSillas;
	private Boolean ocupada;
	private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	private static ArrayList<Mesa> mesas = new ArrayList<Mesa>();
	
	
	public Mesa() {
		
	}
	
	public Mesa(int codigo, int numeroDeSillas) {
		this.codigo = codigo;
		this.numeroDeSillas = numeroDeSillas;
	}
	
	public void crearMesa() {
		Mesa mesa = new Mesa();
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
	
	public static ArrayList<Mesa> getMesas() {
		return mesas;
	}
	
	public String toString() {
		return "Mesa numero: "+getCodigo()+"con "+" "+getNumeroDeSillas()+" "+"sillas";
	}
	
	// funcionalidad para ver mesas disponibles.
	//funcionalidad para ocupar mesa.
	
	public static String ocuparMesa(int codigo, Usuario usuario) {              //A una mesa solo se le puede asignar un usuario. REVISAR!
		String print = "la mesa que desea ocupar no existe";
		for(Mesa buscador : mesas) {
			if(buscador.codigo == codigo) {
				if(buscador.ocupada == true) {
					print = "La mesa ya se encuentra ocupada.";
				}
				else {
					usuario.setMesa(buscador);
					usuarios.add(usuario);
					print = "La mesa"+" "+buscador.getCodigo()+" "+"ha sido ocupada.";
				}
			}
		}
		return print;
	}
}