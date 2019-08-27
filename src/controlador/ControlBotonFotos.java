package controlador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import vista.VentanaPrincipal;
	

public class ControlBotonFotos implements ActionListener {
	int contador = 0;
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		String evento = e.getActionCommand();
		if(evento.equals("BotonFotos")) {
			VentanaPrincipal.foto = new ImageIcon("B1.png");
			VentanaPrincipal.icono = new ImageIcon(VentanaPrincipal.foto.getImage().getScaledInstance(VentanaPrincipal.botonFotos.getWidth(), VentanaPrincipal.botonFotos.getHeight(), Image.SCALE_DEFAULT));
			VentanaPrincipal.botonFotos.setIcon(VentanaPrincipal.icono);
			contador++;
			if(contador == 1) {
				VentanaPrincipal.foto = new ImageIcon("foto1.jpg");
				VentanaPrincipal.icono = new ImageIcon(VentanaPrincipal.foto.getImage().getScaledInstance(VentanaPrincipal.botonFotos.getWidth(), VentanaPrincipal.botonFotos.getHeight(), Image.SCALE_DEFAULT));
				VentanaPrincipal.botonFotos.setIcon(VentanaPrincipal.icono);
			}
			else if(contador == 2) {
				VentanaPrincipal.foto = new ImageIcon("foto2.jpg");
				VentanaPrincipal.icono = new ImageIcon(VentanaPrincipal.foto.getImage().getScaledInstance(VentanaPrincipal.botonFotos.getWidth(), VentanaPrincipal.botonFotos.getHeight(), Image.SCALE_DEFAULT));
				VentanaPrincipal.botonFotos.setIcon(VentanaPrincipal.icono);
			}
			else if(contador == 3) {
				VentanaPrincipal.foto = new ImageIcon("B1.png");
				VentanaPrincipal.icono = new ImageIcon(VentanaPrincipal.foto.getImage().getScaledInstance(VentanaPrincipal.botonFotos.getWidth(), VentanaPrincipal.botonFotos.getHeight(), Image.SCALE_DEFAULT));
				VentanaPrincipal.botonFotos.setIcon(VentanaPrincipal.icono);
				contador = 0;
			}
		}
		
		
	}

}
