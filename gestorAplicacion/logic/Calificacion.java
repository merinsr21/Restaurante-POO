package gestorAplicacion.logic;
import gestorAplicacion.users.*;

public class Calificacion {
	
	private int codigo;
	private int puntaje;
	private Comida comida;
	private Factura factura;
	private Usuario usuario;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	public Comida getComida() {
		return comida;
	}
	public void setComida(Comida comida) {
		this.comida = comida;
	}
	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
