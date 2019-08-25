package modelo.gestorAplicacion.logic;
import java.util.ArrayList;
import java.util.Map;
import java.util.*;
import modelo.BaseDatos.Datos;
import modelo.gestorAplicacion.users.*;
import uiMain.Main;

public class Calificacion {
	
	private static int consecutivoCalificacion = 0;
	private String codigoCalificacion;        
	private String puntaje;
	private Comida comida;
	// ASIGANARLE UN PEDIDO
	private Usuario usuario;
	private String comentario;
	public static HashMap<String, Calificacion> calificaciones = new HashMap <String, Calificacion>();
	
	public Calificacion() {
		
	}
	
	public Calificacion(String codigoCalificacion, String puntaje, Comida comida, Usuario usuario, String comentario) {
		this.codigoCalificacion = codigoCalificacion;
		this.puntaje = puntaje;
		this.comida = comida;
		this.usuario = usuario;
		this.comentario = comentario;
	}
	
	public static String generarCodigoCalificacion() {
		String  codigoCalificacion = Integer.toString(consecutivoCalificacion);
		consecutivoCalificacion++;
		return codigoCalificacion;	
	}
	
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getCodigoCalificacion() {
		return codigoCalificacion;
	}
	
	public void setCodigoCalificacion(String codigo) {
		this.codigoCalificacion = codigo;
	}
	
	public String getPuntaje() {
		return puntaje;
	}
	
	public void setPuntaje(String puntaje) {
		this.puntaje = puntaje;
	}
	
	public Comida getComida() {
		return comida;
	}
	
	public void setComida(Comida comida) {
		this.comida = comida;
	}
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public static Calificacion crearCalificacion(String puntaje, String codigoComida, String comentario) {                
		String codigoCalificacion = Calificacion.generarCodigoCalificacion();
		Usuario usuario = Main.usuario;
		Comida comida = Comida.getComidaConCodigo(codigoComida);
		
		Calificacion calificacion = new Calificacion(codigoCalificacion, puntaje, comida, usuario, comentario);
		Calificacion.calificaciones.put(codigoCalificacion, calificacion);
		
		return calificacion;
	}
	
	public static int asignacionConsecutivoCalificacion() {
		int mayor = 0;
		for(Map.Entry<String, Pedido> p : Pedido.pedidos.entrySet()) {
			String c = p.getKey();
			int codigo =Integer.parseInt(c);
			if(codigo > mayor) {
				mayor = codigo;
			}
		}
		return mayor;
	}
	
	public static void setConsecutivoCalificacion(int consecutivoCalificacion) {
		Calificacion.consecutivoCalificacion = consecutivoCalificacion;
	}
	
	public static int getConsecutivoCalificacion() {
		return consecutivoCalificacion;
	}
}
