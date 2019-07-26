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
	public static HashMap<String, Pedido> pedidos = new HashMap<String, Pedido>();//String= Códigodel pedido	
	public static HashMap<String, Factura> facturas = new HashMap<String, Factura>(); //String = código de la factura
	public static HashMap<String, DetallePedido> detallesPedido = new HashMap<String, DetallePedido>(); //String = codigo de el detalle
	public static ArrayList<Calificacion> calificaciones = new ArrayList<Calificacion>(); 

	
	public static void cargarDatos() {
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
            String line3;
            String line2;
            while(((line = br.readLine()) != null) && ((line3 = br.readLine()) != null) && (line2 = br.readLine()) != null){
            	if (!line.isEmpty()) {
            		String [] usuario = line.split(";");
            		String nombreUsuario = usuario[0];
            		String nombre = usuario[1];
            		String correo = usuario[2];
            		String contraseña = usuario[3];
            		Usuario usuario1 = new Usuario(nombre, nombreUsuario, correo, contraseña);
            		String [] ped = line3.split(";");
            		for(String x : ped) {
            			for (Map.Entry<String, Pedido> p : pedidos.entrySet()) {
                			Pedido pO = p.getValue();
                			if(pedidos.containsKey(x)) {
                				if(x.equals(pO.getCodigoP())) {
                					usuario1.setPedidosU(pO);
                					pO.setUsuario(usuario1);
                    			}
                			}
            			}	
            		}
            		String [] cal = line2.split(";");
            		for(String y : cal) {
            			for (Calificacion f: Datos.calificaciones) {
                			if(f.getCodigoCa().equals(y)) {
                					usuario1.setCalificacionesU(f);
                					f.setUsuario(usuario1);
                			}
            			}	
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
	private static void cargarDetallesPedido(String ruta){  //**********************************************DETALLE********************************************************
	    try{
	        FileReader fr = new FileReader(ruta + "detallesPedido.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null) {
				if(!line.isEmpty()) {
				    String [] detalles = line.split(";");
				    String codigo = detalles[0];
				    String cantidad = detalles[1];
				    Comida comidac = Comida.getComidaConCodigo(detalles[2]);
				    String precioTotal = detalles[3];
				    DetallePedido detP = new DetallePedido(codigo, cantidad, comidac, precioTotal);
				    detallesPedido.put(codigo, detP);
				    DetallePedido.setDetallesD(detP);
				}
			}
			br.close();
	    }catch(Exception e) {
	    	
	    }
	}
		
	private static void cargarPedidos(String ruta) {  //********************************************PEDIDO********************************************************
		try {
			FileReader fr = new FileReader(ruta + "pedidos.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null) {
				if(!line.isEmpty()) {
					String [] pedido = line.split(";");
					String codigo = pedido[0];
					Factura factura = Factura.getFacturaConCodigo(pedido[1]);
					String precioTotal = pedido[2];
					
					String [] detalles = Arrays.copyOfRange(pedido, 3, pedido.length);
					Pedido pedidop = new Pedido(codigo, factura, precioTotal);
					
					Pedido.Pedidop(pedidop, detalles);
		    		pedidos.put(codigo, pedidop);
            		Pedido.setPedidosP(pedidop);
            		
            		factura.setPedidoF(pedidop);  //asignarle al atributo factura creado, el pedido
            		Factura factura2 = new Factura(factura.getCodigoF(), factura.getFecha(), factura.getPedidoF()); //sobreescribir el objeto factura con los atributos ya organizados 
            		facturas.put(factura.getCodigoF(), factura2);
            		
            		pedidop.setFactura(factura2);  //asignarle al atributo pedido creado, la factura
            		Pedido pedido2 = new Pedido(pedidop.getCodigoP(), pedidop.getFactura(), pedidop.getPrecioTotal());
            		pedidos.put(pedidop.getCodigoP(), pedido2);
				}
			}
			br.close();
		}catch(Exception e) {
			
		}
	}
	
	private static void cargarFacturas(String ruta){  //********************************************FACTURA*********************************************************
	    try{
	        FileReader fr = new FileReader(ruta + "facturas.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null) {
				if(!line.isEmpty()) {
				    String [] facturas1 = line.split(";");
				    String codigoF = facturas1[0];
				    String fecha = facturas1[1];
				    Factura fact = new Factura(codigoF, fecha);
				    facturas.put(codigoF, fact);
				    Factura.setFacturasF(fact);
				}
			}
			br.close();
	    }catch(Exception e) {
	    	
	    }
	}
	
	private static void cargarCalificaciones(String ruta){     //**************************************CALIFICACIONES************************************************
	    try{
	        FileReader fr = new FileReader(ruta + "calificaciones.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null) {
				if(!line.isEmpty()) {
				    String [] calificacion = line.split(";");
				    String codigo = calificacion[0];
				    String puntaje = calificacion[2];
				    String comentario = calificacion[3];
					Comida comida = Comida.getComidaConCodigo(calificacion[1]);
				    Calificacion cal = new Calificacion(codigo,comida,puntaje,comentario); 
				    calificaciones.add(cal);
				    
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
    		for (Map.Entry<String, Usuario> usuario : usuarios.entrySet()) {
    			Usuario usuarioO = usuario.getValue();
    			String line = usuarioO.getNombreUsuario()+";";
    			line += usuarioO.getNombre()+";";
    			line += usuarioO.getCorreo()+";";
    			line += usuarioO.getContraseña();
    			String line2 = "";
    			String line3 = "";
    			for(Calificacion f : usuarioO.getCalificacionesU()) {//en una tercera línea del txt muestra las calificaciones asociados al usuario
    				line2 += f.getCodigoCa()+";";
    			}
    			for(Pedido p : usuarioO.getPedidosU()) { //en una segunda línea del txt muestra los pedidos asociados al usuario
    				line3 += p.getCodigoP()+";";
    			}
    			if(usuarioO instanceof Administrador) {
    				pwAdmin.println(line);
					
				}else {
					pw.println(line);
					pw.println(line3);
					pw.println(line2);
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
				String line = mesaOb.getCodigoM() + ";";
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

	private static void guardarDetallesPedido(String ruta) { //*****************************************DETALLES****************************************************
		try {
			FileWriter fw = new FileWriter(ruta + "detallesPedidos.txt");
			PrintWriter pw = new PrintWriter(fw);
			for(Map.Entry<String, DetallePedido> detPedido :detallesPedido.entrySet()) {
				DetallePedido dpedidoOb = detPedido.getValue();
				String line = dpedidoOb.getCodigoD() + ";";
				line += dpedidoOb.getPedidoD().getCodigoP() + ";";
				line += dpedidoOb.getCantidad() + ";";
				line += dpedidoOb.getComida().getCodigo() + ";";
				line+= dpedidoOb.getPrecioTotal();
				
				pw.println(line);
			}
			pw.close();
		}catch(IOException IOe) {
			
		}
	}
	
	private static void guardarPedidos(String ruta) {       //********************************************PEDIDO**********************************************
		try {
			FileWriter fw = new FileWriter(ruta + "pedidos.txt");
			PrintWriter pw = new PrintWriter(fw);
			for(Map.Entry<String, Pedido> pedido : pedidos.entrySet()) {
				Pedido pedidoOb = pedido.getValue();
				String line = pedidoOb.getCodigoP() + ";";
				line += pedidoOb.getFactura().getCodigoF() + ";";
				for(DetallePedido dp : pedidoOb.getDetallesP()) {
					line += dp.getCodigoD() + ";";
				}
				line += pedidoOb.getPrecioTotal();
				pw.println(line.substring(0,(line.length()-1)));
			}
			pw.close();
		}catch(IOException IOe) {
			
		}
	}
	private static void guardarFacturas(String ruta) {  //********************************************FACTURA*********************************************************
		try {
			FileWriter fw = new FileWriter(ruta + "facturas.txt");
			PrintWriter pw = new PrintWriter(fw);
			for(Map.Entry<String, Factura> factura : facturas.entrySet()) {
				Factura facturaOb = factura.getValue();
				String line = facturaOb.getCodigoF() + ";";
				line += facturaOb.getFecha();
				pw.println(line);
			}
			pw.close();
		}catch(IOException IOe) {
			
		}
	}
	
	private static void guardarCalificaciones(String ruta) {     //**********************************CALIFICACIÓN****************************************
		try {
			FileWriter fw = new FileWriter(ruta + "calficaciones.txt");
			PrintWriter pw = new PrintWriter(fw);
			for(Calificacion cali : calificaciones) {
				String line = cali.getCodigoCa() + ";";				
				line += cali.getComida().getCodigo() + ";";
				line += cali.getPuntaje() + ";";
				line += cali.getComentario();
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
