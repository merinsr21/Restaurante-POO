package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import controlador.*;

public class VentanaPrincipal extends JFrame implements InterfazVista{
	public static Container contenedor;
	public static JButton admin, usuario, chef, botonFotos;
	public static JLabel textoingrese, nombreUsuario, contraseña, labelBienvenido;
	public static JPanel panelDatos;
	public static JTextField nombreUsuarioT;
	public static JPasswordField contraseñaT;
	public static ImageIcon foto, icono;
	public static JFrame ventana;
	
	public VentanaPrincipal() {
		super("Restaurante");
		ventana = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contenedor = this.getContentPane();
		setVisible(true);
		contenedor.setLayout(new GridLayout(1,2));
		contenedor.setPreferredSize(new Dimension(1000, 700));
		setResizable(false);
		
		//Panel para el JLabel que aparece de bienvenido y el boton de fotos, a la izquierda
		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel1.setBorder(new LineBorder(Color.BLACK));
		contenedor.add(panel1);
		
		//panel de la derecha del contenedor donde va la descripcion y el inicio
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(3,1,5,5));
		panel2.setBorder(new LineBorder(Color.BLACK));
		contenedor.add(panel2);

		//Panel donde esta el label de bienvenido
		JPanel panel3 = new JPanel();
		labelBienvenido = new JLabel("¡Bienvenido!");
		labelBienvenido.addMouseListener(new ControlLabelBienvenido());
		labelBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		labelBienvenido.setFont(new Font("arial", Font.HANGING_BASELINE, 30));
		panel3.add(labelBienvenido);
		panel1.add(panel3);
		
		//Panel para el boton de las fotos
		JPanel panel4 = new JPanel();
		String ruta = System.getProperty("user.dir")+ "\\src\\vista\\images\\";
		foto = new ImageIcon(ruta + "B1.png");
		botonFotos = new JButton();
		botonFotos.setBounds(0, 0, 400, 400);
		icono = new ImageIcon(foto.getImage().getScaledInstance(botonFotos.getWidth(), botonFotos.getHeight(), Image.SCALE_SMOOTH));
		botonFotos.setIcon(icono);
		botonFotos.setBackground(Color.WHITE);
		botonFotos.addActionListener(new ControlBotonFotos());
		botonFotos.setActionCommand("BotonFotos");
		panel4.add(botonFotos);
		panel1.add(panel4);
		
		//panel para el scroll del texto
		JPanel panel5 = new JPanel();
		TextArea texto = new TextArea("El Restaurante es una aplicación gratuita de escritorio implementada en java, que sirve como herramienta cliente/servidor para la gestión de Bases de Datos de un restaurante en tiempo real.\r\n" + 
				"Permitiendo la creación de usuarios, la gestión de pedidos, productos, facturas y precios. \r\n" + 
				"Desarrollado por: Laura Vanesa Bustamante Hurtado, Cristian Alejandro Rojas Mazo, Felipe Merino Toro y Alejandro Gómez Serna. \r\n" + 
				"Este programa funciona gracias a la implementación del patrón MVC. Continuará...", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
		texto.setFont(new Font("arial", Font.HANGING_BASELINE, 15));
		texto.setEditable(false);
		texto.setBackground(Color.WHITE);
		panel5.add(texto);
		panel2.add(panel5);
		
		//panel de la entrada de datos para iniciar
		JPanel panel6 = new JPanel();
		panel6.setLayout(new BorderLayout());
		
		//panel para los botones de arriba
		JPanel panel7 = new JPanel();
		panel7.setLayout(new GridLayout(1,3,10,5));
		admin = new JButton("Administrador");
		usuario = new JButton("Usuario");
		chef = new JButton("Chef");
		admin.setPreferredSize(new Dimension(500,80));
		admin.addActionListener(new ControlIniciar());
		usuario.addActionListener(new ControlIniciar());
		chef.addActionListener(new ControlIniciar());
		panel7.add(admin);
		panel7.add(usuario);
		panel7.add(chef);
		panel6.add(panel7, BorderLayout.NORTH);
		
		//agrego el label de ingresar, al panel
		textoingrese = new JLabel("");
		textoingrese.setHorizontalAlignment(SwingConstants.CENTER);
		panel6.add(textoingrese, BorderLayout.CENTER);
		
		//panel para el ingreso de datos
		panelDatos = new JPanel();
		panelDatos.setLayout(new GridLayout(2,2));
		nombreUsuario = new JLabel("Nombre de Usuario");
		contraseña = new JLabel("Contraseña");
		nombreUsuarioT = new JTextField();
		contraseñaT = new JPasswordField();
		
		
		panel6.add(panelDatos, BorderLayout.SOUTH);
		
		panel2.add(panel6);
		
		//panel para que el boton salir aparezca centrado
		JPanel panelBotonSalir = new JPanel();
		panelBotonSalir.setLayout(null);
		JButton salir = new JButton("Salir");
		salir.addActionListener(new ControlIniciar());
		salir.setBounds(150,80,200,100);
		panelBotonSalir.add(salir);
		panel2.add(panelBotonSalir);

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
