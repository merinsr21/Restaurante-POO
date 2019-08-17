package modelo.gestorAplicacion.users;

import java.util.*;
import java.util.HashMap;

import modelo.BaseDatos.Datos;
import modelo.gestorAplicacion.logic.*;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;
import uiMain.Main;

public class Usuario {
	
	public static Usuario usuario;
	private Carrito miCarrito;
	private String nombre;
	private String nombreUsuario;
	private String contrase�a;
	private String correo;
	private Mesa mesa;
	private MenuDeConsola menu;
	private ArrayList<Pedido> pedidosUsuario = new ArrayList<Pedido>();
	private ArrayList<Calificacion> calificacionesUsuario = new ArrayList<Calificacion>();
	public static HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();  //String = nombreUsuario

	
	
	public Usuario() {
	}
	
	protected Usuario(String nombreUsuario, MenuDeConsola menu) {
		this.nombreUsuario = nombreUsuario;
		this.menu = menu;
		Usuario.usuarios.put(nombreUsuario, this);
	}

	public Usuario(String nombre, String nombreUsuario, String correo, String contrase�a, Carrito miCarrito) {
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
		this.correo = correo;
		this.contrase�a = contrase�a;
		this.miCarrito = miCarrito;
		Usuario.usuarios.put(nombreUsuario, this);
	}
	public Usuario(String nombre, String nombreUsuario, String correo, String contrase�a) {
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
		this.correo = correo;
		this.contrase�a = contrase�a;
		Usuario.usuarios.put(nombreUsuario, this);
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
	public ArrayList<Pedido> getPedidosUsuario() {
		return pedidosUsuario;
	}
	public void setPedidosUsuario(Pedido pedido) {
		pedidosUsuario.add(pedido);
	}
	public ArrayList<Calificacion> getCalificacionesUsuario() {
		return calificacionesUsuario;
	}
	public void setCalificacionesUsuario(Calificacion calificacion) {
		calificacionesUsuario.add(calificacion);
	}
	
	public MenuDeConsola getMenu() {
		return menu;
	}

	public void setMenu(MenuDeConsola menu) {
		this.menu = menu;
	}
	
	public HashMap<String, Usuario> getUsuarios(){
		return Usuario.usuarios;
	}
	
	public Carrito getMiCarrito(){
		return miCarrito;
	}
	
	public static String nuevoUsuario(String nombre, String nombreUsuario, String correo, String contrase�a){
		Usuario usuario = new Usuario();
		//Validaciones de cada par�metro porque son private en la clase
		usuario.setNombre(nombre);
		usuario.setNombreUsuario(nombreUsuario);
		usuario.setCorreo(correo);
		usuario.setContrase�a(contrase�a);
		
		//Menu por defecto al crear un nuevo usuario
		String [] funcionalidades = {"1","2","3","4","5","6","15","12"};
		MenuDeConsola.nuevoMenu(usuario, funcionalidades);
		Usuario.usuarios.put(nombreUsuario,usuario);
		return "Ha sido creado";
	}
	
	public static String editarUsuario(Usuario uusuario,int opcion, String valor){ //editar un usuario en espec�fico
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
		Usuario.usuarios.remove(nombreUsuario);
		return "El usuario se ha eliminado";
	}
	
	public static Usuario getUsuarioConNombreUsuario(String nombreUsuario){
        return Usuario.usuarios.get(nombreUsuario);
    }

    public static String iniciarSesion(String nombreUsuario, String contrase�a){
        Usuario usuario = Usuario.getUsuarioConNombreUsuario(nombreUsuario);
        if (usuario != null){
            if(usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrase�a().equals(contrase�a)){
            	Main.usuario = usuario;
                return "Bienvenido "+usuario.getNombre();
            }
        }
        return "Usuario no encontrado";
    }
    
    public static String cerrarSesion(){
    	Main.usuario = getUsuarioConNombreUsuario("default");
        return "Adi�s";
    }
    

	
}

