package vista;

import java.awt.*;
import javax.swing.*;

import controlador.ControlMenu;

public class VentanaChef extends JFrame implements InterfazVista{
	public static Container contenedor;
	JMenu archivo, procesos,ayuda; 
	JMenuItem usuario, salir, verComidaMejor, verCalificacionComida, verComidaMasPedida, crearComida, verMenu;
	
	public VentanaChef() {
		super("Usuario:");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contenedor = this.getContentPane();
		setVisible(false);
		contenedor.setLayout(new FlowLayout());
		contenedor.setPreferredSize(new Dimension(1000,700));
		JPanel panelGeneral = new JPanel();
		//panelGeneral.setBounds(0, 0, 200, 400);
		panelGeneral.setLayout(new FlowLayout());
		
		//menu general
		JMenuBar opcionesDeMenu = new JMenuBar();
		archivo = new JMenu("Archivo");
		procesos = new JMenu("Procesos y Consultas");
		ayuda = new JMenu("Ayuda");
				
		//menu archivo
		usuario = new JMenuItem("Usuario");
		salir = new JMenuItem("Salir");
		salir.addActionListener(new ControlMenu());
		archivo.add(usuario);
		archivo.add(salir);
				
		//menu ayuda
		JMenuItem acercaDe = new JMenuItem("Acerca de..");
		ayuda.add(acercaDe);
				
		//menu procesos
		verComidaMejor = new JMenuItem("Ver la comida mejor calificada");
		verCalificacionComida = new JMenuItem("Ver calificacion de una comida");
		verComidaMasPedida = new JMenuItem("Ver la comida más pedida");
		crearComida = new JMenuItem("Crear comidas para el menú");
		verMenu = new JMenuItem("Ver menú de comidas");
		procesos.add(crearComida);
		procesos.add(verMenu);
		procesos.add(verComidaMejor);
		procesos.add(verCalificacionComida);
		procesos.add(verComidaMasPedida);


		opcionesDeMenu.add(archivo);
		opcionesDeMenu.add(procesos);
		opcionesDeMenu.add(ayuda);
		panelGeneral.add(opcionesDeMenu);
		
		contenedor.add(panelGeneral);
		
		//

	}
	@Override
	public void arranca() {
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void cerrar() {
		this.setVisible(false);
		this.dispose();
	}
}