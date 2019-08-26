package modelo.BaseDatos;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;

import modelo.gestorAplicacion.logic.*;
import modelo.gestorAplicacion.users.*;
import uiMain.Main;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public class Datos {
	//¿esto se debería poner en cada clase?

	
	public  void cargarDatos() {
		crearArchivosYDirs();
		String ruta = System.getProperty("user.dir")+"\\src\\temp\\";
		cargarMesas(ruta);
		cargarMenuComidas(ruta);
		cargarDetallesPedido(ruta);
		cargarFacturas(ruta);
		cargarPedidos(ruta);
		cargarCalificaciones(ruta);
		cargarUsuarios(ruta);
		cargarAdmins(ruta);
		cargarMenus(ruta);
	}
	
	private static void cargarUsuarios(String ruta) {
		try{
            FileReader fr = new FileReader(ruta+"usuarios.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while(((line = br.readLine()) != null)/* && ((line3 = br.readLine()) != null) && ((line2 = br.readLine()) != null)*/){
            	if (!line.isEmpty()) {
            		String [] usuarioDatos = line.split(";");
            		String nombreUsuario = usuarioDatos[0];
            		String nombre = usuarioDatos[1];
            		String correo = usuarioDatos[2];
            		String contraseña = usuarioDatos[3];
            		Usuario usuario = new Usuario(nombre, nombreUsuario, correo, contraseña);
            		Usuario.usuarios.put(nombreUsuario,usuario);
            		Carrito carrito = new Carrito();
            		usuario.setMiCarrito(carrito);
            		carrito.setUsuario(usuario);
            	}
            }
            br.close();
        }catch(Exception e){
        	//System.out.println(e);   este no es
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
            		Usuario administrador = new Usuario(nombre, nombreUsuario, correo, contraseña);
            		Usuario.usuarios.put(nombreUsuario, administrador);
            	}
            }
            br.close();
        }catch(Exception e){
        	//System.out.println(e);  no es
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
					String codigoComida = comidas[0];
					String nombreComida = comidas[1];
					String precioComida = comidas[2];
					String calorias = comidas[3];
					String disponible = comidas[4];
					Comida comida = new Comida(codigoComida,nombreComida,precioComida,calorias);
					Comida.menuComidas.put(codigoComida, comida);
				}
			}
			br.close();
		}catch(Exception e) {
			//System.out.println(e); not
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
					String nombreUsuario = mesa[2];
					Usuario usuario = Usuario.getUsuarioConNombreUsuario(nombreUsuario);
					Mesa mesaOb = new Mesa(codigo, numeroDeSillas, usuario);
					Mesa.mesas.put(codigo, mesaOb);
				}
			}
			br.close();
		}catch(Exception e) {
			
		}
	}

	private static void cargarDetallesPedido(String ruta){ 
	    try{
	        FileReader fr = new FileReader(ruta + "detallesPedidos.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null) {
				if(!line.isEmpty()) {
				    String [] detalles = line.split(";");
				    String codigoDetalle = detalles[0];      //codigoPedido-codigoDetalle
				    String cantidad = detalles[1];
				    String codigoComida = detalles[2]; 
				    
				    Comida comida = Comida.getComidaConCodigo(codigoComida);
				    String codigoPedido = String.valueOf(codigoDetalle.charAt(0));
				    Pedido pedido = Pedido.getPedidoConCodigo(codigoPedido);
				    
				    DetallePedido detalle = new DetallePedido(codigoDetalle, cantidad, comida, pedido);
				    
				    comida.setDetallePedidoComida(detalle);
				    pedido.setDetallesPedidoDeCadaPedido(detalle);
				}
			}
			br.close();
	    }catch(Exception e) {
	    	//System.out.println(e); not
	    }
	}
		
	private static void cargarPedidos(String ruta) {  
		try {
			FileReader fr = new FileReader(ruta + "pedidos.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null) {
				if(!line.isEmpty()) {
					String [] pedido = line.split(";");
					String codigoPedido = pedido[0];
					String nombreUsuario = pedido[1];
					
					Usuario usuario = Usuario.getUsuarioConNombreUsuario(nombreUsuario);
					Pedido pedidoOb = new Pedido(codigoPedido,usuario);
					Pedido.pedidos.put(codigoPedido, pedidoOb);
					usuario.setPedidosUsuario(pedidoOb);
					
					Pedido.setConsecutivoPedido(Pedido.asignacionConsecutivoPedido());
				}
			}
			br.close();
		}catch(Exception e) {
			//System.out.println(e);
		}
	}
	
	private static void cargarFacturas(String ruta){  
	    try{
	        FileReader fr = new FileReader(ruta + "facturas.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null) {
				if(!line.isEmpty()) {
				    String [] facturas = line.split(";");
				    String codigoFactura = facturas[0];
				    String fecha = facturas[1];
				    String codigoPedido = facturas[2];
				    
				    Pedido pedido = Pedido.getPedidoConCodigo(codigoPedido);
				    
				    Factura factura = new Factura(codigoFactura, fecha, pedido);
				    
				    pedido.setFactura(factura);
				    
				    Factura.setConsecutivoFactura(Factura.asignacionConsecutivoFactura());
				}
			}
			br.close();
	    }catch(Exception e) {
	    	//System.out.println(e);  no es
	    }
	}
	
	private static void cargarCalificaciones(String ruta){     
	    try{
	        FileReader fr = new FileReader(ruta + "calificaciones.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null) {
				if(!line.isEmpty()) {
				    String [] calificacion = line.split(";");
				    String codigoCalificacion = calificacion[0];
				    String puntaje = calificacion[1];
				    String codigoComida = calificacion[2];
				    String nombreUsuario = calificacion[3];
				    String comentario = calificacion[4];
				    
				    Usuario usuario = Usuario.getUsuarioConNombreUsuario(nombreUsuario);
				    Comida comida = Comida.getComidaConCodigo(codigoComida);
				    
				    Calificacion calificacionOb = new Calificacion(codigoCalificacion,puntaje,comida,usuario,comentario);
				    Calificacion.calificaciones.put(codigoCalificacion, calificacionOb);
				    
				    comida.setCalificacionesComida(calificacionOb);
				    usuario.setCalificacionesUsuario(calificacionOb);
				    
				    Calificacion.setConsecutivoCalificacion(Calificacion.asignacionConsecutivoCalificacion());
				}
			}
			br.close();
	    }catch(Exception e) {
	    	//System.out.println(e);  no es
	    }
	}
	private static void cargarMenus(String ruta) {
		try{
            FileReader fr = new FileReader(ruta + "menusUsuarios.txt");
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
        	e.printStackTrace();
        }
	}
	
	public static void guardarDatos() {
		crearArchivosYDirs();
		String ruta = System.getProperty("user.dir")+"\\src\\temp\\";	
		guardarMesas(ruta);
		guardarMenuDeComidas(ruta);
		guardarDetallesPedido(ruta);
		guardarFacturas(ruta);
		guardarPedidos(ruta);
		guardarCalificaciones(ruta);
		guardarUsuarios(ruta);
		guardarMenus(ruta);
	}
	
	private static void guardarUsuarios(String ruta){
		try {
            FileWriter fwU = new FileWriter(ruta+"usuarios.txt");
            FileWriter fwAdmin = new FileWriter(ruta+"administradores.txt");
            PrintWriter pw = new PrintWriter(fwU);
            PrintWriter pwAdmin = new PrintWriter(fwAdmin);
    		for (Map.Entry<String, Usuario> usuario : Usuario.usuarios.entrySet()) {
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
			for(Map.Entry<String, Mesa> mesa : Mesa.mesas.entrySet()) {
				Mesa mesaOb = mesa.getValue();
				String line = mesaOb.getCodigoMesa() + ";";
				line += mesaOb.getNumeroDeSillas() + ";";
				line += mesaOb.getUsuario();
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
			for(Map.Entry<String, Comida> comida : Comida.menuComidas.entrySet()) {
				Comida comidaOb = comida.getValue();
				String line = comidaOb.getCodigoComida() + ";";
				line += comidaOb.getNombreComida() + ";";
				line+= comidaOb.getPrecioComida() + ";";
				line += comidaOb.getCalorias() + ";";
				line  += comidaOb.getDisponible();
				pw.println(line);
			}
			pw.close();
		}catch(IOException IOe) {
			
		}
	}

	private static void guardarDetallesPedido(String ruta) { 
		try {
			FileWriter fw = new FileWriter(ruta + "detallesPedidos.txt");
			PrintWriter pw = new PrintWriter(fw);
			for(Map.Entry<String, DetallePedido> detPedido : DetallePedido.detallesPedido.entrySet()) {
				DetallePedido dpedidoOb = detPedido.getValue();
				String line = dpedidoOb.getCodigoDetalle() + ";";
				line += dpedidoOb.getCantidad() + ";";
				line += dpedidoOb.getComida().getCodigoComida();
				pw.println(line);
			}
			pw.close();
		}catch(IOException IOe) {
			
		}
	}
	
	private static void guardarPedidos(String ruta) {       
		try {
			FileWriter fw = new FileWriter(ruta + "pedidos.txt");
			PrintWriter pw = new PrintWriter(fw);
			for(Map.Entry<String, Pedido> pedido : Pedido.pedidos.entrySet()) {
				Pedido pedidoOb = pedido.getValue();
				String line = pedidoOb.getCodigoPedido() + ";";
				line += pedidoOb.getUsuario().getNombreUsuario();
			}
			pw.close();
		}catch(IOException IOe) {
			
		}
	}
	private static void guardarFacturas(String ruta) {  
		try {
			FileWriter fw = new FileWriter(ruta + "facturas.txt");
			PrintWriter pw = new PrintWriter(fw);
			for(Map.Entry<String, Factura> factura : Factura.facturas.entrySet()) {
				Factura facturaOb = factura.getValue();
				String line = facturaOb.getCodigoFactura() + ";";
				line += facturaOb.getFecha() +";";
				line += facturaOb.getPedidoFactura().getCodigoPedido();
				pw.println(line);
			}
			pw.close();
		}catch(IOException IOe) {
			
		}
	}
	
	private static void guardarCalificaciones(String ruta) {     
		try {
			FileWriter fw = new FileWriter(ruta + "calificaciones.txt");
			PrintWriter pw = new PrintWriter(fw);
			for(Map.Entry<String, Calificacion> cali : Calificacion.calificaciones.entrySet()) {
				Calificacion calificacionOb = cali.getValue();
				String line = calificacionOb.getCodigoCalificacion() + ";";				
				line += calificacionOb.getPuntaje() + ";";
				line += calificacionOb.getComida().getCodigoComida() + ";";
				line += calificacionOb.getUsuario().getNombreUsuario() + ";";
				line += calificacionOb.getComentario();
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
    		for (Map.Entry<String, MenuDeConsola> menu : MenuDeConsola.menus.entrySet()) {
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
