package BaseDatos;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;


import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import gestorAplicacion.users.Administrador;
import gestorAplicacion.users.Usuario;
import uiMain.MenuDeConsola;
import uiMain.OpcionDeMenu;

public class Datos {
	public static HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();
	public static HashMap<String, MenuDeConsola> menus = new HashMap<String, MenuDeConsola>();
	public static HashMap<String, OpcionDeMenu> funcionalidades = new HashMap<String, OpcionDeMenu>();
	
	public static void cargarDatos() {
		crearArchivosYDirs();
		String ruta = System.getProperty("usuario.dir")+"\\src\\temp\\";
		cargarUsuarios(ruta);
		cargarAdmins(ruta);
		CargarMenus(ruta);
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
            		new Usuario(nombre, nombreUsuario, correo, contraseña);
            	}
            }
            br.close();
        }catch(Exception e){
            //Error al leer
        	System.out.println(e);
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
	
	private static void CargarMenus(String ruta) {
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
        	//Error al leer
        }
	}
	
	public static void guardarDatos() {
		crearArchivosYDirs();
		String ruta = System.getProperty("usuario.dir")+"\\src\\temp\\";
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
    			Usuario userObj = usuario.getValue();
    			String line = userObj.getNombreUsuario()+";";
    			line += userObj.getNombre()+";";
    			line += userObj.getCorreo()+";";
    			line += userObj.getContraseña();
    			if(userObj instanceof Administrador) {
    				pwAdmin.println(line);
					
				}else {
					pw.println(line);
    			}
    		}
            pw.close();
            pwAdmin.close();
            
        } catch (IOException ioObj) {
        	//Ocurrio algo al guardar en txt los datos
        }
	}
	
	private static void guardarMenus(String ruta){
		try {
            FileWriter fw = new FileWriter(ruta+"menusUsuarios.txt");
            PrintWriter pw = new PrintWriter(fw);
    		for (Map.Entry<String, MenuDeConsola> menu : menus.entrySet()) {
    			MenuDeConsola menuObj = menu.getValue();
    			String line = menuObj.getUser().getNombreUsuario()+";";
    			for (String  op : menuObj.getFuncionalidades()) {
    				line += op+";";
				}
    			//Correccion por el ; extra
    			pw.println(line.substring(0,(line.length()-1)));
    		}
            pw.close();
            
        } catch (IOException ioObj) {
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
		File archivoRegistradoUsuarios = new File(ruta+"usuarios.txt");
		File archivoAdmin = new File(ruta+"administradores.txt");
		File menusUsuarios = new File(ruta+"menusUsuarios.txt");
		archivoRegistradoUsuarios.createNewFile();
		archivoAdmin.createNewFile();
		}
		catch(IOException e){
			//Ocurrio algo al crear las carpetas y los archivos
		}
	}
}
