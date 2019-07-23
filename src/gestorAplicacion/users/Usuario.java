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
	private String contrase�a;
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

	public Usuario(String nombre, String nombreUsuario, String correo, String contrase�a) {
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
		this.correo = correo;
		this.contrase�a = contrase�a;
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
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
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
	
	public HashMap<String, Usuario> getUsuarios(){
		return Datos.usuarios;
	}
	
	public static String nuevoUsuario(String nombre, String nombreUsuario, String correo, String contrase�a){
		Usuario usuario = new Usuario();
		//Validaciones de cada par�metro porque son private en la clase
		usuario.setNombre(nombre);
		usuario.setNombreUsuario(nombreUsuario);
		usuario.setCorreo(correo);
		usuario.setContrase�a(contrase�a);
		
		//Menu por defecto al crear un nuevo usuario
		String [] funcionalidades = {"1","2","3","4","5","6","12"};
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
			uusuario.setContrase�a(valor);
			return "Contrase�a modificada";
		default:
			return "Opci�n no v�lida";
		}
	}
	
	public static String eliminarUsuario(String nombreUsuario){
		Datos.usuarios.remove(nombreUsuario);
		return "El usuario se ha eliminado";
	}
	
	public static Usuario getUsuarioConNombreUsuario(String nombreUsuario){
        return Datos.usuarios.get(nombreUsuario);
    }

    public static String iniciarSesion(String nombreUsuario, String contrase�a){
        Usuario usuario = Usuario.getUsuarioConNombreUsuario(nombreUsuario);
        if (usuario != null){
            if(usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrase�a().equals(contrase�a)){
            	//Seteo el usuario
            	Main.usuario = usuario;
                return "\n"+
                		"Bienvenido "+usuario.getNombre();
            }
        }
        return "Usuario no encontrado";
    }
    
    public static String cerrarSesion(){
    	Main.usuario = getUsuarioConNombreUsuario("default");
        return "Adi�s";
    }
    
	
	public String editarMiUsuario(int opcion, String valor){
		switch (opcion) {
		case 1:	
			this.setNombre(valor);
			return "Nombre modificado";
		case 2:
			this.setContrase�a(valor);
			return "Contrase�a modificada";
		default:
			return "Opci�n no v�lida";
		}
	}

	
}

