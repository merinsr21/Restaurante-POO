package vista;

import java.awt.*;
import javax.swing.*;

import controlador.ControlMenu;
import uiMain.Main;

public class VentanaUsuario extends JFrame implements InterfazVista{
	public static Container contenedor;
	JMenu archivo, procesos,ayuda; 
	JMenuItem usuario, salir, verMenu, miCarrito, verFacturas, verPedidos, verMesas;
	
	public VentanaUsuario() {
		super("Usuario:" );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contenedor = this.getContentPane();
		setVisible(false);
		contenedor.setLayout(new FlowLayout());
		contenedor.setPreferredSize(new Dimension(1000,700));
		JPanel panelGeneral = new JPanel();
		panelGeneral.setLayout(new FlowLayout());
		
		//menu general
		JMenuBar opcionesDeMenu = new JMenuBar();
		archivo = new JMenu("Archivo");
		procesos = new JMenu("Procesos y Consultas");
		ayuda = new JMenu("Ayuda");
		
		//menu del archivo
		usuario = new JMenuItem("Usuario");
		salir = new JMenuItem("Salir");
		salir.addActionListener(new ControlMenu());
		archivo.add(usuario);
		archivo.add(salir);
		
		//menu de ayuda
		JMenuItem acercaDe = new JMenuItem("Acerca de..");
		acercaDe.addActionListener(new ControlMenu());
		ayuda.add(acercaDe);
		
		//menu de procesos
		verMenu = new JMenuItem("Ver Menú de Comidas");
		miCarrito = new JMenuItem("Ver mi Carrito");
		verFacturas = new JMenuItem("Ver mis Facturas");
		verPedidos = new JMenuItem("Ver mis Pedidos");
		verMesas = new JMenuItem("Ver mesas disponibles");
		verMenu.addActionListener(new ControlMenu());
		miCarrito.addActionListener(new ControlMenu());
		verFacturas.addActionListener(new ControlMenu());
		verPedidos.addActionListener(new ControlMenu());
		verMesas.addActionListener(new ControlMenu());
		procesos.add(verMenu);
		procesos.add(miCarrito);
		procesos.add(verFacturas);
		procesos.add(verPedidos);
		procesos.add(verMesas);
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
