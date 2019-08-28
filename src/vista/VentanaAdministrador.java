package vista;

import java.awt.*;
import javax.swing.*;

import controlador.ControlMenu;

public class VentanaAdministrador extends JFrame implements InterfazVista {
	public static Container contenedor;
	JMenu archivo, procesos,ayuda; 
	JMenuItem usuario, salir, crearMesa, verMesas, crearComida, verMenu, gananciaDia, gananciaMes, crearUsuario;
	
	public VentanaAdministrador() {
		super("Administrador:");
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
		acercaDe.addActionListener(new ControlMenu());
		ayuda.add(acercaDe);
		
		//menu procesos
		crearMesa = new JMenuItem("Crear mesas");
		verMesas = new JMenuItem("Ver mesas disponibles");	
		gananciaDia = new JMenuItem("Ver Ganancias del día");
		gananciaMes = new JMenuItem("Ver ganancias del mes");
		crearUsuario = new JMenuItem("Crear un nuevo Usuario");
		procesos.add(crearUsuario);
		procesos.add(crearMesa);
		procesos.add(verMesas);
		procesos.add(gananciaDia);
		procesos.add(gananciaMes);

		
		
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