package BaseDatos;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;


import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import gestorAplicacion.users.*;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;
import gestorAplicacion.logic.*;

public class Datos {
	public static HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();  //String = nombreUsuario
	public static HashMap<String, MenuDeConsola> menus = new HashMap<String, MenuDeConsola>();  //String = nombreUsuario
	public static HashMap<String, OpcionDeMenu> funcionalidades = new HashMap<String, OpcionDeMenu>();
	public static HashMap<String, Mesa> mesas = new HashMap<String, Mesa>();   //String= Código de la mesa
	public static HashMap<String, Comida> menuComidas = new HashMap<String, Comida>(); //String= Código de la comida
	public static HashMap<String, Pedido> pedidos = new HashMap<String, Pedido>();//
	public static HashMap<String, Calificacion> calificaciones = new HashMap<String, Calificacion>(); //String= Codigo de la comida(calificación)
	public static HashMap<String, Factura> facturas = new HashMap<String, Factura>();
	//public static HashMap<String, DetallePedido> detallesPedido = new HashMap<String, DetallePedido>();

	
	public static void cargarDatos() {
		crearArchivosYDirs();
		String ruta = System.getProperty("user.dir")+"\\src\\temp\\";
		cargarUsuarios(ruta);
		cargarAdmins(ruta);
		cargarMesas(ruta);
		cargarMenuComidas(ruta);
		//cargarDetallesPedido(ruta);
		cargarPedidos(ruta);
		//cargarFacturas(ruta)
		cargarMenus(ruta);
	}
	
	private static void cargarUsuarios(String ruta) {
		try{
            FileReader fr = new FileReader(ruta+"usuarios.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null){
            	if (!line.isEmpty()) {
            		String [] usuario = line.split(";");
            		String nombreUsuario = usuario[0];
            		String nombre = usuario[1];
            		String correo = usuario[2];
            		String contraseña = usuario[3];
            		String pedidosP = Pedido.getNombreArreglo(usuario[4]);
            		Usuario usuario1 = new Usuario(nombre, nombreUsuario, correo, contraseña);
            		for(Pedido r : Pedido.getPedidosP(pedidosP)){
            			usuario1.setPedidosU(r);
            		}
            	}
            }
            br.close();
        }catch(Exception e){
            //Error al leer
        }
	}
	
	private static void cargarAdmins(String ruta) {
		try{
            FileReader fr = new FileReader(ruta+"administradores.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null){
            	if (!line.isEmpty()) {
            		String [] usuario = line.split(";");
            		String nombreUsuario = usuario[0];
            		String nombre = usuario[1];
            		String correo = usuario[2];
            		String contraseña = usuario[3];
            		new Administrador(nombre, nombreUsuario, correo, contraseña);
            	}
            }
            br.close();
        }catch(Exception e){
        	//Error al leer
        }
	}
	private static void cargarMenuComidas(String ruta) {
		try {
			FileReader fr = new FileReader(ruta + "menuDeComidas.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null) {
				if(!line.isEmpty()) {
					String [] comidas = line.split(";");
					String codigo = comidas[0];
					String nombre = comidas[1];
					String precio = comidas[2];
					String calorias = comidas[3];
					//new Comida(codigo, nombre, precio, calorias);
					Comida comida = new Comida(codigo,nombre,precio,calorias);
					menuComidas.put(codigo, comida);
					Comida.setMenuC(comida);
				}
			}
			br.close();
		}catch(Exception e) {
			
		}
	}
	
	private static void cargarMesas(String ruta) {
		try {
			FileReader fr = new FileReader(ruta + "mesas.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null) {
				if(!line.isEmpty()) {
					String [] mesa = line.split(";");
					String codigo = mesa[0];		
					String numeroDeSillas = mesa[1];							
					String ocupada = mesa[2];
					Mesa mesam = new Mesa(codigo, numeroDeSillas, ocupada);
					mesas.put(codigo, mesam);
					Mesa.setMesasM(mesam);
				}
			}
			br.close();
		}catch(Exception e) {
			
		}
	}
	/*private static void cargarDetallesPedido(String ruta){
	    try{
	        FileReader fr = new FileReader(ruta + "detallesPedido.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null) {
				if(!line.isEmpty()) {
				    String [] detalles = line.split(";");
				    */
	
	
	private static void cargarPedidos(String ruta) {
		try {
			FileReader fr = new FileReader(ruta + "pedidos.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null) {
				if(!line.isEmpty()) {
					String [] pedido = line.split(";");
					String codigo = pedido[0];
					String precioTotal = pedido[3];
					Factura factura = Factura.getFacturaConCodigo(pedido[1]);
            		Usuario usuario = Usuario.getUsuarioConNombreUsuario(pedido[2]);
            		Pedido pedidop = new Pedido(codigo, factura, precioTotal, usuario);
				}
			}
			br.close();
		}catch(Exception e) {
			
		}
	}
	private static void cargarMenus(String ruta) {
		try{
            FileReader fr = new FileReader(ruta+"menusUsuarios.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null){
            	if (!line.isEmpty()) {
            		String [] menu = line.split(";");
            		Usuario usuario = Usuario.getUsuarioConNombreUsuario(menu[0]);
            		//slice de arrays
            		String[] funcionalidades = Arrays.copyOfRange(menu, 1, menu.length);
            		MenuDeConsola.nuevoMenu(usuario, funcionalidades);
            	}
            }
            br.close();
        }catch(Exception e){
        	//Error de lectura
        }
	}
	
	public static void guardarDatos() {
		crearArchivosYDirs();
		String ruta = System.getProperty("user.dir")+"\\src\\temp\\";
		guardarUsuarios(ruta);
		guardarMesas(ruta);
		guardarMenuDeComidas(ruta);
		//guardarDetallesPedido(ruta);
		//guardarPedidos(ruta);
		guardarMenus(ruta);
	}
	
	private static void guardarUsuarios(String ruta){
		try {
            FileWriter fwU = new FileWriter(ruta+"usuarios.txt");
            FileWriter fwAdmin = new FileWriter(ruta+"administradores.txt");
            PrintWriter pw = new PrintWriter(fwU);
            PrintWriter pwAdmin = new PrintWriter(fwAdmin);
    		for (Map.Entry<String, Usuario> usuario : usuarios.entrySet()) {
    			Usuario usuarioO = usuario.getValue();
    			String line = usuarioO.getNombreUsuario()+";";
    			line += usuarioO.getNombre()+";";
    			line += usuarioO.getCorreo()+";";
    			line += usuarioO.getContraseña();
    			if(usuarioO instanceof Administrador) {
    				pwAdmin.println(line);
					
				}else {
					pw.println(line);
    			}
    		}
            pw.close();
            pwAdmin.close();
            
        } catch (IOException IOe) {
        	//Ocurrio algo al guardar los datos en  el txt
        }
	}
	private static void guardarMesas(String ruta) {
		try {
			FileWriter fw = new FileWriter(ruta + "mesas.txt");
			PrintWriter pw = new PrintWriter(fw);
			for(Map.Entry<String, Mesa> mesa : mesas.entrySet()) {
				Mesa mesaOb = mesa.getValue();
				String line = mesaOb.getCodigo() + ";";
				line += mesaOb.getNumeroDeSillas() + ";";
				line += mesaOb.getOcupada();
				pw.println(line);
			}
			pw.close();
		}catch(IOException IOe) {
			
		}
	}
	private static void guardarMenuDeComidas(String ruta) {
		try {
			FileWriter fw = new FileWriter(ruta + "menuDeComidas.txt");
			PrintWriter pw = new PrintWriter(fw);
			for(Map.Entry<String, Comida> comida : menuComidas.entrySet()) {
				Comida comidaOb = comida.getValue();
				String line = comidaOb.getCodigo() + ";";
				line += comidaOb.getNombre() + ";";
				line+= comidaOb.getPrecio() + ";";
				line += comidaOb.getCalorias();
				pw.println(line);
			}
			pw.close();
		}catch(IOException IOe) {
			
		}
	}
	
	
	private static void guardarMenus(String ruta){
		try {
            FileWriter fw = new FileWriter(ruta+"menusUsuarios.txt");
            PrintWriter pw = new PrintWriter(fw);
    		for (Map.Entry<String, MenuDeConsola> menu : menus.entrySet()) {
    			MenuDeConsola menuObj = menu.getValue();
    			String line = menuObj.getUsuario().getNombreUsuario()+";";
    			for (String  op : menuObj.getFuncionalidades()) {
    				line += op+";";
				}
    			//Para borrar el ; que se pone al final
    			pw.println(line.substring(0,(line.length()-1)));
    		}
            pw.close();
            
        } catch (IOException IOe) {
        	//Ocurrio algo al guardar en txt los datos
        }
	}
	
	private static void crearArchivosYDirs() {
		try {
		String ruta = System.getProperty("usuario.dir")+"\\src\\temp\\";
		File directorio = new File(ruta);
	    if (! directorio.exists()){
	        directorio.mkdir();
	    }
		File archivoUsuariosRegistrados = new File(ruta+"usuarios.txt");
		File archivoAdmin = new File(ruta+"administradores.txt");
		File menusUsuarios = new File(ruta+"menusUsuarios.txt");
		archivoUsuariosRegistrados.createNewFile();
		archivoAdmin.createNewFile();
		}
		catch(IOException IOe){
			//Ocurrio algo al crear las carpetas y los archivos
		}
	}
}
