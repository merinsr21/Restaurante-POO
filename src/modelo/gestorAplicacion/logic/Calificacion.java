package modelo.gestorAplicacion.logic;
import java.util.ArrayList;

import modelo.BaseDatos.Datos;
import modelo.gestorAplicacion.users.*;
import uiMain.Main;

public class Calificacion {
	
	private static int consecutivoCalificacion = 0;
	private String codigoCalificacion;        
	private int puntaje;
	private Comida comida;
	// ASIGANARLE UN PEDIDO
	private Usuario usuario;
	private String comentario;
	public static ArrayList<Calificacion> calificaciones = new ArrayList<Calificacion>(); 
	
	public Calificacion() {
		
	}
	
	public Calificacion (String codigoCalificacion, int puntaje, Usuario usuario){
		this.codigoCalificacion = codigoCalificacion;
		this.puntaje=puntaje;
		this.usuario = usuario;
	}
	public Calificacion (String codigoCalificacion, Comida comida, int puntaje, Usuario usuario){
		this.codigoCalificacion = codigoCalificacion;
		this.comida = comida;
		this.puntaje=puntaje;
		this.usuario = usuario;
	}
	public Calificacion (String codigoCalificacion, int puntaje){
		this.codigoCalificacion = codigoCalificacion;
		this.puntaje=puntaje;
	}
	public Calificacion (String codigoCalificacion, Comida comida, int puntaje, String comentario){
		this.codigoCalificacion = codigoCalificacion;
		this.comida = comida;
		this.puntaje=puntaje;
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

	public String getCodigoCa() {
		return codigoCalificacion;
	}
	
	public void setCodigoCa(String codigo) {
		this.codigoCalificacion = codigo;
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
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public static ArrayList<Calificacion> getCalificaciones(){
		return calificaciones;
	}
	
	public static void setCalificaciones(Calificacion calificacion) {
		calificaciones.add(calificacion);
	}
	
	public static Calificacion crearCalificacion(String codigoCalificacion, int puntaje) {                
		Calificacion calificacion = new Calificacion(codigoCalificacion, puntaje, Main.usuario); 
		Calificacion.calificaciones.add(calificacion);	        
		Calificacion.setCalificaciones(calificacion);
		return calificacion;
	}
	
}
