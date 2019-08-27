package controlador;

import java.awt.event.*;
import javax.swing.*;

import vista.*;



public class ControlIniciar implements ActionListener{
	
	
	public void actionPerformed(ActionEvent ae) {
		String accion = ae.getActionCommand();
		if(accion.equals("Administrador")) {
			VentanaPrincipal.textoingrese.setText("Ingrese su nombre de usuario y su contraseña:");
			VentanaPrincipal.nombreUsuario.setText("Nombre de Usuario");
			VentanaPrincipal.contraseña.setText("Contraseña");
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.nombreUsuario);
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.codigoUsuarioT);
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.contraseña);
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.claveT);
			VentanaPrincipal.admin.setText("Administrador complete y\n"+" nuevamente clic.");
		}else if(accion.equals("Usuario")) {
			VentanaPrincipal.textoingrese.setText("Ingrese su nombre de usuario y su contraseña:");
			VentanaPrincipal.nombreUsuario.setText("Nombre de Usuario");
			VentanaPrincipal.contraseña.setText("Contraseña");
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.nombreUsuario);
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.codigoUsuarioT);
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.contraseña);
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.claveT);
			VentanaPrincipal.usuario.setText("Usuario complete y\n"+" nuevamente clic.");
		}else if(accion.equals("Chef")) {
			VentanaPrincipal.textoingrese.setText("Ingrese su nombre de usuario y su contraseña:");
			VentanaPrincipal.nombreUsuario.setText("Nombre de Usuario");
			VentanaPrincipal.contraseña.setText("Contraseña");
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.nombreUsuario);
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.codigoUsuarioT);
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.contraseña);
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.claveT);
			VentanaPrincipal.chef.setText("Chef complete y\n"+" nuevamente clic.");
		}else if(accion.equals("Usuario complete y nuevamente clic.")) {
			
			
		}else if(accion.equals("Salir")){
			System.exit(0);
		}else {
			
		}
	}

}
