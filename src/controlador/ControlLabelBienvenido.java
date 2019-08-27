package controlador;

import java.awt.Color;
import java.awt.event.*;
import vista.*;

public class ControlLabelBienvenido implements MouseListener{


	@Override
	public void mouseEntered(MouseEvent e) {
		VentanaPrincipal.labelBienvenido.setForeground(Color.BLUE);		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		VentanaPrincipal.labelBienvenido.setForeground(Color.BLACK);			
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub		
	}
	
}
