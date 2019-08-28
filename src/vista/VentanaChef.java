package vista;

import java.awt.*;
import javax.swing.*;

import controlador.ControlMenu;

public class VentanaChef extends JFrame implements InterfazVista{
	public static Container contenedor;
	JMenu archivo, procesos,ayuda; 
	JMenuItem usuario, salir, verComidaMejor, verCalificacionComida, verComidaMasPedida, crearComida, verMenu;
	
	public VentanaChef() {
		super("Chef:");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contenedor = this.getContentPane();
		setVisible(false);
		contenedor.setLayout(new FlowLayout());
		contenedor.setPreferredSize(new Dimension(1000,700));
		
		
		
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
		acercaDe.addActionListener(new ControlMenu());
		ayuda.add(acercaDe);
		
				
		//menu procesos
		verComidaMejor = new JMenuItem("Ver la comida mejor calificada");
		verCalificacionComida = new JMenuItem("Ver calificacion de una comida");
		verComidaMasPedida = new JMenuItem("Ver la comida más pedida");
		crearComida = new JMenuItem("Crear comidas para el menú");
		verMenu = new JMenuItem("Ver menú de comidas");
		verComidaMejor.addActionListener(new ControlMenu());
		verCalificacionComida.addActionListener(new ControlMenu());
		verComidaMasPedida.addActionListener(new ControlMenu());
		crearComida.addActionListener(new ControlMenu());
		verMenu.addActionListener(new ControlMenu());
		procesos.add(crearComida);
		procesos.add(verMenu);
		procesos.add(verComidaMejor);
		procesos.add(verCalificacionComida);
		procesos.add(verComidaMasPedida);


		opcionesDeMenu.add(archivo);
		opcionesDeMenu.add(procesos);
		opcionesDeMenu.add(ayuda);
		
		setJMenuBar(opcionesDeMenu);
		
		//

	}
	@Override
	public void arranca() {
		pack();
		String ruta = System.getProperty("user.dir")+ "\\src\\vista\\images\\";
		ImageIcon ImageIcon = new ImageIcon(ruta + "images.png");
		Image imagen = ImageIcon.getImage();
		setIconImage(imagen);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void cerrar() {
		this.setVisible(false);
		this.dispose();
	}
}