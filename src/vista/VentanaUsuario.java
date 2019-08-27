package vista;

import java.awt.*;
import javax.swing.*;

public class VentanaUsuario extends JFrame {
	Container contenedor;
	JMenu archivo, procesos,ayuda; 
	JMenuItem usuario, salir;
	
	public VentanaUsuario() {
		super("Usuario:");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contenedor = this.getContentPane();
		setVisible(true);
		contenedor.setLayout(new FlowLayout());
		contenedor.setPreferredSize(new Dimension(1300,700));
		JPanel panelGeneral = new JPanel();
		//panelGeneral.setBounds(0, 0, 200, 400);
		panelGeneral.setLayout(new FlowLayout());
		JMenuBar opcionesDeMenu = new JMenuBar();
		archivo = new JMenu("Archivo");
		procesos = new JMenu("Procesos y Consultas");
		ayuda = new JMenu("Ayuda");
		usuario = new JMenuItem("Usuario");
		salir = new JMenuItem("Salir");
		archivo.add(usuario);
		archivo.add(salir);
		JMenuItem acercaDe = new JMenuItem("Acerca de..");
		ayuda.add(acercaDe);
		opcionesDeMenu.add(archivo);
		opcionesDeMenu.add(procesos);
		opcionesDeMenu.add(ayuda);
		panelGeneral.add(opcionesDeMenu);
		
		contenedor.add(panelGeneral);
		
		//
		
		pack();
		setLocationRelativeTo(null);
		

	}

}
