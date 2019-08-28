package controlador;

import java.awt.event.*;
import javax.swing.*;

import vista.*;
import main.*;
import modelo.Excepciones.*;
import modelo.gestorAplicacion.users.Usuario;


public class ControlIniciar implements ActionListener{
	
	public void actionPerformed(ActionEvent e) {
		String accion = e.getActionCommand();
		if(accion.equals("Administrador")) {
			VentanaPrincipal.textoingrese.setText("Ingrese su nombre de usuario y su contraseña:");
			VentanaPrincipal.nombreUsuario.setText("Nombre de Usuario");
			VentanaPrincipal.contraseña.setText("Contraseña");
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.nombreUsuario);
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.nombreUsuarioT);
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.contraseña);
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.contraseñaT);
			VentanaPrincipal.admin.setText("Administrador complete y nuevamente clic.");
		}
		else if(accion.equals("Usuario")) {
			VentanaPrincipal.textoingrese.setText("Ingrese su nombre de usuario y su contraseña:");
			VentanaPrincipal.nombreUsuario.setText("Nombre de Usuario");
			VentanaPrincipal.contraseña.setText("Contraseña");
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.nombreUsuario);
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.nombreUsuarioT);
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.contraseña);
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.contraseñaT);
			VentanaPrincipal.usuario.setText("Usuario complete y nuevamente clic.");
		}
		else if(accion.equals("Chef")) {
			VentanaPrincipal.textoingrese.setText("Ingrese su nombre de usuario y su contraseña:");
			VentanaPrincipal.nombreUsuario.setText("Nombre de Usuario");
			VentanaPrincipal.contraseña.setText("Contraseña");
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.nombreUsuario);
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.nombreUsuarioT);
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.contraseña);
			VentanaPrincipal.panelDatos.add(VentanaPrincipal.contraseñaT);
			VentanaPrincipal.chef.setText("Chef complete y nuevamente clic.");

		}
		else if(accion.equals("Usuario complete y nuevamente clic.")) {			
			try {
				 if(VentanaPrincipal.contraseñaT.getText().isEmpty() && VentanaPrincipal.nombreUsuarioT.getText().isEmpty() || VentanaPrincipal.contraseñaT.getText().isEmpty() ||  VentanaPrincipal.nombreUsuarioT.getText().isEmpty()) {
						throw new ErrorCamposIncompletos();
				}else {
					Principal.ventana.cerrar();
					Principal.ventana = new VentanaUsuario();
					Principal.ventana.arranca();
				}
			}catch(ErrorCamposIncompletos ex ){
				JOptionPane.showMessageDialog(null, "Manejo de errores de la Aplicación: Por favor llene los campos vacíos para continuar", "¡¡CUIDADO!!", JOptionPane.ERROR_MESSAGE );	
			}
			
			
			
		}else if(accion.equals("Administrador complete y nuevamente clic.")) {
			try {
				 if(VentanaPrincipal.contraseñaT.getText().isEmpty() && VentanaPrincipal.nombreUsuarioT.getText().isEmpty() || VentanaPrincipal.contraseñaT.getText().isEmpty() ||  VentanaPrincipal.nombreUsuarioT.getText().isEmpty()) {
						throw new ErrorCamposIncompletos();
				}else if(Usuario.iniciarSesion(VentanaPrincipal.nombreUsuarioT.getText(), VentanaPrincipal.contraseña.getText()) == false) {
					throw new ErrorDatosErroneos();
				}
				 else {
					Principal.ventana.cerrar();
					Principal.ventana = new VentanaAdministrador();
					Principal.ventana.arranca();
				}
			}catch(ErrorCamposIncompletos ex){
				JOptionPane.showMessageDialog(null, "Manejo de errores de la Aplicación: Por favor llene los campos vacíos para continuar", "¡¡CUIDADO!!", JOptionPane.ERROR_MESSAGE );	
			}catch(ErrorDatosErroneos exd) {
				JOptionPane.showMessageDialog(null, "Manejo de errores de la Aplicación: Los datos ingresados no son correctos", "¡¡ALERTA!!", JOptionPane.ERROR_MESSAGE );	
			}
			
			
			
		}else if(accion.equals("Chef complete y nuevamente clic.")) {
			try {
				 if(VentanaPrincipal.contraseñaT.getText().isEmpty() && VentanaPrincipal.nombreUsuarioT.getText().isEmpty() || VentanaPrincipal.contraseñaT.getText().isEmpty() ||  VentanaPrincipal.nombreUsuarioT.getText().isEmpty()) {
						throw new ErrorCamposIncompletos();
				}else {
					Principal.ventana.cerrar();
					Principal.ventana = new VentanaChef();
					Principal.ventana.arranca();
				}
			}catch(ErrorCamposIncompletos ex ){
				JOptionPane.showMessageDialog(null, "Manejo de errores de la Aplicación: Por favor llene los campos vacíos para continuar", "¡¡CUIDADO!!", JOptionPane.ERROR_MESSAGE );	
			}
			
		}else  if(accion.equals("Salir")){
			Object [] textoDeOpciones = {"Si", "No"};
			int opcion = JOptionPane.showOptionDialog(null, "¿Está seguro que desea salir del programa?", "Salir del programa", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, textoDeOpciones, null);
			if(opcion == 0) {
				System.exit(0);
			}
		}
	}
	
	/*public void metodoCamposIncompletos() throws ErrorCamposIncompletos{
		if(VentanaPrincipal.nombreUsuarioT.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Por favor llene el campo de nombre de Usuario para continuar", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE );
		}else if(VentanaPrincipal.contraseñaT.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Por favor llene el campo de contraseña para continuar", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE );
		}else if(VentanaPrincipal.contraseñaT.getText().isEmpty() && VentanaPrincipal.nombreUsuarioT.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Por favor llene los campos vacíos para continuar", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE );
		}
		throw new ErrorCamposIncompletos();
		
		
	}*/

}
