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
            //String line3;
            //String line2;
            while(((line = br.readLine()) != null)/* && ((line3 = br.readLine()) != null) && ((line2 = br.readLine()) != null)*/){
            	if (!line.isEmpty()) {
            		String [] usuarioDatos = line.split(";");
            		String nombreUsuario = usuarioDatos[0];
            		String nombre = usuarioDatos[1];
            		String correo = usuarioDatos[2];
            		String contraseña = usuarioDatos[3];
            		Usuario usuario = new Usuario(nombre, nombreUsuario, correo, contraseña);
            		
            		/*TODO: FElipe arregle esto
            		 * String [] ped = line3.split(";");
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
            		}*/
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
            		new Administrador(nombre, nombreUsuario, correo, contraseña);
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
					String codigo = comidas[0];
					String nombre = comidas[1];
					String precio = comidas[2];
					String calorias = comidas[3];
					Comida comida = new Comida(codigo,nombre,Integer.parseInt(calorias),Integer.parseInt(precio));
					Comida.menuComidas.put(codigo, comida);
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
					String ocupada = mesa[2];
					Mesa mesam = new Mesa(codigo, numeroDeSillas, ocupada);
					Mesa.mesas.put(codigo, mesam);
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
				    String codigo = detalles[0];
				    String cantidad = detalles[1];
				    Comida comida = Comida.getComidaConCodigo(detalles[2]);
				    //no se si se va a quitar del todo pero aja
				    int precioTotal = DetallePedido.precioTotalComida(comida.getPrecioComida(), Integer.parseInt(cantidad));
				    String precioTotalString = detalles[3];
				    int cantidadEntero = Integer.parseInt(cantidad);
				    DetallePedido detallePedido = new DetallePedido(codigo, comida, cantidadEntero);
				    DetallePedido.detallesPedido.put(codigo, detallePedido);
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
					String codigo = pedido[0];
					Factura factura = Factura.getFacturaConCodigo(pedido[1]);
					String precioTotal = pedido[2];
					
					String [] detalles = Arrays.copyOfRange(pedido, 3, pedido.length);
					
					//hacer un constructor para esto? REVSISARLO
					Pedido pedidop = new Pedido(codigo, factura, precioTotal);
					
					Pedido.Pedidopedido(pedidop, detalles);
		    		Pedido.pedidos.put(codigo, pedidop);
            		
            		factura.setPedidoFactura(pedidop);  //asignarle al atributo factura creado, el pedido
            		Factura factura2 = new Factura(factura.getCodigoFactura(), factura.getFecha(), factura.getPedidoFactura()); //sobreescribir el objeto factura con los atributos ya organizados 
            		Factura.facturas.put(factura.getCodigoFactura(), factura2);
            		
            		pedidop.setFactura(factura2);  //asignarle al atributo pedido creado, la factura
            		Pedido pedido2 = new Pedido(pedidop.getCodigoPedido(), pedidop.getFactura(), pedidop.getPrecioTotal());
            		Pedido.pedidos.put(pedidop.getCodigoPedido(), pedido2);
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
				    Factura factura0 = new Factura(codigoFactura, fecha);
				    Factura.facturas.put(codigoFactura, factura0);
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
				    String puntaje = calificacion[2];
				    String comentario = calificacion[3];
					Comida comida = Comida.getComidaConCodigo(calificacion[1]);
				    Calificacion cal = new Calificacion(codigoCalificacion,comida,Integer.parseInt(puntaje),comentario); 
				    Calificacion.calificaciones.add(cal);
				    
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
    			line += usuarioO.getContraseña()+";";
    			line += usuarioO.getMiCarrito();
    			/*String line2 = "";
    			String line3 = "";
    			for(Calificacion f : usuarioO.getCalificacionesUsuario()) {//en una tercera línea del txt muestra las calificaciones asociados al usuario
    				line2 += f.getCodigoCa()+";";
    			}
    			for(Pedido p : usuarioO.getPedidosUsuario()) { //en una segunda línea del txt muestra los pedidos asociados al usuario
    				line3 += p.getCodigoPedido()+";";
    			}*/
    			if(usuarioO instanceof Administrador) {
    				pwAdmin.println(line);
					
				}else {
					pw.println(line);
					/*pw.println(line3.substring(0,(line3.length()-1)));
					pw.println(line2.substring(0,(line2.length()-1)));*/
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
				line += mesaOb.getUsuario() + ";";
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
				line += comidaOb.getCalorias();
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
				line += dpedidoOb.getPedidoDetalle().getCodigoPedido() + ";";
				line += Integer.toString(dpedidoOb.getCantidad()) + ";";
				line += dpedidoOb.getComida().getCodigoComida() + ";";
				//ver si dejar lo del precioTOtalComida y organizarlo ahi
				line+= dpedidoOb.getPrecioTotal();
				
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
				line += pedidoOb.getFactura().getCodigoFactura() + ";";
				for(DetallePedido dp : pedidoOb.getDetallesPedido()) {
					if(dp != null) {
						line += dp.getCodigoDetalle() + ";";
					}
					
				}
				//ver que  hacer con la variable precioTotal de pedido que fue borrad porque se implementará en detalle
				line += pedidoOb.getPrecioTotal(); 
				pw.println(line.substring(0,(line.length()-1)));
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
				line += facturaOb.getFecha();
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
			for(Calificacion cali : Calificacion.calificaciones) {
				String line = cali.getCodigoCa() + ";";				
				line += cali.getComida().getCodigoComida() + ";";
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
