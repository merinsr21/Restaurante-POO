package gestorAplicacion.logic;
import java.util.*;
import gestorAplicacion.users.*;

public class Mesa {
	
	private int codigo;
	private int numeroDeSillas;
	private Boolean ocupada;
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
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
	
	public String ocuparMesa(int codigo, Usuario usuario) {              //Solo funciona para un usuario.
		for(Mesa buscador : mesas) {
			if(buscador.codigo == codigo) {
				if(buscador.ocupada == true) {
					return "La mesa ya se encuentra ocupada.";
				}
				else {
					usuario.getMesa() = buscador;
					usuarios.add(usuario);
					return "La mesa ha sido ocupada.";
				}
			}
		}
		return "La mesa que desea ocupar no existe.";
	}
}
