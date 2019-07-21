package gestorAplicacion.users;

import java.util.*;
import java.util.HashMap;

import gestorAplicacion.logic.*;
import BaseDatos.Datos;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;
import uiMain.Main;

public class Usuario {
	
	private String nombre;
	private String nombreUsuario;
	private String contraseña;
	private String correo;
	private Mesa mesa;
	private Boolean estado;
	private MenuDeConsola menu;
	private ArrayList<Pedido> pedidosU = new ArrayList<Pedido>();
	private ArrayList<Factura> facturasU = new ArrayList<Factura>();
	private ArrayList<Calificacion> calificaciones = new ArrayList<Calificacion>();
	
	
	public Usuario() {
	}
	
	protected Usuario(String nombreUsuario, MenuDeConsola menu) {
		this.nombreUsuario = nombreUsuario;
		this.menu = menu;
		Datos.usuarios.put(nombreUsuario, this);
	}

	public Usuario(String nombre, String nombreUsuario, String correo, String contraseña) {
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
		this.correo = correo;
		this.contraseña = contraseña;
		Datos.usuarios.put(nombreUsuario, this);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Mesa getMesa() {
		return mesa;
	}
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public ArrayList<Pedido> getPedidosU() {
		return pedidosU;
	}
	public void setPedidosU(Pedido pedido) {
		pedidosU.add(pedido);
	}
	public ArrayList<Factura> getFacturasU() {
		return facturasU;
	}
	public void setFacturasU(Factura factura) {
		facturasU.add(factura);
	}
	public ArrayList<Calificacion> getCalificaciones() {
		return calificaciones;
	}
	public void setCalificaciones(Calificacion calificacion) {
		calificaciones.add(calificacion);
	}
	
	public MenuDeConsola getMenu() {
		return menu;
	}

	public void setMenu(MenuDeConsola menu) {
		this.menu = menu;
	}
	
	public static String nuevoUsuario(String nombre, String nombreUsuario, String correo, String contraseña){
		Usuario usuario = new Usuario();
		//Validaciones de cada parametro
		usuario.setNombre(nombre);
		usuario.setNombreUsuario(nombreUsuario);
		usuario.setCorreo(correo);
		usuario.setContraseña(contraseña);
		
		//Menu por defecto al crear un nuevo usuario
		String [] funcionalidades = {"8","9","10","11"};
		MenuDeConsola.nuevoMenu(usuario, funcionalidades);
		if(true){
			Datos.usuarios.put(nombreUsuario,usuario);
			return "Ha sido creado";
		}else{
			return "No ha sido creado";
		}
	}
	
	public static String editarUsuario(Usuario uusuario,int opcion, String valor){
		switch (opcion) {
		case 1:	
			uusuario.setNombre(valor);
			return "Nombre modificado";
		case 2:
			uusuario.setContraseña(valor);
			return "Contraseña modificada";
		default:
			return "Opción no válida";
		}
	}
	
	public static String eliminarUsuario(String nombreUsuario){
		Datos.usuarios.remove(nombreUsuario);
		return "Ha sido eliminado";
	}
	
	public static Usuario getUsuarioConNombreUsuario(String nombreUsuario){
        return Datos.usuarios.get(nombreUsuario);
    }
	
	public HashMap<String, Usuario> getUsers(){
		return Datos.usuarios;
	}
	
    public static String iniciarSesion(String nombreUsuario, String contraseña){
        Usuario usuario = Usuario.getUsuarioConNombreUsuario(nombreUsuario);
        if (usuario != null){
            if(usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContraseña().equals(contraseña)){
            	//Seteo el usuario
            	Main.usuario = usuario;
                return "Bienvenido "+usuario.getNombre();
            }
        }
        return "Usuario no encontrado";
    }
    
    public static String cerrarSesion(){
    	Main.usuario = getUsuarioConNombreUsuario("default");
        return "Adiós";
    }
    
	
	public String editarMiUsuario(int opcion, String valor){
		switch (opcion) {
		case 1:	
			this.setNombre(valor);
			return "Nombre modificado";
		case 2:
			this.setContraseña(valor);
			return "Contraseña modificada";
		default:
			return "Opción no válida";
		}
	}

	
}

