package controlador;

import java.awt.event.*;
import javax.swing.*;

import vista.*;
import main.*;


public class ControlIniciar implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
		String accion = e.getActionCommand();
		if(accion.equals("Administrador")) {
			VentanaPrincipal.textoingrese.setText("Ingrese su nombre de usuario y su contraseña:");
			VentanaPrincipal.nombreUsuario.setText("Nombre de Usuario");
			VentanaPrincipal.contraseña.setText("Contraseña");
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.nombreUsuario);
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.codigoUsuarioT);
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.contraseña);
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.claveT);
			VentanaPrincipal.admin.setText("Administrador complete y nuevamente clic.");
		}
		else if(accion.equals("Usuario")) {
			VentanaPrincipal.textoingrese.setText("Ingrese su nombre de usuario y su contraseña:");
			VentanaPrincipal.nombreUsuario.setText("Nombre de Usuario");
			VentanaPrincipal.contraseña.setText("Contraseña");
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.nombreUsuario);
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.codigoUsuarioT);
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.contraseña);
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.claveT);
			VentanaPrincipal.usuario.setText("Usuario complete y nuevamente clic.");
		}
		else if(accion.equals("Chef")) {
			VentanaPrincipal.textoingrese.setText("Ingrese su nombre de usuario y su contraseña:");
			VentanaPrincipal.nombreUsuario.setText("Nombre de Usuario");
			VentanaPrincipal.contraseña.setText("Contraseña");
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.nombreUsuario);
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.codigoUsuarioT);
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.contraseña);
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.claveT);
			VentanaPrincipal.chef.setText("Chef complete y nuevamente clic.");

		}
		else if(accion.equals("Usuario complete y nuevamente clic.")) {			
			Principal.ventana.cerrar();
			Principal.ventana = new VentanaUsuario();
			Principal.ventana.arranca();
		}else if(accion.equals("Administrador complete y nuevamente clic.")) {
			Principal.ventana.cerrar();
			Principal.ventana = new VentanaAdministrador();
			Principal.ventana.arranca();
		
		}else if(accion.equals("Chef complete y nuevamente clic.")) {
			Principal.ventana.cerrar();
			Principal.ventana = new VentanaChef();
			Principal.ventana.arranca();
			
		}else  if(accion.equals("Salir")){
			Object [] textoDeOpciones = {"Si", "No"};
			int opcion = JOptionPane.showOptionDialog(null, "¿Está seguro que desea salir del programa?", "Salir del programa", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, textoDeOpciones, null);
			if(opcion == 0) {
				System.exit(0);
			}
		}
	}

}
