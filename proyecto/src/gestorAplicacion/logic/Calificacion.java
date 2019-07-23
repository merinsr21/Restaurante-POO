package gestorAplicacion.logic;
import java.util.ArrayList;

import BaseDatos.Datos;
import gestorAplicacion.users.*;

public class Calificacion {
	
	private String codigo;        //identificador = codigo comida a la que califica.
	private String puntaje;
	private Comida comida;
	private Factura factura;
	private Usuario usuario;	
	private static ArrayList<Calificacion> calificaciones = new ArrayList<Calificacion>();  //Necesaria ?? REVISAR
	
	public Calificacion() {
		
	}
	
	public Calificacion (String codigo, String puntaje){
		this.puntaje=puntaje;
		this.codigo = codigo;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	
	public static ArrayList<Calificacion> getCalificaciones(){
		return calificaciones;
	}
	
	public static void setCalificaciones(Calificacion calificacion) {
		calificaciones.add(calificacion);
	}
	
	public static void crearCalificacion(String codigo, String puntaje) {                // REVISAR
		Calificacion calificacion = new Calificacion(codigo, puntaje);
		Datos.calificaciones.put(codigo, calificacion);	
		Calificacion.setCalificaciones(calificacion);
	}
	
}
