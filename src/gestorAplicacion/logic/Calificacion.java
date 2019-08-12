package gestorAplicacion.logic;
import java.util.ArrayList;

import BaseDatos.Datos;
import gestorAplicacion.users.*;
import uiMain.Main;

public class Calificacion {
	
	private static int consecutivoCalificacion = 900;
	private String codigoCalificacion;        
	private String puntaje;
	private Comida comida;
	private Usuario usuario;
	private String comentario;
	private static ArrayList<Calificacion> calificaciones = new ArrayList<Calificacion>();  
	
	public Calificacion() {
		
	}
	
	public Calificacion (String codigoCalificacion, String puntaje, Usuario usuario){
		this.codigoCalificacion = codigoCalificacion;
		this.puntaje=puntaje;
		this.usuario = usuario;
	}
	public Calificacion (String codigoCalificacion, Comida comida, String puntaje, Usuario usuario){
		this.codigoCalificacion = codigoCalificacion;
		this.comida = comida;
		this.puntaje=puntaje;
		this.usuario = usuario;
	}
	public Calificacion (String codigoCalificacion, String puntaje){
		this.codigoCalificacion = codigoCalificacion;
		this.puntaje=puntaje;
	}
	public Calificacion (String codigoCalificacion, Comida comida, String puntaje, String comentario){
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
	
	public static ArrayList<Calificacion> getCalificaciones(){
		return calificaciones;
	}
	
	public static void setCalificaciones(Calificacion calificacion) {
		calificaciones.add(calificacion);
	}
	
	public static Calificacion crearCalificacion(String codigoCalificacion, String puntaje) {                
		Calificacion calificacion = new Calificacion(codigoCalificacion, puntaje, Main.usuario); 
		Datos.calificaciones.add(calificacion);	        
		Calificacion.setCalificaciones(calificacion);
		return calificacion;
	}
	
}
